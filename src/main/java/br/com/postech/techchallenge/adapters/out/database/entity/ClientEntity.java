package br.com.postech.techchallenge.adapters.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "client")
public class ClientEntity {

  @Id
  @Column(name = "cpf")
  private String cpf;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @Column(name = "registration_date", insertable = false, updatable = false)
  private LocalDateTime registrationDate;
}