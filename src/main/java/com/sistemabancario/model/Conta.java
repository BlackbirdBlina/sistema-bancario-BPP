package com.sistemabancario.model;
import com.sistemabancario.view.ViewCliente;
import com.sistemabancario.view.ViewConta;

public abstract class Conta implements ViewConta {

    protected String numeroDaConta;
    protected Cliente cliente;
    protected double saldo;

    public Conta(String numeroDaConta, Cliente cliente, double saldoInicial) {
        this.numeroDaConta = numeroDaConta;
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public abstract saidasDeOperacoes sacar(double valor);

    public boolean transferir(Conta contaDestino, double valor){
        if (this.saldo >= valor){
            this.saldo -= valor;
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String getNumeroDaConta() {
        return this.numeroDaConta;
    }

    @Override
    public ViewCliente getViewCliente() {
        return cliente;
    }

    public enum saidasDeOperacoes{
        OperacaoBemSucedida,
        saldoMenorQueSaque,
        saldoMenorQueTarifa;
    }

    @Override
    public String getDescricao() {

        String nomeCliente;

        if (cliente != null) {
            nomeCliente = cliente.getNome();

        } else {
            nomeCliente = "Desconhecido";
        }

        return String.format(

            "Cliente: %-20s | Conta: %-10s | Saldo: R$ %.2f",
            nomeCliente,
            numeroDaConta,
            saldo

        );

    }

}
