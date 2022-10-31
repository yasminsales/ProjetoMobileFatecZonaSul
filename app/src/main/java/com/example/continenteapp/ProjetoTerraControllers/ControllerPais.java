
package com.example.continenteapp.ProjetoTerraControllers;

import com.example.continenteapp.ProjetoTerraModelsDaos.DaoPais;
import com.example.continenteapp.ProjetoTerraModellBins.Pais;

import java.sql.SQLException;
import java.util.List;

public class ControllerPais {
    static DaoPais daoPais;
    public Pais inserir (Pais pais) throws SQLException, ClassNotFoundException {
        daoPais = new DaoPais(); 
        return daoPais.inserir(pais);
    }
    public Pais alterar (Pais pais) throws SQLException, ClassNotFoundException {
        daoPais = new DaoPais(); 
        return daoPais.alterar(pais);
    }
    public List<Pais> listar (String nome) throws SQLException, ClassNotFoundException {
        daoPais = new DaoPais(); 
        return daoPais.listar(nome);
    }
    public Pais excluir(Pais pais) throws SQLException, ClassNotFoundException {
        daoPais = new DaoPais(); 
        return daoPais.excluir(pais);
    }
    public Pais buscar(Pais pais) throws SQLException, ClassNotFoundException {
        daoPais = new DaoPais(); 
        return daoPais.buscar(pais);
    }
}
