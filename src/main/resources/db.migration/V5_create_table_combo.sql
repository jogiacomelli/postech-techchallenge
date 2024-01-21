CREATE TABLE IF NOT EXISTS PEDIDO (
  id SERIAL PRIMARY KEY,
  id_cliente BIGINT NOT NULL,
  valor_total DECIMAL(10, 2),
  status VARCHAR(20) NOT NULL,
  pago BOOLEAN NOT NULL,
  dt_cadastro TIMESTAMP,
  dt_alteracao TIMESTAMP
);

CREATE TABLE IF NOT EXISTS COMBO (
  id SERIAL PRIMARY KEY,
  lanche_id BIGINT,
  acompanhamento_id BIGINT,
  bebida_id BIGINT,
  sobremesa_id BIGINT,
  quantidade INT NOT NULL,
  valor_unitario DECIMAL(10, 2) NOT NULL,
  valor_total DECIMAL(10, 2) NOT NULL,
  pedido_id BIGINT,
  FOREIGN KEY(lanche_id) REFERENCES PRODUTO(id),
  FOREIGN KEY(acompanhamento_id) REFERENCES PRODUTO(id),
  FOREIGN KEY(bebida_id) REFERENCES PRODUTO(id),
  FOREIGN KEY(sobremesa_id) REFERENCES PRODUTO(id),
  FOREIGN KEY(pedido_id) REFERENCES PEDIDO(id)
);
