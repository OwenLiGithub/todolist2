package com.oocl.todolist.controller;

import com.oocl.todolist.exceptions.SameNameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(SameNameException.class)
    public String handleSameNameException(SameNameException e){
        return e.getMessage();
    }
}
