
package com.example.continenteapp.ProjetoTerraControllers;

import com.example.continenteapp.ProjetoTerraModellBins.Cidade;
import com.example.continenteapp.ProjetoTerraModelsDaos.DaoCidade;

import java.sql.SQLException;
import java.util.List;

public class ControllerCidade {
    static DaoCidade daoCidade;
    public Cidade inserir (Cidade cid) throws SQLException, ClassNotFoundException {
        daoCidade = new DaoCidade(); 
        return daoCidade.inserir(cid);
    }
    public Cidade alterar (Cidade cid) throws SQLException, ClassNotFoundException {
        daoCidade = new DaoCidade(); 
        return daoCidade.alterar(cid);
    }
    public List<Cidade> listar (String nome) throws SQLException, ClassNotFoundException {
        daoCidade = new DaoCidade(); 
        return daoCidade.listar(nome);
    }
    public Cidade excluir(Cidade cid) throws SQLException, ClassNotFoundException {
        daoCidade = new DaoCidade(); 
        return daoCidade.excluir(cid);
    }
    public Cidade buscar(Cidade cid) throws SQLException, ClassNotFoundException {
        daoCidade = new DaoCidade(); 
        return daoCidade.buscar(cid);
    }
}


