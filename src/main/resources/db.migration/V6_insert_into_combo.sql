-- Pedidos
INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (6, 28.50, 'PENDENTE', true, '2023-09-02 10:30:00');
INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (7, 22.75, 'RECEBIDO', true, '2023-09-02 11:45:00');
INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (8, 18.50, 'EM_PREPARACAO', true, '2023-09-02 13:00:00');
INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (9, 13.75, 'PRONTO', true, '2023-09-02 14:30:00');
INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (10, 20.50, 'FINALIZADO', true, '2023-09-02 15:45:00');

-- Combos
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (6, 11, 16, 21, 1, 28.50, 28.50, 6);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (7, 12, 17, 22, 1, 22.75, 22.75, 7);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (8, 13, 18, 23, 1, 18.50, 18.50, 8);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (9, 14, 19, 24, 1, 13.75, 13.75, 9);
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (10, 15, 20, 25, 1, 20.50, 20.50, 10);

-- Pedidos com status pago false para testar fakeCheckout
INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (6, 10.99 + 5.99 + 4.99 + 7.99, 'PENDENTE', false, '2023-09-02 09:00:00');
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (6, 11, 16, 21, 1, 10.99, 10.99 + 5.99 + 4.99 + 7.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (7, 12.99 + 6.99 + 5.99 + 6.99, 'PENDENTE', false, '2023-09-02 09:45:00');
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (7, 12, 17, 22, 1, 12.99, 12.99 + 6.99 + 5.99 + 6.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (8, 14.99 + 7.99 + 2.99 + 5.99, 'PENDENTE', false, '2023-09-02 10:30:00');
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (8, 13, 18, 23, 1, 14.99, 14.99 + 7.99 + 2.99 + 5.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (9, 9.99 + 8.99 + 3.99 + 4.99, 'PENDENTE', false, '2023-09-02 11:15:00');
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (9, 14, 19, 24, 1, 9.99, 9.99 + 8.99 + 3.99 + 4.99, currval('pedido_id_seq'));

INSERT INTO Pedido (id_cliente, valor_total, status, pago, dt_cadastro) VALUES (10, 11.99 + 4.99 + 2.99 + 6.99, 'PENDENTE', false, '2023-09-02 11:45:00');
INSERT INTO Combo (lanche_id, acompanhamento_id, bebida_id, sobremesa_id, quantidade, valor_unitario, valor_total, pedido_id)
VALUES (10, 15, 20, 25, 1, 11.99, 11.99 + 4.99 + 2.99 + 6.99, currval('pedido_id_seq'));
