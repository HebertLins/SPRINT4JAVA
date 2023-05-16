package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import program.Cadastro;
import connection.ConnectionFactory;

public class JogadorDAO {
	
	public void insert(Cadastro c) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement;
       
        try {
            String query = String.format("insert into jogador (nome,email,id_jogador,barra_prog,nivel,comunidade_id_comunidade,avatar_id_avatar,assistente_id_assistente,loja_cosmec_id_loja) values('%s','%s',%s,%s,%s,%s,%s,%s,%s)", 
            		c.getNome(), c.getEmail(), c.getId(), 0, 1, 1, 1, 1, 1);
           
            statement = conn.createStatement();          
            statement.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Erro ao inserir o usuário! - " + e);
        }
        finally {
        	conn.close();
        }
	}
	
	public ArrayList<Cadastro> getAll() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement;
        ResultSet rs = null;
        ArrayList<Cadastro> list = null;
       
        try {
            String query= "select * from jogador order by id";
            
            statement=conn.createStatement();
           
            rs = statement.executeQuery(query);
           
            list = new ArrayList<Cadastro>(); 
            while(rs.next()){
            	Cadastro c = new Cadastro();
            	c.setId(Integer.parseInt(rs.getString("id")));
            	c.setNome(rs.getString("nome"));
            	
                list.add(c);
            }
        }catch (Exception e){
            System.out.println("Erro ao exibir o usuário! - " + e);
        }
        finally {
        	conn.close();
        }
        
        return list;
	}
	
	public int contaLinha() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement;
        ResultSet rs = null;
        int cl = 0;
        
       
        try {
            String query= "select * from jogador order by id_jogador";
            statement=conn.createStatement();
           
            rs = statement.executeQuery(query);
           
            while(rs.next()){
            	cl = cl + 1;
            }
        }catch (Exception e){
            System.out.println("Erro ao exibir o usuário! - " + e);
        }
        finally {
        	conn.close();
        }
        
		return cl;
	}
	
	
	public void delete(int id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement;
       
        try {
            String query = String.format("delete from tb_usuario where id = %s", id);
           
            statement = conn.createStatement();          
            statement.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Erro ao excluir o usuário! - " + e);
        }
        finally {
        	conn.close();
        }
	}
	
	public void update(Usuario u) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement;
       
        try {
            String query = String.format("update tb_usuario set nome = '%s' where id = %s", u.getNome(), u.getId());
           
            statement = conn.createStatement();          
            statement.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Erro ao atualizar o usuário! - " + e);
        }
        finally {
        	conn.close();
        }
	}
}
