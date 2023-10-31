# postech-techchallenge

Para executar aplicação via docker-compose:
- Baixar arquivo docker compose: https://drive.google.com/file/d/1zXiK0iTVQ2k8hMuRldHXo352PzTKN43o/view?usp=drive_link
- Executar comando docker-compose up -d
- Será iniciado 2 containers: 1 com a api via imagem do dockerhub e 1 com o banco mysql.
- A api estará exposta na porta 8080.

Para executar aplicação via IDE:
- Na raiz do projeto executar docker-compose up -d para subir container com banco de dados.
- Configurar o uso do lombook na IDE.
- Startar aplicação pela classe Application, durante inicialização o flyway irá executar o script com a criação das tabelas.

Para acessar o swagger:
- http://localhost:8080/swagger-ui/index.html
