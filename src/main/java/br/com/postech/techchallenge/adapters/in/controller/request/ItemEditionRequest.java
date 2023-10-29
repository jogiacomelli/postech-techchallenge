package br.com.postech.techchallenge.adapters.in.controller.request;

import lombok.Data;

@Data
public class ItemEditionRequest {
    private String name;
    private String description;
    private String price;
    private String type;

}
