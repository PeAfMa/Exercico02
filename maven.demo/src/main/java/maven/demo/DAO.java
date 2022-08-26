package maven.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import maven.demo.Funcionario;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "Exercicio02";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirFuncionario(Funcionario funcionario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO \"public\".\"FUNCIONARIO\" (\"CPF\", \"Nome\", \"Telefone\", \"Endereco\", \"Sexo\", \"Salario\") "
					       + "VALUES ('"+funcionario.getCPF()+ "',' " + funcionario.getNome() + "',' "  
					       + funcionario.getTelefone() + "', '" + funcionario.getEndereco() +  "', '" 
					       + funcionario.getSexo() +  "', '" + funcionario.getSalario() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarFuncionario(Funcionario funcionario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = ("UPDATE \"public\".\"FUNCIONARIO\" SET \"Nome\" = '" + funcionario.getNome() + "', \"Telefone\" = '" + funcionario.getTelefone() + "', \"Endereco\" = '"
					+ funcionario.getEndereco() + "', \"Sexo\" = '" + funcionario.getSexo() + "', \"Salario\" = '" + funcionario.getSalario() + "' WHERE \"CPF\" = '" + funcionario.getCPF() + "'");
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirFuncionario(String CPF) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM \"public\".\"FUNCIONARIO\" WHERE \"CPF\" = '" + CPF + "'");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Funcionario[] getFuncionarios() {
		Funcionario[] funcionarios = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM \"public\".\"FUNCIONARIO\"");		
	         if(rs.next()){
	             rs.last();
	             funcionarios = new Funcionario[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                funcionarios[i] = new Funcionario(rs.getString("CPF"), rs.getString("Nome"), 
	                		                  rs.getString("Telefone"), rs.getString("Endereco"), 
	                		                  rs.getString("Sexo").charAt(0), rs.getDouble("Salario"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return funcionarios;
	}

}