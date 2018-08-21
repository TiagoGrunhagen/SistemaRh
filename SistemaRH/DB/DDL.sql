CREATE TABLE pessoa (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(40) NOT NULL,
    sobrenome VARCHAR (40) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE sistema (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE departamento(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE diretor(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT
);

CREATE TABLE gerente(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    departamento_id INT,
    FOREIGN KEY (departamento_id) REFERENCES departamento(id)
);

CREATE TABLE diretor_departamento(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    diretor_id INT NOT NULL,
    departamento_id INT NOT NULL,
    FOREIGN KEY (diretor_id) REFERENCES diretor(id) ON DELETE CASCADE,
    FOREIGN KEY (departamento_id) REFERENCES departamento(id) ON DELETE CASCADE
);

CREATE TABLE funcionario (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    senha VARCHAR(50),
    nivel INT NOT NULL,
    salario DOUBLE NOT NULL,
    tipo_cargo VARCHAR(50) NOT NULL,
    pessoa_id INT NOT NULL,
    departamento_id INT NOT NULL,
    cargo_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    FOREIGN KEY (departamento_id) REFERENCES departamento(id)
);

CREATE TABLE sistema_funcionario(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    funcionario_id INT NOT NULL,
    sistema_id INT NOT NULL,
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(id) ON DELETE CASCADE,
    FOREIGN KEY (sistema_id) REFERENCES sistema(id) ON DELETE CASCADE
);