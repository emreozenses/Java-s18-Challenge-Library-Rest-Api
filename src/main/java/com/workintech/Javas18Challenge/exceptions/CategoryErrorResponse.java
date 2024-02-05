package com.workintech.Javas18Challenge.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime dateTime;

}
