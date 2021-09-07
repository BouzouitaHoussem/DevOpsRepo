package com.cataloguetheway.center.config.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(origins ="*")

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrainingNotFoundException extends RuntimeException {
        public TrainingNotFoundException(String s) {
            super(s);
        }
    }

