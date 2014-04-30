create database setorestagio;

CREATE TABLE IF NOT EXISTS curso (
  id serial PRIMARY KEY,
  nome varchar(200),
  turno varchar(200),
  tipo varchar(200),
status integer NOT NULL DEFAULT 1,
) 