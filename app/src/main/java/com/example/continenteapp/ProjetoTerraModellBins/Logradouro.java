
package com.example.continenteapp.ProjetoTerraModellBins;

public class Logradouro {
    int id;
    String endereco;
    String cep;
    String complemento;
    
    // buscar/excluir usuario pela chave pk
    public Logradouro(int id) {
        this.id = id;
    }
    // listar logradouros por cep
    public Logradouro(String cep) {
        this.cep = cep;
    }
    // para inserir logradouro
    public Logradouro(String end, String cep, String Comp) {
        this.endereco = end;
        this.cep = cep;
        this.complemento = Comp;
    }
    // para alterar dados de pessoa
    public Logradouro(int id, String end, String cep, String Comp) {
        this.id = id;
        this.endereco = end;
        this.cep = cep;
        this.complemento = Comp;
    }

    public Logradouro(String end, String cep) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // get e set para valorização de variaveis
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEnd(String end) {
        this.endereco = end;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComp(String Comp) {
        this.complemento = Comp;
    }
// para impressao 
    @Override
    public String toString() {
        return "Logradouro{" + "id=" + id + ", end=" + endereco + ", cep=" + cep + ", Comp=" + complemento + '}';
    }
}
