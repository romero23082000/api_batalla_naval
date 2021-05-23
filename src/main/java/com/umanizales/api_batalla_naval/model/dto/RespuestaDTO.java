package com.umanizales.api_batalla_naval.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class RespuestaDTO implements Serializable {
    private String message;
    private  Object data;
    private  String error;
}
