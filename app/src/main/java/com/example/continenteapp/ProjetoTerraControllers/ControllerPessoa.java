
package com.example.continenteapp.ProjetoTerraControllers;

import com.example.continenteapp.ProjetoTerraModelsDaos.DaoPessoa;
import com.example.continenteapp.ProjetoTerraModellBins.Pessoa;

import java.sql.SQLException;
import java.util.List;

public class ControllerPessoa {
    static DaoPessoa daoPes;
    
    public Pessoa inserir (Pessoa pes) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa(); 
        return daoPes.inserir(pes);
    }
    public Pessoa alterar (Pessoa pes) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa(); 
        return daoPes.alterar(pes);
    }
    public List<Pessoa> listar (Pessoa pes) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa(); 
        return daoPes.listar(pes);
    }
    public Pessoa excluir(Pessoa pes) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa(); 
        return daoPes.excluir(pes);
    }
    public Pessoa buscar(Pessoa pes) throws SQLException, ClassNotFoundException {
        daoPes = new DaoPessoa(); 
        return daoPes.buscar(pes);
    }
}
