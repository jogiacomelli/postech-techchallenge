package br.com.postech.techchallenge.application.ports.out;

public interface VerifyClientRegistrationOutputPort {
  Boolean execute(String cpf);
}
