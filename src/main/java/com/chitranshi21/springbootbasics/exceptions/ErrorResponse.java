package com.chitranshi21.springbootbasics.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private long timestamp;
}
