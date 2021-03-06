DROP DATABASE IF EXISTS DBTELEFONIA;
CREATE DATABASE DBTELEFONIA;

USE DBTELEFONIA;

CREATE TABLE ENDERECO(
                         IDENDERECO INT NOT NULL AUTO_INCREMENT
    , RUA VARCHAR(100)
    , CEP VARCHAR(8)
    , CIDADE VARCHAR(30)
    , ESTADO VARCHAR(30)
    , UF CHAR(2)
    , NUMERO INTEGER
    , PRIMARY KEY (IDENDERECO)
);



CREATE TABLE CLIENTE (
                         IDCLIENTE INT NOT NULL AUTO_INCREMENT
    , IDENDERECO INT
    , NOME VARCHAR(70)
    , CPF VARCHAR(11)
    , PRIMARY KEY (IDCLIENTE)
    , FOREIGN KEY (IDENDERECO) REFERENCES ENDERECO(IDENDERECO)
);

CREATE TABLE TELEFONE(
                         IDTELEFONE INT NOT NULL AUTO_INCREMENT
    , DDI VARCHAR(3)
    , DDD VARCHAR(3)
    , NUMERO VARCHAR(20)
    , TIPO INT
    , ATIVO BOOLEAN
    , PRIMARY KEY (IDTELEFONE)
);

CREATE TABLE LINHA_TELEFONICA(
                                 IDLINHATELEFONICA INT NOT NULL AUTO_INCREMENT
    ,DT_ATIVACAO DATE
    ,DT_DESATIVACAO DATE
    ,IDCLIENTE INT
    ,IDTELEFONE INT
    ,PRIMARY KEY(IDLINHATELEFONICA)
    ,FOREIGN KEY (IDTELEFONE) REFERENCES TELEFONE(IDTELEFONE)
);


INSERT INTO TELEFONE VALUES(DEFAULT,"55","48","985003265",0,FALSE);
INSERT INTO TELEFONE VALUES(DEFAULT,"55","48","991003265",0,FALSE);
INSERT INTO ENDERECO VALUES(DEFAULT,"Aqui do lado","12312312","Florianópolis","Santa Catarina","SC","112");
INSERT INTO CLIENTE VALUES(DEFAULT,1,"Leonardo","11111111111");
INSERT INTO CLIENTE VALUES(DEFAULT,1,"Vilmar","22222222222");
