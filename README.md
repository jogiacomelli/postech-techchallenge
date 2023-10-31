# postech-techchallenge

Para executar aplicação via docker-compose:
- Baixar arquivo docker compose https://drive.google.com/drive/folders/1yqoHpguwbWh8TqlQM49Hq9FCp5ew4iJH
- Executar comando docker-compose up -d
- Será iniciado 2 containers: 1 com a api via imagem do dockerhub e 1 com o banco mysql.

Para executar aplicação via IDE:
- Na raiz do projeto executar docker-compose up -d para subir container com banco de dados.
- Configurar o uso do lombook na IDE.
- Startar aplicação pela classe Application, durante inicialização o flyway irá executar o script com a criação das tabelas.

Para acessar o swagger:
- http://localhost:8080/swagger-ui/index.html
