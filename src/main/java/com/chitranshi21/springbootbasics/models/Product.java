package com.chitranshi21.springbootbasics.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
@Data
public class Product {

    private int id;
    private String key;
    private String name;
    private Date createdDate;
}
