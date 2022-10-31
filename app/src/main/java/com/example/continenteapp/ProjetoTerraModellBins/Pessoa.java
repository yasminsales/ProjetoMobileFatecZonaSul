
package com.example.continenteapp.ProjetoTerraModellBins;


public class Pessoa {
    
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;

    // buscar/excluir usuario pela chave pk
    public Pessoa(int id) {
        this.id = id;
    }
    // listar pessoas por nome
    public Pessoa(String nome) {
        this.nome = nome;
    }
    // para inserir pessoa
    public Pessoa(String nome, String rg, String cpf, String email) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
    }
    // para alterar dados de pessoa
    public Pessoa(int id, String nome, String rg, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
    }

    // get e set para valorização de variaveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // para impressao
    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email + '}';
    }
}


