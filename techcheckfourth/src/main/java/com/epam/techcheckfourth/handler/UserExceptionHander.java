package com.epam.techcheckfourth.handler;

import com.epam.techcheckfourth.exception.UserNotValid;
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
public class UserExceptionHander {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail problemDetail(MethodArgumentNotValidException ex){
        List<FieldError>er=ex.getBindingResult().getFieldErrors();
        Map<String,Object>errorMap=er.stream()
                .collect(Collectors.toMap(x->x.getField(),x->x.getDefaultMessage()));

        ProblemDetail problemDetail= ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid");
        problemDetail.setProperties(errorMap);
        return problemDetail;

    }

    @ExceptionHandler(UserNotValid.class)
    public ProblemDetail problemDetail(UserNotValid ex){
        ProblemDetail problemDetail=ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());

        problemDetail.setTitle(ex.getMessage());

        return problemDetail;

    }
}
