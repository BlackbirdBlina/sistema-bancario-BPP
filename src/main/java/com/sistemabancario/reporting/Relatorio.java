package com.sistemabancario.reporting;

import com.sistemabancario.service.Banco;
import com.sistemabancario.view.ViewConta;
import java.util.Comparator;
import java.util.List;



public class Relatorio {
    private final Banco banco;

    public Relatorio(Banco banco) {
        this.banco = banco;
    }

    public void exibirTotalContasPoupanca() {

        int totalContasPoupanca = this.banco.getViewContasPoupanca().size();
        double saldoTotalContasPoupanca = this.banco.calcularSaldoTotalContasPoupanca();

        System.out.println(
            "Relatório de todas as Contas Poupança cadastradas no banco: " +
            this.banco.getNomeDoBanco()

        );

        if (totalContasPoupanca == 0){
            System.out.println("Nenhuma conta poupança cadastrada.");
            System.out.println("Portanto o Saldo Total é: R$ 0.0 \n");
            return;
        }

        System.out.println("Total de Contas Poupança cadastradas: " + totalContasPoupanca);
        System.out.println("Saldo Total das Contas Poupança: R$ " + saldoTotalContasPoupanca + "\n");

    }

    public void exibirTotalContasCorrente() {

        int todasContasCorrente = this.banco.getViewContasCorrente().size();
        double saldoTotalContasCorrente = this.banco.calcularSaldoTotalContasCorrente();

        System.out.println(
            "Relatório de todas as Contas Corrente cadastradas no banco: " +
            this.banco.getNomeDoBanco()

        );

        if (todasContasCorrente == 0) {
            System.out.println("Nenhuma conta corrente cadastrada.");
            System.out.println("Portanto o Saldo Total é: R$ 0.0 \n");
            return;
        }

        System.out.println("Total de Contas Corrente cadastradas: " + todasContasCorrente);
        System.out.println("Saldo Total das Contas Corrente: R$ " + saldoTotalContasCorrente + "\n");

    }

    public void exibirSaldoTotalContas() {

        int totalDeContas = this.banco.getViewTodasContas().size();
        double saldoTotalDeContas = this.banco.calcularSaldoTotalContas();

        System.out.println(
            "Relatório geral de todas as contas cadastradas no banco: " +
            this.banco.getNomeDoBanco()

        );
        System.out.println("Total de Contas cadastradas: " + totalDeContas);
        System.out.println("Saldo Total de Todas as Contas: R$ " + saldoTotalDeContas + "\n");

    }

    public void exibirTodasContas() {

        List<ViewConta> contasGeral = this.banco.getViewTodasContas();

        System.out.println(
            "Exibindo todas as contas cadastradas no banco " +
            this.banco.getNomeDoBanco() +
            " mostradas em ordem descendente de saldo:"

        );

        if (contasGeral.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        contasGeral.sort(Comparator.comparingDouble(ViewConta::getSaldo).reversed());
        for (ViewConta conta : contasGeral) {
            System.out.println(conta.getDescricao());
        }

        System.out.println();
    }

    public void exibirContasCorrente() {

        List<ViewConta> contasCorrente = banco.getViewContasCorrente();

        System.out.println(
            "Exibindo todas as contas corrente cadastradas no banco " +
            this.banco.getNomeDoBanco() +
            " mostradas em ordem descendente de saldo:"

        );

        if (contasCorrente.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        contasCorrente.sort(Comparator.comparingDouble(ViewConta::getSaldo).reversed());
        for (ViewConta conta: contasCorrente){
            System.out.println(conta.getDescricao());
        }

    }

    public void exibirContasPoupanca() {

        List<ViewConta> contasPoupanca = banco.getViewContasPoupanca();

        System.out.println(
            "Exibindo todas as contas poupança cadastradas no banco " +
            this.banco.getNomeDoBanco() +
            " mostradas em ordem descendente de saldo:"

        );

        if (contasPoupanca.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        contasPoupanca.sort(Comparator.comparingDouble(ViewConta::getSaldo).reversed());
        for (ViewConta conta: contasPoupanca){
            System.out.println(conta.getDescricao());
        }

    }

}

