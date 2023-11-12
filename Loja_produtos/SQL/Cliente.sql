CREATE DATABASE LOJA;
USE LOJA;

CREATE TABLE `loja`.`cliente` (
  `idCliente` INT NOT NULL,
  `nome_cliente` VARCHAR(45) NOT NULL,
  `cpf` INT NOT NULL,
  --`email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `qtd_compras` INT NOT NULL,
  `numero_cartao` INT NOT NULL,
  PRIMARY KEY (`idCliente`));

SELECT * FROM loja.cliente;
