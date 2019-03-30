//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Daniel Barros de Oliveira
//******************************************************

// pacote atual
package br.com.escola.dal;

// importando pacote java.sql.*;
import java.sql.*;

public class ModuloConexao {
    
    // Método responsável por fazer a conexão com o Banco de dados.
    public static Connection conector(){
        // variavel conexao irá receber a string de conexao.
        java.sql.Connection conexao = null;
        
        // A linha abaixo "chama" o driver de Conexão do Java com MYSQL
        String driver = "com.mysql.jdbc.Driver";
        
        // As variáveis abaixo irão armazenar os dados do Banco
        String url = "jdbc:mysql://localhost:3306/escola";
        String user = "root";
        String password = "";
        
        // Estabelecendo a Conexão com o Banco de Dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception erro) {
            return null;
        }
    }
    
}
