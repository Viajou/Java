package org.viajou.crudviajou.admin;

import org.viajou.crudviajou.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

// Metodo para leitura da tabela admin
    public ResultSet buscar(){
//  Instanciando os objetos

        // Instanciando o objeto da classe Conexao, que possui os métodos para conectar e desconectar do o banco de dados
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        ResultSet rset = null;
        try {
            // Inicializando o objeto da classe Connection com o método getConn da classe Conexao
            Connection conn = conexao.getConn();

            // Usando o objeto da classe PreparedStatement para fazer uma instrução sql
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin");

            // Executando a busca
            rset = pstmt.executeQuery();

            // Caso a busca ocorra corretamente, o método retorna o resultado
            return rset;
        } catch (SQLException sqle) {
            // Caso ocorra alguma exceção SQL, ela cai no catch
            return rset;
        } finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

//  Metodo para leitura da tabela admin com base em um ID
    public ResultSet buscar(int id){
//  Instanciando os objetos

        // Instanciando o objeto da classe Conexao, que possui os métodos para conectar e desconectar do o banco de dados
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        ResultSet rset = null;
        try {
            // Inicializando o objeto da classe Connection com o método getConn da classe Conexao
            Connection conn = conexao.getConn();

            //Usando o objeto da classe PreparedStatement para fazer uma instrução sql
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin WHERE id = ? ");
            pstmt.setInt(1,id);

            // Executando a busca
            rset = pstmt.executeQuery();
            // Caso a busca ocorra corretamente, o método retorna o resultado
            return rset;
        } catch (SQLException sqle){
            // Caso ocorra alguma exceção SQL, ela cai no catch
            return rset;
        }
        finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
//  Método para adicionar um admim na tabela
    public int inserirAdmin(Admin admin){
//  Instanciando os objetos

        // Instanciando o objeto da classe Conexao, que possui os métodos para conectar e desconectar do o banco de dados
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Inicializando o objeto da classe Connection com o método getConn da classe Conexao
            Connection conn = conexao.getConn();

            // Usando o objeto da classe PreparedStatement para fazer uma instrução sql
            PreparedStatement pstmt  = conn.prepareStatement("INSERT INTO admin(nome,email,senha) VALUES (?,?,?)");

            // Inserindo o nome do novo adminstrador com base no objeto no parâmetro do metodo
            pstmt.setString(1,admin.getNome());

            // Inserindo o email do novo adminstrador com base no objeto no parâmetro
            pstmt.setString(2, admin.getEmail());

            // Inserindo a senha do novo adminstrador com base no objeto no parâmetro
            pstmt.setString(3,admin.getSenha());

            // Executando a inserção
            pstmt.execute();
            return 1;
        }catch (SQLException sqle){
            // Retornado -1 para enviar para uma pagina especifica
            return -1;
        }finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }

// Alterações na tabela admin
    // Método para alterar o nome de usuário do admin
    public int alterarNome(int id, String nome){
        // Instanciando o objeto da classe Conexao, que possui os métodos para conectar e desconectar do o banco de dados
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o administrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                // Inicializando o objeto da classe Connection com o método getConn da classe Conexao
                Connection conn = conexao.getConn();

                // Usando o objeto da classe PreparedStatement para fazer uma instrução sql
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET nome =  ? WHERE id = ? ");

                // Alterando a tabela usando as informações passadas no parâmetro
                pstmt.setString(1, nome);
                pstmt.setInt(2, id);

                // Executando a alteração
                pstmt.execute();

                // Caso a alteração ocorra corretamente, o retorno é 1
                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        }catch (SQLException sqle){
            // Caso ocorra alguma exceção SQL, o retorno é -1
            return -1;
        }
        finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    // Método para alterar o e-mail do admin
    public int alterarEmail(int id, String email){
        // Instanciando o objeto da classe Conexao, que possui os métodos para conectar e desconectar do o banco de dados
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o adminstrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                // Inicializando o objeto da classe Connection com o método getConn da classe Conexao
                Connection conn = conexao.getConn();

                // Usando o objeto da classe PreparedStatement para fazer uma instrução sql
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET email =  ? WHERE id = ? ");

                // Alterando a tabela usando as informações passadas no parâmetro
                pstmt.setString(1, email);
                pstmt.setInt(2, id);

                // Executando a alteração
                pstmt.execute();

                // Caso a alteração ocorra corretamente, o retorno é 1
                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        }catch (SQLException sqle){
            // Caso ocorra alguma exceção SQL, o retorno é -1
            return -1;
        }
        finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    // Método para mudar a senha do admin
    public int alterarSenha(int id, String senha){
        // Instanciando o objeto da classe Conexao, que possui os métodos para conectar e desconectar do o banco de dados
        Conexao conexao = new Conexao();

        // Conectando com o BD
        conexao.conectar();
        try {
            // Verificando se o administrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                // Inicializando o objeto da classe Connection com o método getConn da classe Conexao
                Connection conn = conexao.getConn();
                // Usando o objeto da classe PreparedStatement para fazer uma instrução sql
                PreparedStatement pstmt = conn.prepareStatement("UPDATE admin SET senha =  ? WHERE id = ? ");

                // Alterando a tabela usando as informações passadas no parâmetro
                pstmt.setString(1, senha);
                pstmt.setInt(2, id);

                // Executando a alteração
                pstmt.execute();

                // Caso a alteração ocorra corretamente, o retorno é 1
                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        }catch (SQLException sqle){
            // Caso ocorra alguma exceção SQL, o retorno é -1
            return -1;
        }
        finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
    // Método excluir um usuario da tabela admin
    public int deletarAdmin(int id){
        // Instanciando o objeto da classe Conexao, que possui os métodos para conectar e desconectar do o banco de dados
        Conexao conexao = new Conexao();

        // Conectando com o DB
        conexao.conectar();
        try {
            // Verificando se o adminstrador existe
            ResultSet busca = buscar(id);

            // Verificando se a busca teve resultados
            if (busca.next()) {
                // Inicializando o objeto da classe Connection com o método getConn da classe Conexao
                Connection conn = conexao.getConn();

                // Usando o objeto da classe PreparedStatement para fazer uma instrução sql
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM admin WHERE id = ?");

                // Deletando a informação da tabela com base no ID passado no parâmetro
                pstmt.setInt(1, id);

                // Executando a deleção
                pstmt.execute();

                // Caso a deleção ocorra corretamente, o retorno é 1
                return 1;
            }
            // Caso não existam usuários com o id do parâmetro, o retorno é 0
            return 0;
        }catch (SQLException sqle){
            // Caso ocorra alguma exceção SQL, o retorno é -1
            return -1;
        }finally {
            // Desconectando do BD ao final do try
            conexao.desconectar();
        }
    }
}
