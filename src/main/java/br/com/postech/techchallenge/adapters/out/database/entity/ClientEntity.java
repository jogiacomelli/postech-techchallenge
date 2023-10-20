package br.com.postech.techchallenge.adapters.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
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

  @Column(name = "registration_date")
  private LocalDateTime registrationDate;

  @OneToMany(mappedBy = "client")
  private List<OrderEntity> orders;
}