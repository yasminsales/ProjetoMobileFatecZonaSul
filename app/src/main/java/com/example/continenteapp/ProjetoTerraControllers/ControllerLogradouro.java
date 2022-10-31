
package com.example.continenteapp.ProjetoTerraControllers;

import com.example.continenteapp.ProjetoTerraModelsDaos.DaoLogradouro;
import com.example.continenteapp.ProjetoTerraModellBins.Logradouro;

import java.sql.SQLException;
import java.util.List;
public class ControllerLogradouro {
    static DaoLogradouro daoLog;
    
    public Logradouro inserir (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.inserir(log);
    }
    public Logradouro alterar (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.alterar(log);
    }
    public List<Logradouro> listar (Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.listar(log);
    }
    public Logradouro excluir(Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.excluir(log);
    }
    public Logradouro buscar(Logradouro log) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro(); 
        return daoLog.buscar(log);
    }
}
