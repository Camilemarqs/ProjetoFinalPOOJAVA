	package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

	private static ArrayList<Contato> contatos;
	private Scanner scanner;

	
	public Agenda(){
		contatos = new ArrayList<Contato>();
		scanner = new Scanner(System.in);
	}
	public ArrayList<Contato> getContatos(){
		return contatos;
	}
	
	public void AdicionarContato(Contato contato) throws Exception{
		
		System.out.println("\nAdicionando Novo Contato:");

        System.out.print("Nome: \n");
        String nome = scanner.next();

        System.out.print("Numero:(com DDD e sem espaco)\n");
        String numero = scanner.next();

        System.out.print("Email: \n");
        String email = scanner.next();

        System.out.println("\nEscreva o tipo de contato: ");
        System.out.println("Pessoal ou profissional");
        
        TipoContato tipoContato = TipoContato.converter(scanner.next());

        if(tipoContato.equals(TipoContato.PESSOAL)) {
        	System.out.print("Aniversario:(apenas numeros) \n");
        	scanner.nextLine();
        	String aniversario = scanner.nextLine();

 	       	System.out.print("Notas: \n");
 	        String notas = scanner.nextLine();
 	        
        	contatos.add(new ContatoPessoal(nome, numero, email, aniversario, notas));
        }
        else if(tipoContato.equals(TipoContato.PROFISSIONAL)) {
            System.out.print("Empresa: \n");          
            scanner.nextLine();
            String empresa = scanner.next();

            System.out.print("Cargo: \n");
            String cargo = scanner.next();

            contatos.add(new ContatoProfissional(nome, numero, email, empresa, cargo));
        }

        System.out.println("Contato adicionado com sucesso!");
    }

	public void RemoverContato(Contato contato) throws Exception{
		if(contatos.isEmpty()) {
			throw new Exception("Não existem contatos para serem removidos!");
		} else {
		 System.out.println("\nRemovendo Contato:");

	        System.out.print("Nome do Contato a ser removido: ");
	        String nomeContato = scanner.next();

	        Contato contatoParaRemover = encontrarContatoPorNome(nomeContato);

	        if(contatoParaRemover != null) {
	            contatos.remove(contatoParaRemover);
	            System.out.println("Contato removido com sucesso!");
	        } 
	        else{
	            throw new Exception("Contato nao encontrado.");
	        }
		}     
	}
	
	public void EditarContato(Contato contato) throws Exception {
	    if (contatos.isEmpty()) {
	        throw new Exception("Não existem contatos para serem editados!");
	    } else {
	        System.out.println("\nEditando Contato:");

	        System.out.print("Nome do Contato a ser editado: ");
	        String nomeContato = scanner.next().trim();

	        Contato contatoParaEditar = encontrarContatoPorNome(nomeContato);

	        if (contatoParaEditar != null) {
	            boolean continuarEdicao = true;

	            while (continuarEdicao) {
	                System.out.println("Escolha a parte do contato a ser editada:");
	                System.out.println("1. Nome");
	                System.out.println("2. Numero");
	                System.out.println("3. Email");
	                System.out.println("4. Aniversario e Notas (apenas para contatos pessoais)");
	                System.out.println("5. Empresa e Cargo (apenas para contatos profissionais)");
	                System.out.println("0. Concluir a edicao");

	                int escolha = scanner.nextInt();
	                scanner.nextLine(); // Limpar o buffer

	                switch (escolha) {
	                    case 1:
	                        System.out.print("Novo Nome: ");
	                        String novoNome = scanner.nextLine().trim();
	                        contatoParaEditar.setNome(novoNome);
	                        break;
	                    case 2:
	                        System.out.print("Novo Numero: ");
	                        String novoNumero = scanner.nextLine().trim();
	                        contatoParaEditar.setNumero(novoNumero);
	                        break;
	                    case 3:
	                        System.out.print("Novo Email: ");
	                        String novoEmail = scanner.nextLine().trim();
	                        contatoParaEditar.setEmail(novoEmail);
	                        break;
	                    case 4:
	                        if (contatoParaEditar instanceof ContatoPessoal) {
	                            ContatoPessoal contatoPessoal = (ContatoPessoal) contatoParaEditar;
	                            System.out.print("Novo Aniversario: ");
	                            String novoAni = scanner.nextLine().trim();
	                            contatoPessoal.setAniversario(novoAni);

	                            System.out.print("Novas Notas: ");
	                            String novasNotas = scanner.nextLine().trim();
	                            contatoPessoal.setNotas(novasNotas);
	                            }	                        
	                        break;
	                    case 5:
	                        if (contatoParaEditar instanceof ContatoProfissional) {
	                            ContatoProfissional contatoProfissional = (ContatoProfissional) contatoParaEditar;
	                            System.out.print("Nova Empresa: ");
	                            String novaEmpresa = scanner.nextLine().trim();;
	                            contatoProfissional.setEmpresa(novaEmpresa);
	                            

	                            System.out.print("Novo Cargo: ");
	                            String novoCargo = scanner.nextLine().trim();
	                            contatoProfissional.setCargo(novoCargo);
	                        }
	                        break;
	                    case 0:
	                        continuarEdicao = false;
	                        break;
	                    default:
	                        System.out.println("Escolha invalida. Por favor, escolha uma opção valida.");
	                        break;
	                }

	                System.out.println("Contato editado com sucesso!");

	                System.out.print("Deseja continuar editando outras partes do contato? (S/N): ");
	                String continuar = scanner.nextLine();
	                continuarEdicao = continuar.equalsIgnoreCase("S");
	            }
	        } else {
	            throw new Exception("Contato não encontrado.");
	        }
	    }
	}

	public void visualizarContatos(Contato contato) throws Exception{
		if (contatos.isEmpty()) {
	       throw new Exception("A agenda esta vazia.");
	    }
		else {
			System.out.println("\nVisualizando Contatos:");
	        System.out.println("Contatos na agenda:");
	        for (Contato contt : contatos) {
	            System.out.println(contt.toString());
	            System.out.println();
	        }
	    }
	}
	
	//metodo auxiliar para procurar contato na lista
	 private static Contato encontrarContatoPorNome(String nomeContato) {
	        for(Contato contato : contatos) {
	            if(contato.getNome().equals(nomeContato)) {
	                return contato;
	            }
	        }
	        return null;
	    }

}
