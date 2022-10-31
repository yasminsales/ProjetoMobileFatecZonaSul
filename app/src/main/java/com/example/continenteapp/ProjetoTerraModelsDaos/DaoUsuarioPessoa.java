
package com.example.continenteapp.ProjetoTerraModelsDaos;

import com.example.continenteapp.ProjetoTerraUtils.ConexaoDb;
import com.example.continenteapp.ProjetoTerraModellBins.UsuarioPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuarioPessoa {
    private final Connection c;
    
    public DaoUsuarioPessoa() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }


    public UsuarioPessoa excluir(UsuarioPessoa usupesEnt) throws SQLException{
        String sql = "delete from usuarios_pessoas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usupesEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usupesEnt;
    }
    
    public UsuarioPessoa buscar(UsuarioPessoa usupesEnt) throws SQLException{
        String sql = "select * from usuarios_pessoas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usupesEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuarioPessoa usupesSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usupesSaida = new UsuarioPessoa(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usupesSaida;
   }

    public UsuarioPessoa inserir(UsuarioPessoa usupesEnt) throws SQLException{
        String sql = "insert into usuarios_pessoas " + " (idPessoa, idUsuario, obs)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,usupesEnt.getIdPessoa());
        stmt.setInt(2,usupesEnt.getIdUsuario());
        stmt.setString(3,usupesEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usupesEnt.setId(id);
        }
        stmt.close();
        return usupesEnt;
    }

    public UsuarioPessoa alterar(UsuarioPessoa usupesEnt) throws SQLException{
        String sql = "UPDATE usuarios_pessoas SET idPessoa = ?, idUsuario = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usupesEnt.getIdPessoa());
        stmt.setInt(2,usupesEnt.getIdUsuario());
        stmt.setString(3,usupesEnt.getObs());
        stmt.setInt(4,usupesEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return usupesEnt;
    }

   public List<UsuarioPessoa> listar(UsuarioPessoa usupesEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<UsuarioPessoa> usupess = new ArrayList<>();
        
        String sql = "select * from usuarios_pessoas where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usupesEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            UsuarioPessoa usupes = new UsuarioPessoa(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            usupess.add(usupes);
        }
        
        rs.close();
        stmt.close();
        return usupess;
    }
}
