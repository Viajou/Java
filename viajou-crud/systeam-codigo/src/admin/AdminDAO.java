package admin;

import java.sql.*;

public class AdminDAO {
    //Declarando as variaveis do método
    private Connection conn;
    private PreparedStatement psmt;
    //fazendo o metoto para poder fazer a coneção com o banco
    public boolean conectar(){
//        try{
////            informando qual drive de conexão será ultirizado
//            Class.forName("org.postgresql.Driver");
//            //fazendo a coneção
////            conn = DriverManager.getConnection("colocar senha ");
//            return true;
//        }
//        catch (SQLException sqle){
//            System.out.println("Servidor não encontrado\n"+sqle);
//            return false;
//        }
//        catch (ClassNotFoundException cnfe){
//            System.out.println("Classe não encontrada\n"+cnfe);
//            return false;
//        }
        return false;
    }
    // fazendo o método para desconectar com o banco
    public boolean desconectar(){
        try{
            if (conn != null && !conn.isClosed()){
                // desconectando do bd
                conn.close();
            }
            return true;
        }catch ( SQLException sql){
            System.out.println("erro :"+sql.getMessage());
            sql.printStackTrace();
            return false;
        }
    }
    //fazendo metodo busca para mostrar toda a tabela
    public ResultSet buscar(){
        conectar();
        ResultSet rset = null;
        try {
            //usando o psmt para fazer um instrução sql
            psmt = conn.prepareStatement("Select * from admin");
            rset = psmt.executeQuery();
            return rset;
            // Fazendo o catch para verificar se o sql apresentar algum erro séra apresentado retonar uma string
        }catch (SQLException e){

            System.out.println("erro no buscar");
            return rset;
        }
        finally {
            desconectar();
        }
    }
//    fazendo uma sobrecarga no metodo buscar , para fazer uma busca na tabela pela a pk dela
    public ResultSet buscar(int pk){
        conectar();
        ResultSet rset = null;
        try {
            psmt = conn.prepareStatement("Select * from admin where id = ? ");
            psmt.setInt(1,pk);
            rset = psmt.executeQuery();
            return rset;
        }catch (SQLException e){
            //cath para retornar erro de Sql
            System.out.println("erro no buscar");
            return rset;
        }
        finally {
            //usando o finally para toda fez antes do return use o método desconectar
            desconectar();
        }
    }
    public int inserirAdmin(String nome,String senha,String email){
        conectar();
        try {
            psmt = conn.prepareStatement("insert into admin values (?,?,?)");
            psmt.setString(1,nome);
            psmt.setString(2,email);
            psmt.setString(3,senha);
            return 1;
        }catch (SQLException e){
            System.out.println("Erro no inserir admin");
            return -1;
        }finally {
            desconectar();
        }
    }
    public int atualizarNome(int pk,String novo_nome){
        conectar();
        try {
            ResultSet busca = buscar(pk);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("Update admin set nome =  ? where id = ? ");
                psmt.setString(1, novo_nome);
                psmt.setInt(2, pk);
                psmt.execute();
                return 0;
            }
            return 1;
        }catch (SQLException e){
            System.out.println("Erro no atualizar nome :"+e.getMessage());
            e.printStackTrace();
            return -1;
        }
        finally {
            desconectar();
        }
    }
    public int atualizarEmail(int pk,String novo_email){
        conectar();
        try {
            ResultSet busca = buscar(pk);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("Update admin set email =  ? where id = ? ");
                psmt.setString(1, novo_email);
                psmt.setInt(2, pk);
                psmt.execute();
                return 0;
            }
            return 1;
        }catch (SQLException e){
            System.out.println("Erro no atualizar nome :"+e.getMessage());
            e.printStackTrace();
            return -1;
        }
        finally {
            desconectar();
        }
    }
    public int atualizarSenha(int pk,String nova_senha){
        conectar();
        try {
            ResultSet busca = buscar(pk);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("Update admin set senha =  ? where id = ? ");
                psmt.setString(1, nova_senha);
                psmt.setInt(2, pk);
                psmt.execute();
                return 0;
            }
            return 1;
        }catch (SQLException e){
            System.out.println("Erro no atualizar nome :"+e.getMessage());
            e.printStackTrace();
            return -1;
        }
        finally {
            desconectar();
        }
    }
    public int deletarAdmin(int pk){
        conectar();
        try {
            ResultSet busca = buscar(pk);
            //verificando se existe o adminitrador
            if (busca.next()) {
                psmt = conn.prepareStatement("Delete from admin where id = ?  ");
                psmt.setInt(1, pk);
                psmt.execute();
                return 0;
            }
            return 1;
        }catch (SQLException e){
            System.out.println("Erro no atualizar nome :"+e.getMessage());
            e.printStackTrace();
            return -1;
        }
        finally {
            desconectar();
        }
    }
}

