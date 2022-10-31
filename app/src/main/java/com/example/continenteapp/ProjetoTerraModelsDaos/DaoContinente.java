
package com.example.continenteapp.ProjetoTerraModelsDaos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.continenteapp.ProjetoTerraModellBins.Continente;
import com.example.continenteapp.ProjetoTerraUtils.ConexaoDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoContinente extends DatabaseCreation {

    public DaoContinente(@NonNull Context ctx) {
        super(ctx);
    }

    public Continente excluir(Continente conEnt) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] params =  { String.valueOf(conEnt.getId()) };

        // all values are inserted into database
        db.execSQL("DELETE FROM continente where id = ?", params);

        return conEnt;
    }
    
    public Continente buscar(Continente conEnt) throws SQLException {
        String sql = "select * from continente WHERE id = ?";
        SQLiteDatabase db = this.getReadableDatabase();

        // seta os valores
        // executa
        int id = conEnt.getId();
        String[] params = { String.valueOf(id) };
        Cursor cursor = db.rawQuery(sql, params);

        Continente conSaida = null;
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            // criando o objeto continente
            conSaida = new Continente(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2));
        }

        cursor.close();
        return conSaida;
    }
    
    public Continente inserir(Continente conEnt) throws SQLException {
        String sql = "insert into continente " + " (nome, area)" + " values (?,?)";
    
        // prepared statement para inserção
        SQLiteDatabase db = this.getWritableDatabase();

        String[] params = { conEnt.getNome(), String.valueOf(conEnt.getArea()) };

        // seta os valores
        // executa
        try {
            Cursor cursor = db.rawQuery(sql, params);

            if (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                conEnt.setId(id);
            }
            cursor.close();
            return conEnt;
        }catch (Exception e){
            throw e;
        }
    }
    
     public Continente alterar(Continente conEnt) throws SQLException{
        String sql = "UPDATE continente SET nome = ?, area = ? WHERE id = ?";

        // prepared statement para inserção
        // seta os valores
        String[] params = { conEnt.getNome(), String.valueOf(conEnt.getArea()), String.valueOf(conEnt.getId()) };
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, params);

        cursor.close();
        return conEnt;
    }
     
    public List<Continente> listar(String nome) throws SQLException {
        // array armazena a lista de registros

        List<Continente> cont = new ArrayList<>();
        
        String sql = "select id, nome, area from continente where nome like ?";

        SQLiteDatabase db = this.getReadableDatabase();
        String[] params = { "%" + nome + "%" };
        // seta os valores
        Cursor cursor = db.rawQuery(sql, params);

        while (cursor.moveToNext()) {
            // criando o objeto Continente
            Continente con = new Continente(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2));
            cont.add(con);
            // adiciona o continente à lista de continentes
        }
        cursor.close();
        return cont;
   }
}
