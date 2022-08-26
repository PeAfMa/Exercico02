package maven.demo;



public class Principal
{
	public static void main(String[] args)
	{
		DAO dao = new DAO();
		int opcao;
		String CPF;
		String nome;
		String telefone;
		String endereco;
		char sexo;
		double salario;
		
		dao.conectar();
		do
		{
			MyIO.println("Escolha uma opcao\n"
					+ "1 - Listar funcionarios\n"
					+ "2 - Inserir funcionarios\n"
					+ "3 - Excluir funcinarios\n"
					+ "4 - Atualizar dados\n"
					+ "5 - Sair\n");
			opcao = MyIO.readInt();
			switch (opcao)
			{
			case 1:
			{
				MyIO.println("==== Listar Funcionarios === ");
				Funcionario[] funcionarios = dao.getFuncionarios();
				for(int i = 0; i < funcionarios.length; i++) {
					MyIO.println(funcionarios[i].toString());
				}
				break;
			}
			case 2:
			{
				MyIO.println("==== Inserir Funcionarios === ");
				MyIO.println("Digite o CPF:");
				CPF = MyIO.readLine();
				MyIO.println("Digite o nome:");
				nome = MyIO.readLine();
				MyIO.println("Digite o telefone:");
				telefone = MyIO.readLine();
				MyIO.println("Digite o endereço:");
				endereco = MyIO.readLine();
				MyIO.println("Digite o sexo:");
				sexo = MyIO.readChar();
				MyIO.println("Digite o salario:");
				salario = MyIO.readDouble();
				
				Funcionario funcionario = new Funcionario(CPF, nome, telefone, endereco, sexo, salario);
				if (dao.inserirFuncionario(funcionario))
				{
					MyIO.println("Funcionário inserido");
				}
				else
				{
					MyIO.println("Falha ao inserir");
				}
				break;
				
			}
			case 3:
			{
				MyIO.println("==== Excluir Funcionarios === ");
				MyIO.println("Digite o cpf do funcionario a ser excluido:\n");
				CPF = MyIO.readLine();
				if(dao.excluirFuncionario(CPF))
				{
					MyIO.println("Funcionario excluido");
				}
				else
				{
					MyIO.println("Falha ao excluir funcionario");
				}
				break;
			}
			case 4:
			{
				MyIO.println("==== Atualizar dados === ");
				MyIO.println("Digite o CPF do cadastro a ser atualizado:\n");
				CPF = MyIO.readLine();
				MyIO.println("Digite o novo nome:");
				nome = MyIO.readLine();
				MyIO.println("Digite o novo telefone:");
				telefone = MyIO.readLine();
				MyIO.println("Digite o novo endereço:");
				endereco = MyIO.readLine();
				MyIO.println("Digite o novo sexo:");
				sexo = MyIO.readString().charAt(0);
				MyIO.println("Digite o novo salario:");
				salario = MyIO.readDouble();
				Funcionario funcionario = new Funcionario(CPF, nome, telefone, endereco, sexo, salario);
				if (dao.atualizarFuncionario(funcionario))
				{
					MyIO.println("Funcionário atualizado");
				}
				else
				{
					MyIO.println("Falha ao atualizar");
				}
				break;
			}
			case 5:
				MyIO.println("Programa encerrado");
			}
		}
		while(opcao != 5);
		
			
	}
}
