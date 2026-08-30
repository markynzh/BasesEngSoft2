-- CRIACAO DO BANCO
CREATE DATABASE sistema_academico;
USE sistema_academico;

-- TABELA ESTUDANTE
CREATE TABLE estudante (
    matricula INT PRIMARY KEY,
    nome_completo VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL
);

-- TABELA PROFESSOR
CREATE TABLE professor (
    matricula INT PRIMARY KEY,
    nome_completo VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    especialidade VARCHAR(100) NOT NULL
);

-- TABELA CURSO
CREATE TABLE curso (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome_curso VARCHAR(100) NOT NULL,
    carga_horaria INT NOT NULL,
    professor_responsavel INT,

    CONSTRAINT fk_professor
        FOREIGN KEY (professor_responsavel)
        REFERENCES professor(matricula)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

-- TABELA MATRICULA
CREATE TABLE matricula (
    id INT PRIMARY KEY AUTO_INCREMENT,
    estudante_matricula INT NOT NULL,
    curso_codigo INT NOT NULL,
    data_matricula DATE NOT NULL,

    CONSTRAINT fk_estudante
        FOREIGN KEY (estudante_matricula)
        REFERENCES estudante(matricula)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_curso
        FOREIGN KEY (curso_codigo)
        REFERENCES curso(codigo)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT uk_matricula
        UNIQUE(estudante_matricula, curso_codigo)
);