package __Aula4_ED;

// Classe __Aula4_ED: encarregada de executar alguns testes/funcionalidades
// com a estrutura de dados Pilha.
// Autor: Ivan Carlos Alcântara de Oliveira.
// Data da Criação: 07/09/2024. 15h.
public class __Aula4_ED {

	public static void main(String[] args) {
		try {
			// Criação da Pilha p com tamanho padrão
			Pilha p = new Pilha();
		    // Inserção de valores na Pilha p
			p.push(4);
			p.push(5);		
			p.push(10);
			p.push(9);
			p.push(8);
            // Apresenta os dados da Pilha p
			System.out.println("Pilha inicial (após algumas inserções):");
			System.out.println(p);
			System.out.println("Distância do 5 em relação ao topo: " + p.search(5));
			System.out.println("Distância do 6 em relação ao topo: " + p.search(6));
			// inverte o conteúdo da pilha			
			p.inverts();	
			System.out.println("Pilha após a inversão:");
			System.out.println(p);		
			System.out.println("Distância do 5 em relação ao topo: " + p.search(5));
			// remove os ímpares da pilha e deixa a pilha na mesma ordem
			p.popEvenOdd(1); 
			System.out.println("Estado da Pilha depois de removidos os ímpares:");
			System.out.println(p);	
			// Inserção de mais valores na Pilha p
			p.push(12);
			p.push(8);
			p.push(22);
			p.push(34);
			System.out.println("Pilha (após mais inserções):");
			System.out.println(p);
			// remove os múltiplos de 4 da pilha e deixa a pilha na mesma ordem
			p.popMultiple(4); 
			System.out.println("Estado da Pilha depois de removidos os múltiplos de 4:");
			System.out.println(p);	
			// Inserção de mais alguns valores na Pilha p
			p.push(15);
			p.push(6);
			p.push(17);
			p.push(33);
			System.out.println("Pilha (após mais algumas inserções):");
			System.out.println(p);
			// remove os pares da pilha e deixa a pilha na mesma ordem
			p.popEvenOdd(2); 
			System.out.println("Estado da Pilha depois de removidos os pares:");
			System.out.println(p);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
