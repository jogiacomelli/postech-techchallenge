package br.com.postech.techchallenge.external.config;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    public void configEnviroments() {
        //colocar as variaveis
        String db = "POSTGRES_DB";
        String user = "POSTGRES_USER";
        String password = "POSTGRES_PASSWORD";

    }
}
