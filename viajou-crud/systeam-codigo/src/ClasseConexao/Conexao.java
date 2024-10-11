package ClasseConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection conn;


    public boolean conectar(){
        try{
//          informando qual drive de conexão será ultirizado
            Class.forName("org.postgresql.Driver");
            //fazendo a coneção
            conn = DriverManager.getConnection("","postgres","");
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
        }catch (SQLException sqlex) {
            System.out.println("Servidor não encontrado\n" + sqlex);
            return false;
        }
    }



}
