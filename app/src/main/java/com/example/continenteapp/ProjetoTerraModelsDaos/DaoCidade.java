
package com.example.continenteapp.ProjetoTerraModelsDaos;

import com.example.continenteapp.ProjetoTerraModellBins.Cidade;
import com.example.continenteapp.ProjetoTerraUtils.ConexaoDb;
import com.example.continenteapp.ProjetoTerraModellBins.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoCidade {
    private final Connection c;
    
    public DaoCidade() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Cidade excluir(Cidade cidEnt) throws SQLException {
        String sql = "delete from cidade WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, cidEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return cidEnt;
    }
    
    public Cidade buscar(Cidade cidEnt) throws SQLException {
        String sql = "SELECT p.id /*1*/, \n" +
"	                     p.nome /*2*/, \n" +
"                            p.capital /*3*/, \n" +
"                            p.clima, /*4*/\n" +
"                            p.populacao,\n" +
"                            p.pais_id, \n" +
"                            c.nome " +         
"                     FROM terra.cidade p\n" +
"                     JOIN terra.pais c ON c.id = p.pais_id\n" +
"                     where p.id = ? ";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, cidEnt.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Cidade cidSaida = null;
        while (rs.next()) {
            // criando o objeto cidade
            cidSaida = new Cidade(
                    rs.getInt(1), //id
                    rs.getString(2), //nome
                    rs.getBoolean(3), //capital 
                    rs.getString(4), // clima
                    rs.getInt(5), // populacao 
                    new Pais(rs.getInt(6), rs.getString(7))
            );     
        }
        // adiciona a cidade à lista de cidades
        stmt.close();
        return cidSaida;
    }
    public Cidade inserir(Cidade cidEnt) throws SQLException{
        String sql = "insert into cidade " + " (nome, capital, clima, populacao, pais_id)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,cidEnt.getNome());
        stmt.setBoolean(2,cidEnt.isCapital());
        stmt.setString(3,cidEnt.getClima());
        stmt.setInt(4,cidEnt.getPopulacao());
        stmt.setInt(5,cidEnt.getPais().getId());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            cidEnt.setId(id);
        }
        stmt.close();
        return cidEnt;
    }
    
    public Cidade alterar(Cidade cidEnt) throws SQLException{
        String sql = "UPDATE cidade SET nome = ?, capital = ?, clima = ?, populacao = ?,  pais_id = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,cidEnt.getNome());
        stmt.setBoolean(2,cidEnt.isCapital());
        stmt.setString(3,cidEnt.getClima());
        stmt.setInt(4,cidEnt.getPopulacao());
        stmt.setInt(5,cidEnt.getPais().getId());
        stmt.setInt(6,cidEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return cidEnt;
    }
    
     public List<Cidade> listar(String nome) throws SQLException{
        // array armazena a lista de registros

        List<Cidade> cida = new ArrayList<>();
        
        String sql = "SELECT p.id/*1*/, " +
                    "	     p.nome /*2*/, " +
                    "        p.capital /*3*/, " +
                    "        p.clima, /*4*/" +
                    "        p.populacao," +
                    "        p.pais_id," +
                    "        c.nome " +
                    "FROM terra.cidade p " +
                    "JOIN terra.pais c ON c.id = p.pais_id " +
                    "where p.nome like ?;";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + nome + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Cidade
            Cidade cid = new Cidade(
                rs.getInt(1),
                rs.getString(2),
                rs.getBoolean(3),
                rs.getString(4),
                rs.getInt(5),
                new Pais(rs.getInt(6), rs.getString(7))
            );
            cida.add(cid);
            // adiciona a cidade à lista de cidades
        }      
        rs.close();
        stmt.close();
        return cida;
   }
}
