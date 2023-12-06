package poo;

import java.util.Scanner;

public class Main {
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        Agenda agenda = new Agenda();
	        
	        	while (true) {
	        		exibirMenu();
	        		int opcao = obterOpcaoUsuario();
	        		try {
	        			switch (opcao) {
	        			case 1:
	        				adicionarContato(agenda);
	        				break;
	        			case 2:
	        				removerContato(agenda);
	        				break;
	        			case 3:
	        				editarContato(agenda);
	        				break;
	        			case 4:
	        				visualizarContatos(agenda);
	        				break;
	        			case 5:
	        				System.out.println("Saindo da aplicacao. Ate mais!");
	        				System.exit(0);
	        				break;
	        			default:
	        				System.out.println("Opcao invalida. Tente novamente.");
	        			}
						
					} catch (Exception e) {
						System.out.print(e.getMessage());
					}
	        	}
				
			
	    }

	    private static void exibirMenu() {
	        System.out.println("\n-------- Menu --------");
	        System.out.println("1. Adicionar Contato");
	        System.out.println("2. Remover Contato");
	        System.out.println("3. Editar Contato");
	        System.out.println("4. Visualizar Contatos");
	        System.out.println("5. Sair");
	        System.out.println("----------------------");
	    }

	    private static int obterOpcaoUsuario() {
	        System.out.print("Escolha uma opcao: ");
	        while (!scanner.hasNextInt()) {
	            System.out.print("Entrada invalida. Digite novamente: ");
	            scanner.next();
	        }
	        return scanner.nextInt();
	    }

	    private static void adicionarContato(Agenda agenda) throws Exception {
	        agenda.AdicionarContato(null);
	    }
	    
	    private static void removerContato(Agenda agenda) throws Exception {
	       agenda.RemoverContato(null);
	    }

	    private static void editarContato(Agenda agenda) throws Exception  {
	        agenda.EditarContato(null);
	    }

	    private static void visualizarContatos(Agenda agenda) throws Exception {
	        agenda.visualizarContatos(null);
	    }
	   
	}
