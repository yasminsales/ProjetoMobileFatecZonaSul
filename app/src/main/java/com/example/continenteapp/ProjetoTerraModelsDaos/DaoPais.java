
package com.example.continenteapp.ProjetoTerraModelsDaos;

import com.example.continenteapp.ProjetoTerraModellBins.Continente;
import com.example.continenteapp.ProjetoTerraUtils.ConexaoDb;
import com.example.continenteapp.ProjetoTerraModellBins.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPais {
    private final Connection c;
    
    public DaoPais() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Pais excluir(Pais paisEnt) throws SQLException {
        String sql = "delete from pais WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, paisEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return paisEnt;
    }
    public Pais buscar(Pais paisEnt) throws SQLException {
        String sql = "SELECT p.id /*1*/, \n" +
"	                     p.nome /*2*/, \n" +
"                            p.pib /*3*/, \n" +
"                            p.idh, /*4*/\n" +
"                            c.id,\n" +
"                            c.nome,\n" +
"                            c.area\n" +
"                     FROM terra.pais p\n" +
"                     JOIN terra.continente c ON c.id = p.continente_id\n" +
"                     where p.id = ?;";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, paisEnt.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        Pais paisSaida = null;
        while (rs.next()) {
            // criando o objeto país
            paisSaida = new Pais(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    new Continente(rs.getInt(5), rs.getString(6), rs.getInt(7))
            );
        }
        // adiciona o país à lista de países
        stmt.close();
        return paisSaida;
    }
    
    public Pais inserir(Pais paisEnt) throws SQLException{
        String sql = "insert into pais " + " (nome, pib, idh, continente_id)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,paisEnt.getNome());
        stmt.setInt(2,paisEnt.getPib());
        stmt.setInt(3,paisEnt.getIdh());
        stmt.setInt(4,paisEnt.getContinente().getId());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            paisEnt.setId(id);
        }
        stmt.close();
        return paisEnt;
    }
    
    public Pais alterar(Pais paisEnt) throws SQLException{
        String sql = "UPDATE pais SET nome = ?, pib = ?, idh = ?, continente_id = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,paisEnt.getNome());
        stmt.setInt(2,paisEnt.getPib());
        stmt.setInt(3,paisEnt.getIdh());
        stmt.setInt(4,paisEnt.getContinente().getId());
        stmt.setInt(5,paisEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return paisEnt;
    }
    
    public List<Pais> listar(String nome) throws SQLException{
        // array armazena a lista de registros

        List<Pais> pais = new ArrayList<>();
        
        String sql = "SELECT p.id /*1*/, " +
                    "	     p.nome /*2*/, " +
                    "        p.pib /*3*/, " +
                    "        p.idh, /*4*/" +
                    "        c.id," +
                    "        c.nome," +
                    "        c.area " +
                    "FROM terra.pais p " +
                    "JOIN terra.continente c ON c.id = p.continente_id " +
                    "where p.nome like ?;";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + nome + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Continente
            Pais pai = new Pais(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                new Continente(rs.getInt(5), rs.getString(6), rs.getInt(7))
            );
            pais.add(pai);
            // adiciona o país à lista de países
        }      
        rs.close();
        stmt.close();
        return pais;
   }
}
