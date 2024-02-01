package br.com.postech.techchallenge.core.domain.entity;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Cliente {
    private String cpf;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
}
