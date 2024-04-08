
package com.home.listaordenada;

interface MetodosListaLineares<T> {
   // Cria um vetor vazio 
    void criar(int tamanho);
    boolean VerificarListaVazia();    
    boolean VerificarListaCheia();    
    int exibirQuantidade();
    int buscar(T elemento);
    int buscaOrdenada(T elemento);
    int buscaBinaria(T elemento);
    boolean inserirNaPosicao(T elemento, int posicao);
    boolean inserirOrdenado(T elemento);
    boolean inserir(T elemento);  
    boolean removeElemento(T elemento);    
    // Aumenta uma posição no vetor
    T[] alocaMaisUm();
 
}

class Lista<T extends Comparable<T>> implements MetodosListaLineares<T> {

    private T[] vetor;
    private int quantidade;
    
    public Lista() {

    }

    public T[] getVetor() {
        return vetor;
    }

    public void setVetor(T[] vetor) {
        this.vetor = vetor;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public T getElemento(int indice) {
        return vetor[indice];
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    

    public Lista(T[] vetor) {
        // Cria um novo vetor com um elemento no fim para teste. Mais eficiente
        this.vetor = (T[]) new Comparable[vetor.length + 1]; 
        
        for (int i = 0; i < vetor.length; i++) {
        this.vetor[i] = vetor[i]; // Copia os elementos do vetor original para o novo vetor
        }
                
        quantidade = (vetor.length);
    }

    
    @Override
    public boolean removeElemento(T elemento) {

        //Lista está vazia
        if (this.VerificarListaVazia()) {
            System.out.println("Nao removeu - Lista vazia");
            return false;
        }

        int PosRem = this.buscar(elemento);

        //Elemento não foi encontrado       
        if (PosRem == -1) {
             System.out.println("Nao removeu - Elemento não encontrado");
            return false;
        }

        for (int i = PosRem; i < (this.quantidade - 1); i++) {
            this.vetor[i] = this.vetor[i + 1];
        }
        this.quantidade--;
        
        System.out.println("Elemento removido");
        return true;
    }

    @Override

    public void criar(int tamanho) {

        @SuppressWarnings("unchecked")
        T[] novoVetor;
        novoVetor = (T[]) new Comparable[tamanho + 1];
        this.vetor = novoVetor;
        this.quantidade = 0;

    }
    
    @Override
    public T[] alocaMaisUm() {
        T[] novoVetor;
        novoVetor = (T[]) new Comparable[this.vetor.length + 1];
        
        for (int i = 0; i < (this.quantidade); i++) {
          novoVetor[i] = this.vetor[i];  
        } 
        
       // this.vetor = novoVetor;
                     
        return novoVetor;
    }

    @Override
    public int buscar(T elemento) {
        for (int i = 0; i < this.quantidade; i++) {
            if (vetor[i] != null && vetor[i].compareTo(elemento) == 0) {
                return i;
            }
        }

        return -1;

    }
    
    @Override
    public boolean inserir(T elemento) {
        
        // Aloca espaço se necessário
        if (this.vetor == null){
            this.criar(1);
        }
        //Lista está cheia
        if (this.VerificarListaCheia()) {
           
            // Opção 1 -  criar um outro vetor com um tamanho a mais
         this.vetor = this.alocaMaisUm();
         
            System.out.println("Lista Cheia - Alocando mais um espaço");
            
            /*
            // Opção 2 -  Informa que a Lista está cheia
            System.out.println("Lista Cheia - Não foi possível inserir");
            return false;
            */            
        }

        //Elemento já existe
        //Para admitir duplicadas comente o codigo abaixo
        if (this.buscar(elemento) != -1) {
            System.out.println("Elemento já existe");
            return false;
        }

        this.vetor[quantidade] = elemento;
        this.quantidade++;
        System.out.println("Elemento inserido");
        return true;
        
    }

    @Override
    public boolean VerificarListaVazia() {
    
        if (this.quantidade == 0){
            return true;    
        }
        return false;
    }

    @Override
    public boolean VerificarListaCheia() {
    
        if(this.quantidade == (this.vetor.length - 1)){ // O último elemento é para o teste no fim
            return true;
        }
        return false;
    
    }

    @Override
    public int exibirQuantidade() {
    return this.getQuantidade();
    }

    @Override
    public int buscaOrdenada(T elemento) {
        // Insere o elemento procurado no fim do vetor 
        this.vetor[this.quantidade +1] = elemento;
        int i = 0;
        //Enquanto a chave é menor que o elemento procurado
        while ( this.getElemento(i).compareTo(elemento) != 1) {            
            i++;
        }
        
        if ((i == this.quantidade + 1) || (this.getElemento(i).compareTo(elemento) != 0))   {
            return -1;
        }
        
        return i;
                
    }

    @Override
    public int buscaBinaria(T elemento) {
        int i = 0;
        int sup = (this.quantidade - 1); 
        int busca_bin = -1;
        
        while (i <= sup ) {
            int meio = (i + sup)/2;
            // 0 quer dizer igual
            if (this.getElemento(meio).compareTo(elemento) == 0){
                busca_bin = meio;
                i = sup + 1;  
            // -1 quer dizer menor
            } else if (this.getElemento(meio).compareTo(elemento) == -1){
                i = meio + 1;           
            }else {
                sup = meio - 1;
            }           
        }
        return busca_bin;
    
    }

    @Override
    public boolean inserirNaPosicao(T elemento, int posicao) {
        
        if (posicao < 0 || posicao > this.quantidade){
            System.out.println("Posição inválida");
            return false;        
        }
                
        
        
        // Aloca espaço se necessário
        if (this.vetor == null){
            this.criar(1);
        }
        
        //Elemento já existe
        //Para admitir duplicadas comente o codigo abaixo
        if (this.buscar(elemento) != -1) {
            System.out.println("Elemento já existe");
            return false;
        }        
        
        //Lista está cheia
        if (this.VerificarListaCheia()) {
           
            // Opção 1 -  criar um outro vetor com um tamanho a mais
         this.vetor = this.alocaMaisUm();
         
            System.out.println("Lista Cheia - Alocando mais um espaço");
            
            /*
            // Opção 2 -  Informa que a Lista está cheia
            System.out.println("Lista Cheia - Não foi possível inserir");
            return false;
            */            
        }

        //Desloca elementos para a direita
        int i = this.quantidade; 
        while (i > posicao){
            this.vetor[i] = this.vetor[i - 1];
            i--;
        }        
        
        this.vetor[posicao] = elemento;
        this.quantidade++;
        System.out.println("Elemento inserido na posição: " + posicao);
        return true;
                    
    }

    @Override
    public boolean inserirOrdenado(T elemento) {
        
        int posicaoCorreta = 0;
        
        while (posicaoCorreta < this.getQuantidade() && this.getElemento(posicaoCorreta).compareTo(elemento) < 0 ) {
            posicaoCorreta++;
        }
    
        return (this.inserirNaPosicao(elemento, posicaoCorreta));     
            
    }
    
    

}

public class Main {

    public static void main(String[] args) {
       
        // Inicio
        Integer[] inteiros = {4, 6, 9, 2, 1, 8, 0, 7, 3, 5};
        
        Lista<Integer> testeLista = new Lista<>(inteiros);

        Lista<Integer> lista = new Lista<>();
        
        //Aloca 12 posições
        lista.criar(12);

        int posicao = testeLista.buscar(0);
        
        //Imprimir a lista antes da remoção
        
        System.out.println("Lista antes das alterações: ");
        for (int i = 0; i < testeLista.getQuantidade(); i++) {
            
            System.out.print(testeLista.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        testeLista.removeElemento(7);
        
        //Imprimir a lista depois da remoção
        
        for (int i = 0; i < testeLista.getQuantidade(); i++) {
            
            System.out.print(testeLista.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        testeLista.inserir(23);
                
        for (int i = 0; i < testeLista.getQuantidade(); i++) {
            
            System.out.print(testeLista.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        
        testeLista.inserir(15);
        
        
        for (int i = 0; i < testeLista.getQuantidade(); i++) {
            
            System.out.print(testeLista.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        
        // Testando Lista de Pessoas
        
        Lista<Pessoa> listaPessoas = new Lista<>();
        
        Pessoa elementoPessoa = new Pessoa("Pedro", 25);
        
        listaPessoas.inserir(elementoPessoa);
        
        System.out.println("Listando Pessoas:");
            for (int i = 0; i < listaPessoas.getQuantidade(); i++) {
                if (listaPessoas != null) {
                    
                    Pessoa item = listaPessoas.getElemento(i);
                    
                    System.out.println("Nome: " + item.getNome() + ", Idade: " + item.getIdade());
                }
            }
            System.out.println();
            System.out.println();
        
         // Teste lista Ordenada
         Integer[] inteirosOrdenados = {2,4,6,7,8,12,16,18};
        
        Lista<Integer> testeListaOrdenada = new Lista<>(inteirosOrdenados);
        
        System.out.print("Antes da inserção: ");
        for (int i = 0; i < testeListaOrdenada.getQuantidade(); i++) {
            
            System.out.print(testeListaOrdenada.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        testeListaOrdenada.inserirOrdenado(1);
        
         System.out.print("Depois da inserção: ");
        for (int i = 0; i < testeListaOrdenada.getQuantidade(); i++) {
            
            System.out.print(testeListaOrdenada.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        
        
        testeListaOrdenada.inserirOrdenado(19);
        System.out.print("Depois da inserção: ");
        for (int i = 0; i < testeListaOrdenada.getQuantidade(); i++) {
            
            System.out.print(testeListaOrdenada.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        testeListaOrdenada.inserirOrdenado(11);
        System.out.print("Depois da inserção: ");
        for (int i = 0; i < testeListaOrdenada.getQuantidade(); i++) {
            
            System.out.print(testeListaOrdenada.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
        testeListaOrdenada.inserirOrdenado(9);
        System.out.print("Depois da inserção: ");
        for (int i = 0; i < testeListaOrdenada.getQuantidade(); i++) {            
            System.out.print(testeListaOrdenada.getElemento(i) + " ");            
        }
        System.out.println();
        System.out.println();
        testeListaOrdenada.removeElemento(7);
        System.out.print("Depois da remoção: ");
        for (int i = 0; i < testeListaOrdenada.getQuantidade(); i++) {            
            System.out.print(testeListaOrdenada.getElemento(i) + " ");            
        }
        System.out.println();
        System.out.println();
        
        testeListaOrdenada.buscaBinaria(6);
        System.out.print("Depois da inserção: ");
        for (int i = 0; i < testeListaOrdenada.getQuantidade(); i++) {            
            System.out.print(testeListaOrdenada.getElemento(i) + " ");
            
        }
        System.out.println();
        System.out.println();
            
        
        //Fim
       
        //---***********************---//
        Animal[] animais = {
            new Animal("Gato", 3),
            new Animal("Cachorro", 5),
            new Animal("Pássaro", 2)
        };
        
        
        
   //Exemplo de que a classe Animal não é comparável 
   //Descomente o código para ver que a classe Animal não é comparável 
   //Lista<Animal> listaAnimais = new Lista<>();
   //Lista<Animal> animalRemover = new Remover<>(animais); 
        //---***********************---//
    }
}

class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        // Comparação simples com base no nome da pessoa
        return this.nome.compareTo(outraPessoa.getNome());
    }

}

class Animal {

    private String nome;
    private int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
