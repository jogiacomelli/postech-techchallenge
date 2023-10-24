package br.com.postech.techchallenge.adapters.in.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ClientResponse {
  private String cpf;
  private String name;
  private String email;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dateOfBirth;
}
