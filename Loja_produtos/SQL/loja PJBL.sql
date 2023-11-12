
CREATE TABLE `loja`.`perifericos` (
  `ID_periferico` INT NOT NULL,
  `nome_per` VARCHAR(45) NOT NULL,
  `preco` FLOAT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`ID_periferico`));
CREATE TABLE `loja`.`hardware` (
  `ID_Hardware` INT NOT NULL,
  `Nome_Har` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `preco` FLOAT NOT NULL,
  `quantidade` INT NOT NULL,
  `descricao` VARCHAR(500) NOT NULL);
ALTER TABLE `loja`.`perifericos` 
ADD COLUMN `quantidade` INT NOT NULL AFTER `descricao`;

SELECT * FROM loja.perifericos;
INSERT INTO `loja`.`perifericos` (`ID_periferico`, `nome_per`, `preco`, `marca`, `descricao`, `quantidade`) VALUES ('1', 'Mouse MX Master 3', '79.99', 'Logitech', 'Mouse premium com rastreamento de alta precisão', '15');
INSERT INTO `loja`.`perifericos` (`ID_periferico`, `nome_per`, `preco`, `marca`, `descricao`, `quantidade`) VALUES ('2', 'Teclado mecanico K95 RGB', '149.99', 'Corsair', 'Teclado mecanico com iluminação RGB personalizavel', '8'
);
INSERT INTO `loja`.`perifericos` (`ID_periferico`, `nome_per`, `preco`, `marca`, `descricao`, `quantidade`) VALUES ('3', 'Monitor UltraSharp u2719d', '349.99', 'Dell', 'Monitor de 27\'\' com resolução 2k e nucleos precisos', '5'
);
INSERT INTO `loja`.`perifericos` (`ID_periferico`, `nome_per`, `preco`, `marca`, `descricao`, `quantidade`) VALUES ('4', 'Fone de ouvido WH-1000XM$', '299.99', 'Sony', 'Fones de ouvido com cancelamento de ruido e qualidade de audio excepcioal', '10');
INSERT INTO `loja`.`perifericos` (`ID_periferico`, `nome_per`, `preco`, `marca`, `descricao`, `quantidade`) VALUES ('5', 'impressora Laserjet PRO M404dn', '199.99', 'HP', 'Impressora de jato de tinta com tanques de tinta recarregaveis', '20');

ALTER TABLE `loja`.`hardware` 
ADD PRIMARY KEY (`ID_Hardware`);

INSERT INTO `loja`.`hardware` (`ID_Hardware`, `Nome_Har`, `marca`, `preco`, `quantidade`, `descricao`) VALUES ('1', 'Processador I9-11900K', 'Intel', '499.99', '7', 'Processador de alta performance com 8 nucleos');
INSERT INTO `loja`.`hardware` (`ID_Hardware`, `Nome_Har`, `marca`, `preco`, `quantidade`, `descricao`) VALUES ('2', 'Placa de video geforce RTX3080', 'NVIDIA', '799.99', '10', 'placa de video de ultima geração com ray tracing');
INSERT INTO `loja`.`hardware` (`ID_Hardware`, `Nome_Har`, `marca`, `preco`, `quantidade`, `descricao`) VALUES ('3', 'memoria Ram Vengeance LPX 32gb', 'Corsair', '129.99', '15', 'Modulos de memoria ddr4 de alta velocidade');
INSERT INTO `loja`.`hardware` (`ID_Hardware`, `Nome_Har`, `marca`, `preco`, `quantidade`, `descricao`) VALUES ('4', 'Disgo rigido(HD) 2TB', 'SEAGATE', '69.99', '20', 'Disgo rigido de 2Terabytes para armazenamento');
INSERT INTO `loja`.`hardware` (`ID_Hardware`, `Nome_Har`, `marca`, `preco`, `quantidade`, `descricao`) VALUES ('5', 'SSD 970 EVO 1TB', 'Samsung', '149.99', '25', 'SSD NVME de alta velocidade para melhorar o desempenho');
ALTER TABLE `loja`.`hardware` 
CHANGE COLUMN `preco` `preco` DOUBLE NOT NULL;
ALTER TABLE `loja`.`perifericos` 
CHANGE COLUMN `preco` `preco` DOUBLE NOT NULL ;



-- Adicionando uma nova coluna formatada 'preco_formatado' à tabela 'perifericos'
ALTER TABLE `loja`.`perifericos`
ADD COLUMN `preco_formatado` VARCHAR(45);

-- Atualizando a nova coluna 'preco_formatado' com os valores formatados
UPDATE `loja`.`perifericos`
SET `preco_formatado` = CONCAT('R$', FORMAT(`preco`, 2));

-- Alterando a coluna 'preco' para o tipo DECIMAL(10, 2)
ALTER TABLE `loja`.`perifericos`
CHANGE COLUMN `preco` `preco` DECIMAL(10, 2) NOT NULL;

-- Removendo a coluna 'preco_formatado' se não for mais necessária
-- ALTER TABLE `loja`.`perifericos`
-- DROP COLUMN `preco_formatado`;

-- Repetindo o mesmo processo para a tabela 'hardware'
ALTER TABLE `loja`.`hardware`
ADD COLUMN `preco_formatado` VARCHAR(45);

UPDATE `loja`.`hardware`
SET `preco_formatado` = CONCAT('R$', FORMAT(`preco`, 2));

ALTER TABLE `loja`.`hardware`
CHANGE COLUMN `preco` `preco` DECIMAL(10, 2) NOT NULL;


