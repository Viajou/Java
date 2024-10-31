package com.example.servletviajou;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }
    Dotenv dotenv = Dotenv.load();
    private String url = dotenv.get("db_conexao");
    public boolean conectar(){
        try{
//          informando qual driver será utilizado para a conexão
            Class.forName("org.postgresql.Driver");
            //fazendo a conexão
            conn = DriverManager.getConnection(url);
            return true;
        }
        catch (SQLException sqle){
            System.out.println("Servidor não encontrado\n"+sqle);
            return false;
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Classe não encontrada\n"+cnfe);
            return false;
        }
    }

    public boolean desconectar(){
        try {
            if (conn != null && !conn.isClosed()) {
                //Desconectando BD
                conn.close();
            }
            return true;
        }catch (SQLException sqle) {
            System.out.println("Servidor não encontrado\n" + sqle);
            return false;
        }
    }
}