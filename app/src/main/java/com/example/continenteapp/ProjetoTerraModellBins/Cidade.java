
package com.example.continenteapp.ProjetoTerraModellBins;


public class Cidade {
    public int id;
    public String nome;
    public boolean capital; 
    public String clima; 
    public int populacao; 
    public Pais pais;  
    
    public Cidade(int id, String nome, boolean capital, String clima, int populacao, Pais pais) { 
    this.id = id;
    this.nome = nome;
    this.capital = capital; 
    this.clima = clima;
    this.pais = pais;
}
    public Cidade(String nome, boolean capital, String clima, int populacao, Pais pais) { 
    this.nome = nome;
    this.capital = capital; 
    this.clima = clima;
    this.populacao = populacao;
    this.pais = pais;
}
    public Cidade(String nome, boolean capital, String clima, int populacao) { 
    this.nome = nome;
    this.capital = capital; 
    this.clima = clima;
}

    public Cidade(int id, String nome, Boolean capital, String clima, int populacao, Pais pais) {
        this.id = id; 
        this.nome = nome; 
        this.capital = capital; 
        this.clima = clima; 
        this.populacao = populacao; 
        this.pais = pais;
    }

    public Cidade(int id) {
       this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isCapital() {
        return capital;
    }

    public String getClima() {
        return clima;
    }

    public int getPopulacao() {
        return populacao;
    }

    public Pais getPais() {
        return pais;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    @Override
    public String toString() {
        return "País{" + "id=" + id + ", nome=" + nome + ", capital=" + capital + ", clima=" + clima + ", população=" + populacao + ", país=7" + pais +'}';
    }
}


 


