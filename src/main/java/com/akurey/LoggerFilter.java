package com.akurey;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;

/**
 * LoggerFilter
 */
@Filter
public class LoggerFilter implements HttpServerFilter {

    private final Logger log = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        log.info("Message from filter");
        return chain.proceed(request);
    }

}
