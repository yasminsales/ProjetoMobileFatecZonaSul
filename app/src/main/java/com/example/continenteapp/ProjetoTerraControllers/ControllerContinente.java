
package com.example.continenteapp.ProjetoTerraControllers;

import android.content.Context;

import com.example.continenteapp.ProjetoTerraModellBins.Continente;
import com.example.continenteapp.ProjetoTerraModelsDaos.DaoContinente;

import java.sql.SQLException;
import java.util.List;

public class ControllerContinente {

    private DaoContinente daoContinente;

    public ControllerContinente(Context context) {
        daoContinente = new DaoContinente(context);
    }

    public Continente inserir (Continente cont) throws SQLException, ClassNotFoundException {

        return daoContinente.inserir(cont);
    }
    public Continente alterar (Continente cont) throws SQLException, ClassNotFoundException {

        return daoContinente.alterar(cont);
    }
    public List<Continente> listar (String nome) throws SQLException, ClassNotFoundException {

        return daoContinente.listar(nome);
    }
    public Continente excluir(Continente cont) throws SQLException, ClassNotFoundException {
        return daoContinente.excluir(cont);
    }
    public Continente buscar(Continente cont) throws SQLException, ClassNotFoundException {
        return daoContinente.buscar(cont);
    }
}
