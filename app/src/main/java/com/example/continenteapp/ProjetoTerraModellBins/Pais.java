
package com.example.continenteapp.ProjetoTerraModellBins;


public class Pais {
    public int id;
    public String nome;
    public int pib; 
    public int idh; 
    public Continente continente; 
    
    public Pais(int id, String nome, int pib, int idh, Continente continente) {
        this.id = id;
        this.nome = nome;
        this.pib = pib; 
        this.idh = idh;
        this.continente = continente;
    }
    
    public Pais (int id, String nome) { 
        this.id = id;
        this.nome = nome;
    }
      public Pais (int id) { 
        this.id = id;
      }
    
     public Pais(String nome, int pib, int idh) {
        this.nome = nome;
        this.pib = pib; 
        this.idh = idh;
    }

    public Pais(String nome, int pib, int idh, Continente continente) {
        this.nome = nome; 
        this.pib = pib; 
        this.idh = idh; 
        this.continente = continente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public void setIdh(int idh) {
        this.idh = idh;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPib() {
        return pib;
    }

    public int getIdh() {
        return idh;
    }

    /**
     *
     * @return
     */
    public Continente getContinente() {
        return continente;
    }
    
    @Override
    public String toString() {
        return "País{" + "id=" + id + ", nome=" + nome + ", pib=" + pib + ", idh=" + idh + ", continente=" + continente + '}';
    }
}
