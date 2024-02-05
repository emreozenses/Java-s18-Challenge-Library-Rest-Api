package com.workintech.Javas18Challenge.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime dateTime;
}
