/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.TipoOperacao;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author hbsmoura
 */
public class Conta {

    private Usuario usuario;
    private String numAgencia = "" + new Random().nextLong(9999);
    private String numConta = "" + new Random().nextLong(999999);
    private List<Operacao> historico = new ArrayList(
            Arrays.asList(new Operacao())
    );
    private BigDecimal saldo = BigDecimal.ZERO;

    public Conta(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNumAgencia() {
        return numAgencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public boolean sacar(String valor) {
        BigDecimal valorReal = new BigDecimal(valor).abs();
        if (saldo.subtract(valorReal).compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        this.saldo = saldo.subtract(valorReal);
        this.historico.add(new Operacao(TipoOperacao.SAQUE, valorReal, this.saldo));
        return true;
    }

    public void depositar(String valor) {
        BigDecimal valorReal = new BigDecimal(valor).abs();
        saldo = saldo.add(valorReal);
        this.historico.add(new Operacao(TipoOperacao.DEPÓSITO, valorReal, this.saldo));
    }

    public List<Operacao> obterHistorico() {
        return this.historico;
    }
    
    public List<Operacao> obterHistorico(LocalDate start) {
        return this.historico.stream()
                .filter(op -> op.getHorario().toLocalDate().isAfter(start))
                .collect(Collectors.toList());
    }
    
    public List<Operacao> obterHistorico(LocalDate start, LocalDate end) {
        return this.historico.stream()
                .filter(
                        op -> op.getHorario().toLocalDate().isAfter(start)
                        && op.getHorario().toLocalDate().isBefore(end)
                )
                .collect(Collectors.toList());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.numAgencia);
        hash = 37 * hash + Objects.hashCode(this.numConta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.numAgencia, other.numAgencia)) {
            return false;
        }
        return Objects.equals(this.numConta, other.numConta);
    }

    @Override
    public String toString() {
        return "Conta{" + "Agencia: " + numAgencia + ", Conta: " + numConta + '}';
    }   

}
