CREATE DATABASE agendajava;

CREATE TABLE `agenda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `apelido` VARCHAR(50) ,
  `nascimento` DATE,
  PRIMARY KEY (`id`)
)