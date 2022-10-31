
package com.example.continenteapp.ProjetoTerraModellBins;

public class Continente {
    public int id;
    public String nome;
    public int area;
    
    public Continente(int id, String nome, int area) {
        this.id = id;
        this.nome = nome;
        this.area = area; 
    }
    public Continente(String nome, int area) {
        this.nome = nome;
        this.area = area; 
    }
      public Continente(String nome) {
        this.nome = nome;
    }
    
      public Continente(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getArea() {
        return area;
    } 
    
    @Override
    public String toString() {
        return "Continente{" + "id=" + id + ", nome=" + nome + ", área=" + area + '}';
    }
}
