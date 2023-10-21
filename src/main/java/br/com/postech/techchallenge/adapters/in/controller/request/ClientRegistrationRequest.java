package br.com.postech.techchallenge.adapters.in.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ClientRegistrationRequest {

  @NotBlank
  @CPF
  private String cpf;

  @NotBlank
  private String name;

  @NotBlank
  @Email
  private String email;

  @NotNull
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate dateOfBirth;
}
