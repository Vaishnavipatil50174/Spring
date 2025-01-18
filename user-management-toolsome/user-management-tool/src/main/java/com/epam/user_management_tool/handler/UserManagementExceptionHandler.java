package com.epam.user_management_tool.handler;

import com.epam.user_management_tool.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class UserManagementExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException ex){
//        List<FieldError> errors = ex.getBindingResult()
//                .getFieldErrors();
//
//        Map<String,Object> errorMap = errors
//                .stream()
//                .collect(Collectors.toMap(x->x.getField(), x->x.getDefaultMessage()));
//
//        ProblemDetail problemDetail = ProblemDetail.
//                forStatusAndDetail(HttpStatus.BAD_REQUEST, "Request is invalid");
//
//        problemDetail.setProperties(errorMap);
//        return problemDetail;
//
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // Collect field validation errors into a Map
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        // Using Map<String, Object> to meet the setProperties() method signature
        Map<String, Object> errorMap = new HashMap<>();
        for (FieldError error : errors) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        // Create and configure ProblemDetail for the response
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Request is invalid");
        problemDetail.setProperties(errorMap);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
    }

    @ExceptionHandler(UserException.class)
    public ProblemDetail handleUserException(UserException ex) {
        ProblemDetail problemDetail = ProblemDetail.
                forStatusAndDetail(HttpStatus.CONFLICT, "Request is invalid");
        problemDetail.setDetail(ex.getMessage());

        return problemDetail;
    }



}
