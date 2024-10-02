package __Aula4_ED;

import java.util.Stack;

// Classe relativa a estrutura de dados Pilha 
// sequencial capaz de armazenar dados inteiros
// Autor1: Ivan Carlos Alcântara de Oliveira.
// Data da Criação: 07/09/2024. 15h.
// Autor2: <Andreia do Nascimento Oliveira RA: 10424500>
// Data da Atualização: <DATA-HORA>

public class Pilha  {
	private static final int TAM_DEFAULT = 100;
	private	int topo; // ponteiro do topo da pilha
	private	int e[ ]; // array de inteiros correspondente a Pilha
	// Construtor 1
	// Cria uma Pilha com o tamanho passado como parâmetro
	public	Pilha(int tamanho) {
		this.e = new int[tamanho];
		this.topo = -1;
	}
	// Construtor 2
	// Cria uma Pilha com o tamanho padrão "TAM_DEFAULT"
	public	Pilha() {
		this(TAM_DEFAULT);
	}
	//Verifica se a Pilha
	//está vazia
	public boolean isEmpty() {
		return this.topo == -1;
	}
	// Verifica se a Pilha está
	// cheia
	public boolean isFull() {
		return this.topo == this.e.length-1;
	}

	// Limpa a Pilha, deixando-a vazia
	public void clear() throws Exception{
		while (!isEmpty()) {
			pop();
		}
	}
	// insere um elemento "e"
	// no topo da Pilha
	public void push(int e) throws Exception{
		if (! this.isFull( ))
			this.e[++this.topo] = e;
		else
			throw new Exception("Stack Overflow");
	}
	// remove e retorna o elemento que está no
	// topo da Pilha
	public int pop() throws Exception{
		if (! this.isEmpty( ))
			return this.e[this.topo--];
		else{
			throw new Exception("Stack Underflow");
		}
	}
	// Retorna o elemento que está
	// no topo da Pilha
	public int peek() throws Exception{
		if ( ! this.isEmpty( ))
			return this.e[this.topo];
		else{
			throw new Exception("Stack Underflow");
		}
	}
	// obtém o total de elementos
	// armazenados na Pilha
	public int size() {
		return topo+1;
	}

	// retorna a distância da primeira ocorrência do inteiro "e" informado
	// como parâmetro em relação ao topo da Pilha ou retorna -1 se o
	// inteiro "e" não existir na Pilha.
	public int search(int e) {
		for (int i = topo; i >= 0; i--) {
			if (this.e[i] == e) {
				return topo - i;
			}
		}
		return -1; // Não encontrado
	}

	// realiza a inversão do conteúdo da Pilha
	// o elemento do topo deve ficar na base e
	// o da base deve se tornar o do topo
	public void inverts() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty stack, cannot invert.");
		}

		// Usamos uma pilha temporária para inverter os elementos
		Pilha tempStack = new Pilha(this.e.length);
		while (!isEmpty()) {
			tempStack.push(pop());
		}

		this.e = tempStack.e;
		this.topo = tempStack.topo;
	}

	// remove os elementos da Pilha que
	// são múltiplos de um certo número (nro)
	// passado como parâmetro, deixando os
	// outros na ordem original.
	public void popEvenOdd(int type) throws Exception {
		if (type != 1 && type != 2) {
			throw new Exception("The parameter to the popEvenOdd method must be 1 for odd and 2 for even");
		}

		Pilha tempStack = new Pilha(this.e.length);  // Para armazenar os elementos a serem mantidos
		while (!isEmpty()) {
			int topElement = pop();
			if ((type == 1 && topElement % 2 == 1) || (type == 2 && topElement % 2 == 0)) {
				// Ignorar elementos pares ou ímpares dependendo do tipo
				continue;
			} else {
				tempStack.push(topElement);  // Manter o elemento se ele não for removido
			}
		}

		// Coloca os elementos de volta na pilha original na ordem correta
		while (!tempStack.isEmpty()) {
			push(tempStack.pop());
		}
	}

	// Remove os elementos da Pilha que são múltiplos de um certo número (nro)
	// passado como parâmetro, deixando os outros na ordem original.
	public void popMultiple(int nro) throws Exception {
		if (nro == 0) {
			throw new Exception("Cannot check multiples of zero.");
		}

		Pilha tempStack = new Pilha(this.e.length); // Pilha temporária para armazenar os elementos a serem mantidos

		while (!isEmpty()) {
			int topElement = pop();
			if (topElement % nro != 0) {
				tempStack.push(topElement); // Mantém os que não são múltiplos de nro
			}
		}

		// Reinsere os elementos na pilha original na ordem correta
		while (!tempStack.isEmpty()) {
			push(tempStack.pop());
		}
	}

	// Sobrescrita/sobreposição (override) do método toString(), que veio da superclasse Object.
	// O retorno do método toString() é a representação de um objeto em formato string, e toString()
	// geralmente é executado (de forma implícita) quando passamos um objeto ao System.out.print*().
	//
	// Experimente incluir o seguinte código na main() e veja a saída:
	// Pilha p = new Pilha();
	// System.out.println(p);
	//
	// Depois, remova/comente o método toString() abaixo e rode o código acima novamente.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  [Stack] top: ")
				.append(this.topo)
				.append(", capacity: ")
				.append(e.length)
				.append(", size: ")
				.append(size());
		if (this.topo != -1) {
			sb.append(", Top value: ")
					.append(this.e[this.topo]);
		}else sb.append(", \r\n" + "Top value: EMPTY STACK");

		sb.append("\n  Stack Contents: [ ");

		for (int i = this.topo; i >= 0; --i)
			if (i != 0) sb.append( e[i] + ", ");
			else sb.append( e[i] );
		sb.append( " ]");
		return sb.toString();
	}

}
