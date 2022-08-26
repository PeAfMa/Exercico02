package maven.demo;

public class Funcionario
{
	private String CPF;
	private String nome;
	private String telefone;
	private String endereco;
	private char sexo;
	private double salario;
	
	public Funcionario()
	{
		this.CPF = "";
		this.nome = "";
		this.telefone = "";
		this.endereco = "";
		this.sexo = '*';
		this.salario = -1;
	}
	
	public Funcionario(String CPF, String nome, String telefone, String endereco, char sexo, double salario)
	{
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.sexo = sexo;
		this.salario = salario;
	}
	
	public String getCPF()
	{
		return CPF;
	}
	
	public void setCPF(String CPF)
	{
		this.CPF = CPF;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getTelefone()
	{
		return telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public String getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	
	public char getSexo()
	{
		return sexo;
	}
	
	public void setSexo(char sexo)
	{
		this.sexo = sexo;
	}
	
	public double getSalario()
	{
		return salario;
	}
	
	public void setSalario(double salario)
	{
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "FUNCIONARIO [CPF=" + CPF + ", Nome=" + nome + ", Telefone=" + telefone + ", Endereco=" + endereco + ", Sexo=" + sexo + ", Salario=" + salario + "]";
	}
}
