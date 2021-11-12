package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;  //<- Lombok Library provides all the basic code (Eg.Getters, Setters, equals etc)
/**
 * @Data Annotation for Lombok when used no need to write code for Getter Setter etc
 **/
public @Data class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
