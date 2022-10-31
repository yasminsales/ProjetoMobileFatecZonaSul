
package com.example.continenteapp.ProjetoTerraControllers;

import java.sql.SQLException;
import java.util.List;

import com.example.continenteapp.ProjetoTerraModelsDaos.DaoUsuario;
import com.example.continenteapp.ProjetoTerraModellBins.Usuario;

public class ControllerUsuario {   
    
    DaoUsuario daoUsu;
    
    public boolean validar (Usuario usu) throws SQLException, ClassNotFoundException {
        boolean retorno = false;
        daoUsu = new DaoUsuario();
        Usuario usuSaida = daoUsu.validar(usu);
        retorno = usuSaida.getLogin().equals(usu.getLogin());
        return retorno;
    }

    public Usuario validaWeb (Usuario usu) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        usu = daoUsu.validar(usu);
        return usu;
    }

    public Usuario inserir(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        usuEnt = daoUsu.inserir(usuEnt);
        return usuEnt;
    }

    public Usuario alterar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        usuEnt = daoUsu.alterar(usuEnt);
        return usuEnt;
    }

    public List<Usuario> listar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        List<Usuario> listaUsu = daoUsu.listar(usuEnt);
        return listaUsu;
    }

    public Usuario excluir(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        usuEnt = daoUsu.excluir(usuEnt);
        return usuEnt;
    }

    public Usuario buscar(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
        usuEnt = daoUsu.buscar(usuEnt);
        return usuEnt;
    }
}

    
