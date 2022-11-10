package com.akurey;

import java.util.Base64;
import java.util.Optional;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import reactor.core.publisher.Mono;

/**
 * AdminFilter
 */
@Filter("/v1/admin/**")
public class AdminFilter implements HttpServerFilter {

    private final Logger log = LoggerFactory.getLogger(AdminFilter.class);

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(final HttpRequest<?> request, ServerFilterChain chain) {
        final Optional<String> token = request.getHeaders().getAuthorization();
        if (token.isEmpty()) {
            return Mono.just(HttpResponse.unauthorized());
        }
        final String encodedUserInfo = token.get().split("\\.")[1];
        final String decodedUserInfo = new String(Base64.getDecoder().decode(encodedUserInfo));
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            final UserInfo userInfo = objectMapper.readValue(decodedUserInfo, UserInfo.class);
            if (/* (userInfo.getRoles() == nul || */ !userInfo.getRoles().contains("Admin")) {
                return Mono.just(HttpResponse.unauthorized());
            }
            return chain.proceed(request);
        } catch (final JsonProcessingException ex) {
            log.error("Cannot convert JSON object", ex);
            return Mono.just(HttpResponse.serverError());
        }

    }

    
}
