package com.chitranshi21.springbootbasics.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDto {

    private String key;
    private String name;
    private Date createdDate;
}
