package com.api.restapi.common;


import com.api.restapi.common.model.ApiResponseModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.sql.SQLException;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ControllerExceptionHandler {

    private String message = "";
    private ApiResponseModel responseModel;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResponseModel handle(ConstraintViolationException ex) {

        message = ex.getConstraintViolations().iterator().next().getMessage();
        log.debug("ConstraintViolationException - " + message);

        responseModel = returnResponseModel(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase() + "(" + message + ")");

        return responseModel;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponseModel validErrorHandle(MethodArgumentNotValidException ex) {

        message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        log.debug("MethodArgumentNotValidException - " + message);

        responseModel = returnResponseModel(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase() + "(" + message + ")");

        return responseModel;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class, ServletRequestBindingException.class, TypeMismatchException.class})
    public ApiResponseModel badRequestErrorHandler(Exception e){

        message = e.getMessage();
        log.error("BadRequestError - " + message);
        e.printStackTrace();

        responseModel = returnResponseModel(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase() + "(" + message + ")");

        return responseModel;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiResponseModel notFoundErrorHandler(NotFoundException ex) {

        message = ex.getMessage();
        log.error("NotFoundException - " + ex.getMessage());
        ex.printStackTrace();

        responseModel = returnResponseModel(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase() + "(" + message + ")");

        return responseModel;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class, JsonParseException.class, JsonMappingException.class})
    public ApiResponseModel jsonParsingErrorHandler(Exception e) {

        message = e.getMessage();
        log.error("JsonParsingError - " + e.getMessage());
        e.printStackTrace();

        responseModel = returnResponseModel(ApiCustomStatus.JSON_BIND_ERROR.code(), ApiCustomStatus.JSON_BIND_ERROR.message() + "(" + message + ")");

        return responseModel;
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = { SQLException.class, DataAccessException.class })
    public ApiResponseModel databaseErrorHandler(RuntimeException e, WebRequest req){

        message = e.getMessage();
        log.error("DataBaseAccessError - " + e.getMessage());
        e.printStackTrace();

        responseModel = returnResponseModel(ApiCustomStatus.DATABASE_ACCESS_ERROR.code(), ApiCustomStatus.DATABASE_ACCESS_ERROR.message() + "(" + message + ")");

        return responseModel;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponseModel serverErrorHandler(Exception e) {

        message = e.getMessage();
        log.error("ServerError - " + e.getMessage());
        e.printStackTrace();

        responseModel = returnResponseModel(ApiCustomStatus.INTERNAL_SERVER_ERROR.code(), ApiCustomStatus.INTERNAL_SERVER_ERROR.message() + "(" + message + ")");

        return responseModel;
    }

    private ApiResponseModel returnResponseModel(int errorCode, String message) {

        responseModel = new ApiResponseModel<>(false, errorCode, message);

        return responseModel;
    }
}
