CREATE TABLE IF NOT EXISTS Produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(20) NOT NULL
);