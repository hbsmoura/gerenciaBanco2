/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.TipoOperacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author hbsmoura
 */
public class Operacao {
    private TipoOperacao tipo;
    private LocalDateTime horario = LocalDateTime.now();
    private BigDecimal valor;
    private BigDecimal saldoRemanescente;
    
    public Operacao() {
        this.tipo = TipoOperacao.CRIACAO;
        this.valor = BigDecimal.ZERO;
        this.saldoRemanescente = BigDecimal.ZERO;
    }

    public Operacao(TipoOperacao tipo, BigDecimal valor, BigDecimal saldoRemanescente) {
        this.tipo = tipo;
        this.valor = valor;
        this.saldoRemanescente = saldoRemanescente;
    }    

    public TipoOperacao getTipo() {
        return tipo;
    }

    public LocalDateTime getHorario() {
        return horario;
    }    

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getSaldoRemanescente() {
        return saldoRemanescente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.horario);
        hash = 37 * hash + Objects.hashCode(this.valor);
        hash = 37 * hash + Objects.hashCode(this.saldoRemanescente);
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
        final Operacao other = (Operacao) obj;
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return Objects.equals(this.saldoRemanescente, other.saldoRemanescente);
    }

    @Override
    public String toString() {
        return "Operacao{" + "tipo=" + tipo + ", horario=" + horario + ", valor=" + valor + ", saldoRemanescente=" + saldoRemanescente + '}';
    }    
    
}
