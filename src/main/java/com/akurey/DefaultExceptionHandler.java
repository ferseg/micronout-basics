package com.akurey;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.validation.exceptions.ConstraintExceptionHandler;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Singleton;


/**
 * DefaultExceptionHandler
 */
@Produces
@Singleton
@Replaces(ConstraintExceptionHandler.class)
public class DefaultExceptionHandler 
    implements ExceptionHandler<ConstraintViolationException, HttpResponse<CustomErrorResponse>> {

    private final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Override
    public HttpResponse<CustomErrorResponse> handle(HttpRequest request, ConstraintViolationException exception) {
        log.info(request.getPath());
        final String message = exception.getMessage();
        final CustomErrorResponse errorResponse = new CustomErrorResponse(message, Boolean.FALSE);
        return HttpResponse.badRequest(errorResponse);
    }




    
}
