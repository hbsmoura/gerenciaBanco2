/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author hbsmoura
 */
public class Usuario {
    private String prenome;
    private String sobrenome;
    private String cpf;
    private Conta conta;
    
    public Usuario() {this.conta = new Conta(this);
}

    public Usuario(String prenome, String sobrenome, String cpf) {
        this.conta = new Conta(this);
        this.prenome = prenome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getPrenome() {
        return prenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCPF() {
        return cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.cpf);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Usuario{" + "Nome: " + prenome + " " + sobrenome + ", CPF: " + cpf + '}';
    }
    
}
