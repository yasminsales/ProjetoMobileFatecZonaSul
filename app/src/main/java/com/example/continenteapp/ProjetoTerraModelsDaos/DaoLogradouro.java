
package com.example.continenteapp.ProjetoTerraModelsDaos;

import com.example.continenteapp.ProjetoTerraUtils.ConexaoDb;
import com.example.continenteapp.ProjetoTerraModellBins.Logradouro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DaoLogradouro {
    private final Connection c;

    public DaoLogradouro() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Logradouro excluir(Logradouro logEnt) throws SQLException {
        String sql = "delete from logradouro WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, logEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return logEnt;
    }

    public Logradouro buscar(Logradouro logEnt) throws SQLException {
        String sql = "select * from logradouro WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, logEnt.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Logradouro logSaida = null;
        while (rs.next()) {
            // criando o objeto Logradouro 
            logSaida = new Logradouro(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        }
        // adiciona o log à lista de logradouros
        stmt.close();
        return logSaida;
    }
    
    public Logradouro inserir(Logradouro logEnt) throws SQLException{
        String sql = "insert into logradouro " + " (endereco, cep, complemento)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,logEnt.getEndereco());
        stmt.setString(2,logEnt.getCep());
        stmt.setString(3,logEnt.getComplemento());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            logEnt.setId(id);
        }
        stmt.close();
        return logEnt;
    }
    public Logradouro alterar(Logradouro logEnt) throws SQLException{
        String sql = "UPDATE logradouro SET endereco = ?, cep = ?, complemento = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,logEnt.getEndereco());
        stmt.setString(2,logEnt.getCep());
        stmt.setString(3,logEnt.getComplemento());
        stmt.setInt(4,logEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return logEnt;
    }

   public List<Logradouro> listar(Logradouro logEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Logradouro> logr = new ArrayList<>();
        
        String sql = "select * from logradouro where cep like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + logEnt.getCep()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Logradouro log = new Logradouro(
               rs.getInt(1),
               rs.getString(2),
               rs.getString(3),
               rs.getString(4));
            // adiciona o log à lista de logradouros
            logr.add(log);
        }      
        rs.close();
        stmt.close();
        return logr;
   }
}
