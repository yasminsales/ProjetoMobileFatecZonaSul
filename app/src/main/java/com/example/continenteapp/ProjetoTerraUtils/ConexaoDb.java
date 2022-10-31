
package com.example.continenteapp.ProjetoTerraUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDb {
    public static String status = "Não conectado...";

    //Método Construtor da Classe//
     public ConexaoDb() {

    }

    //Método de Conexão//
     
     public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;          //atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão
            // String driverName = "com.mysql.jdbc.Driver";
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "terra";        //nome do seu banco de dados
            // String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            // String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useSSL=false";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "fateczs";        //nome de um usuário de seu BD
            String password = "15032021";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexão//
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.out.println("Erro" + e.getMessage());
            return null;
        }
    }

    //Método que retorna o status da sua conexão//

    public static String statusConection() {
        return status;
    }
    //Método que fecha sua conexão//

    public static boolean FecharConexao() {
        try {
           ConexaoDb.getConexaoMySQL().close();
           return true;
        } catch (SQLException e) {
            return false;
        }
    }
   //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoDb.getConexaoMySQL();
    }
}
