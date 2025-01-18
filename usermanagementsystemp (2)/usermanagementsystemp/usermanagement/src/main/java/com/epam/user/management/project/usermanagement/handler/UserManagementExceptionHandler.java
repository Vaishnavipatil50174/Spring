package com.epam.user.management.project.usermanagement.handler;

import com.epam.user.management.project.usermanagement.exception.InvalidUserException;
import com.epam.user.management.project.usermanagement.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class UserManagementExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        ProblemDetail problemDetail = ProblemDetail.
                forStatusAndDetail(HttpStatus.BAD_REQUEST, "Request is invalid");
        Map<String,Object> errorMap = errors.stream().collect(Collectors.toMap(x->x.getField(), x->x.getDefaultMessage()));
        problemDetail.setProperties(errorMap);
        return problemDetail;

    }

    @ExceptionHandler(UserException.class)
    public ProblemDetail userException(UserException userException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "User exception");
        problemDetail.setTitle(userException.getMessage());
        return problemDetail;

    }

    @ExceptionHandler(InvalidUserException.class)
    public ProblemDetail invalidUserException(InvalidUserException invalidUserException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "User exception");
        problemDetail.setTitle(invalidUserException.getMessage());
        return problemDetail;

    }
}
