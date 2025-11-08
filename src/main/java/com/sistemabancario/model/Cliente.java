package com.sistemabancario.model;

import com.sistemabancario.view.ViewCliente;

public class Cliente implements ViewCliente {

    private final String nome;
    private final String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}

