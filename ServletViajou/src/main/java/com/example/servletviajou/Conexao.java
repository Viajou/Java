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
    String url = dotenv.get("db_conexao");
    String user = dotenv.get("db_usuario");
    String password = dotenv.get("db_senha");

    public boolean conectar() {
        try {
//          informando qual driver será utilizado para a conexão
            Class.forName("org.postgresql.Driver");
            //fazendo a conexão
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver não encontrado\n" + cnfe);
            return false;
        } catch (SQLException sqle) {
            System.out.println("Servidor não encontrado\n" + sqle);
            return false;
        }
    }

        public boolean desconectar() {
            try {
                if (conn != null && !conn.isClosed()) {
                    //Desconectando BD
                    conn.close();
                }
                return true;
            } catch (SQLException sqle) {
                System.out.println("Servidor não encontrado\n" + sqle);
                return false;
            }
        }
}