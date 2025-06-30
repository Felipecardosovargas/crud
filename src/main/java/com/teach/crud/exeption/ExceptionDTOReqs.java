package com.teach.crud.exeption;

import org.springframework.http.HttpStatus;

public record ExceptionDTOReqs(HttpStatus status, String message) {
}
