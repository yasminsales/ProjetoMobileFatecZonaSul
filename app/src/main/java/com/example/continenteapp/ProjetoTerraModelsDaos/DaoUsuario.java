
package com.example.continenteapp.ProjetoTerraModelsDaos;

import com.example.continenteapp.ProjetoTerraUtils.ConexaoDb;
import com.example.continenteapp.ProjetoTerraModellBins.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {
    
    private final Connection c;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Usuario validar(Usuario usuEnt) throws SQLException {
        // cria o select para ser executado no banco de dados 
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        Usuario usuSaida;
        // seta os valores
        try ( // prepared statement para seleção
                PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,usuEnt.getLogin());
            stmt.setString(2,usuEnt.getSenha());
            // executa
            ResultSet rs = stmt.executeQuery();
            // percorrendo o rs
            usuSaida = null;
            while (rs.next()) {
                // criando o objeto Usuario
                usuSaida = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                // adiciona o usu à lista de usus
            }
        }
        System.out.println("Usuario: " + usuSaida.toString());
        return usuSaida; 
    }

    public Usuario excluir(Usuario usuEnt) throws SQLException{
        String sql = "delete from usuarios WHERE id = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,usuEnt.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return usuEnt;
    }
    
    public Usuario buscar(Usuario usuEnt) throws SQLException{
        String sql = "select * from usuarios WHERE id = ?";
        Usuario usuSaida;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,usuEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            usuSaida = null;
            while (rs.next()) {
                // criando o objeto Usuario
                usuSaida = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                // adiciona o usu à lista de usus
            }
        }
        return usuSaida;
   }

    public Usuario inserir(Usuario usuEnt) throws SQLException{
        String sql = "insert into usuarios" + " (login, senha, status, tipo)" + " values (?,?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,usuEnt.getLogin());
            stmt.setString(2,usuEnt.getSenha());
            stmt.setString(3,usuEnt.getStatus());
            stmt.setString(4,usuEnt.getTipo());
            
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                usuEnt.setId(id);
            }
        }
        return usuEnt;
    }

    public Usuario alterar(Usuario usuEnt) throws SQLException{
        String sql = "UPDATE usuarios SET login = ?, senha = ?, status = ?, tipo = ? WHERE id = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,usuEnt.getLogin());
            stmt.setString(2,usuEnt.getSenha());
            stmt.setString(3,usuEnt.getStatus());
            stmt.setString(4,usuEnt.getTipo());
            stmt.setInt(5,usuEnt.getId());
            
            // executa
            stmt.execute();
        }
        return usuEnt;
    }

   public List<Usuario> listar(Usuario usuEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Usuario> usus = new ArrayList<>();
        
        String sql = "select * from usuarios where login like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuEnt.getLogin() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
   
   }

    
}

