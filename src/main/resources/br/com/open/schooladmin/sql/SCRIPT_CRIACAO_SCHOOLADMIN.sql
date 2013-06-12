CREATE DATABASE schooladmin
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE estado(
    sigla  VARCHAR(2)  CONSTRAINT estado_sigla_nn NOT NULL,
    nome   VARCHAR(60) CONSTRAINT estado_nome_nn NOT NULL,
	
    CONSTRAINT estado_sigla_pk PRIMARY KEY (sigla)
);

CREATE TABLE cidade(
    codigo        SERIAL      CONSTRAINT cidade_codigo_nn NOT NULL,
    nome          VARCHAR(60) CONSTRAINT cidade_nome_nn NOT NULL,
    sigla_estado  VARCHAR(2)  CONSTRAINT cidade_sigla_estado_ NOT NULL,
	
    CONSTRAINT cidade_codigo_pk PRIMARY KEY (codigo),
    CONSTRAINT cidade_sigla_estado_fk FOREIGN KEY (sigla_estado) REFERENCES estado (sigla)
);

CREATE TABLE perfil(
    codigo     SERIAL       CONSTRAINT perfil_codigo_nn NOT NULL,
    descricao  VARCHAR(60)  CONSTRAINT perfil_descricao_nn NOT NULL,
    nivel      INTEGER      CONSTRAINT perfil_nivel_nn NOT NULL,
    role       VARCHAR(25)  CONSTRAINT perfil_role_nn NOT NULL,

    CONSTRAINT perfil_codigo_pk PRIMARY KEY (codigo)
);

CREATE TABLE usuario(
    codigo         SERIAL       CONSTRAINT usuario_codigo_nn NOT NULL,
    login          VARCHAR(60)  CONSTRAINT usuario_login_nn NOT NULL,
    senha          VARCHAR(60)  CONSTRAINT usuario_senha_nn NOT NULL,
    email          VARCHAR(60),
    codigo_perfil  INTEGER      CONSTRAINT usuario_codigo_perfil_nn NOT NULL,

    CONSTRAINT usuario_codigo_pk PRIMARY KEY (codigo),
    CONSTRAINT usuario_codigo_perfil_fk FOREIGN KEY (codigo_perfil) REFERENCES perfil (codigo)
);