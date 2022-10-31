
package com.example.continenteapp.ProjetoTerraModellBins;

public class UsuarioPessoa {
    private int id;
    private int idPessoa;
    private int idUsuario;
    private String obs;
    private Usuario usu;
    private Pessoa pes;

    public UsuarioPessoa(int id) {
        this.id = id;
    }

    public UsuarioPessoa(String obs) {
        this.obs = obs;
    }

    public UsuarioPessoa(int idPessoa, int idUsuario, String obs) {
        this.idPessoa = idPessoa;
        this.idUsuario = idUsuario;
        this.obs = obs;
    }

    public UsuarioPessoa(int id, int idPessoa, int idUsuario, String obs) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idUsuario = idUsuario;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Pessoa getPes() {
        return pes;
    }

    public void setPes(Pessoa pes) {
        this.pes = pes;
    }

    @Override
    public String toString() {
        return "UsuarioPessoa{" + "id=" + id + ", idUsuario=" + idUsuario + ", idPessoa=" + idPessoa + ", obs=" + obs + '}';
    }
   
}
