
package com.home.pilha;

interface MetodosPilha<T> {   
    void criar(int tamanho);
    boolean estaVazia();    
    boolean estaCheia();    
    int exibirQuantidade();
    T exibirTopo();
    boolean empilha(T elemento);
    T[] alocaMaisUm();
    int buscar(T elemento);   
    T desempilha();     
    void imprimir();
}

class Pilha<T extends Comparable<T>> implements MetodosPilha<T> {

    private T[] vetor;
    //private int quantidade;
    private int topo;

    public Pilha() {
        this.topo =  -1;
    }

    public Pilha(T[] vetor) {
        this.topo = -1;
        this.vetor = vetor;
        this.topo = vetor.length - 1;
    }
    
    public T[] getVetor() {
        return vetor;
    }

    public int getTopo() {
        return topo;
    }
            
    public T getElemento(int indice) {
        return vetor[indice];
    }

     @Override
    public boolean estaVazia() {
    
        if (this.topo == -1){
            System.out.println("Pilha vazia");
            return true;    
        }
        return false;
    }

    @Override
    public boolean estaCheia() {
    
        if(this.topo == (this.vetor.length - 1)){ // O topo começa de zero
            System.out.println("Pilha cheia");
            return true;
        }
        return false;    
    }
    
    @Override
    public int exibirQuantidade() {
    return (this.getTopo() + 1);
    
    }
    
    @Override
     public T exibirTopo(){
         if (this.estaVazia()){             
             return null;
         }
         return this.getElemento(topo);
     }
     
         @Override
    public void criar(int tamanho) {

        @SuppressWarnings("unchecked")
        T[] novoVetor;
        novoVetor = (T[]) new Comparable[tamanho];
        this.vetor = novoVetor;
        this.topo = -1;
        System.out.println("Criando Pilha Vazia.");

    }
    
        @Override
    public T[] alocaMaisUm() {
        T[] novoVetor;
        novoVetor = (T[]) new Comparable[this.vetor.length + 1];
        
        for (int i = 0; i < (this.exibirQuantidade()); i++) {
          novoVetor[i] = this.vetor[i];  
        } 
        
       // this.vetor = novoVetor;
              System.out.println("Alocando mais um espaço");       
        return novoVetor;
    }
     
    @Override
    public boolean empilha(T elemento) {
        
        //Elemento já existe
        //Para admitir duplicadas comente o codigo abaixo
        if (this.buscar(elemento) != -1) { 
            System.out.println("Não empilhou");
            return false;
        }
        
        
        // Aloca espaço se necessário
        if (this.vetor == null){
            this.criar(1);            
            
        }
        //Lista está cheia
        if (this.estaCheia()) {
           
            // Opção 1 -  Criar um outro vetor com um tamanho a mais
         this.vetor = this.alocaMaisUm();    
                        
            /*
            // Opção 2 -  Pilha está cheia - não empilha  
            System.out.println("Não empilhou");
            return false;
            */            
        }

        

        this.vetor[this.getTopo() + 1] = elemento;
        this.topo++;
        System.out.println("Elemento empilhado");
        return true;
        
    }
    
    @Override
    public T desempilha() {

        //Lista está vazia
        if (this.estaVazia()) {
            System.out.println("Nao desempilhou");
            return null;
        }        
        T elemento = this.getElemento(this.topo);        
        this.topo--;  
        System.out.println("Desempilhou: " + elemento.toString());
        return elemento;
    }
    
    @Override
    public int buscar(T elemento) {
        for (int i = 0; i < this.exibirQuantidade(); i++) {
            if (vetor[i] != null && vetor[i].compareTo(elemento) == 0) {
                System.out.println("Elemento existe");
                return i;
            }
        }
        System.out.println("Elemento não existe");
        return -1;
    }

    @Override
    public void imprimir() {
     
        if(this.estaVazia()){           
            return;
        }
         System.out.print("->");
    for (int i = this.topo; i >= 0; i--) {
            
        System.out.print(this.getElemento(i).toString());
        System.out.println();
        System.out.print("  ");
            
        }
        
    }
     
    

}

public class Main {

    public static void main(String[] args) {
       
        System.out.println("Início do Teste 1");
        System.out.println("---------------------");
        
        Integer[] inteiros = {4, 6, 9, 2, 1};
        
        Pilha<Integer> testePilha = new Pilha<>(inteiros);
        
        testePilha.imprimir();
        
        System.out.println();
        
        Integer removido = testePilha.desempilha();
        
        testePilha.imprimir();
        
        System.out.println();
        
        testePilha.empilha(20);
        
        testePilha.imprimir();
        
        System.out.println();
        System.out.println("---------------------");
        System.out.println();
        System.out.println("Início do Teste 2");
        System.out.println("---------------------");
        
       
        
        Pilha<Integer> testePilha2 = new Pilha<>();
        
        testePilha2.imprimir();         
        testePilha2.empilha(8);
        testePilha2.imprimir();
        testePilha2.empilha(25);
        testePilha2.imprimir();
        
        System.out.println();
        System.out.println("---------------------");        
        System.out.println("Início do Teste 3");
        System.out.println("---------------------");
        
        
        // Criando um vetor de pessoas
        Pessoa[] pessoas = new Pessoa[5];

        // Inicializando as pessoas com valores
        pessoas[0] = new Pessoa("Jose", 30);
        pessoas[1] = new Pessoa("Renato", 25);
        pessoas[2] = new Pessoa("Carlos", 40);
        pessoas[3] = new Pessoa("Davi", 35);
        pessoas[4] = new Pessoa("Felipe", 20);
        
        
        
        Pilha<Pessoa> testePilha3 = new Pilha<>();
        
        
        testePilha3.empilha(pessoas[0]);
        testePilha3.imprimir();
        testePilha3.empilha(pessoas[1]);
        testePilha3.imprimir();
        testePilha3.empilha(pessoas[2]);
        testePilha3.imprimir();
        testePilha3.empilha(pessoas[3]);
        testePilha3.imprimir();
        testePilha3.empilha(pessoas[0]);
        testePilha3.imprimir();
        testePilha3.desempilha();
        testePilha3.imprimir();
       //Exemplo de que a classe Animal não é comparável        
        Animal[] animais = {
            new Animal("Gato", 3),
            new Animal("Cachorro", 5),
            new Animal("Pássaro", 2)
        };      
        
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

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + '}';
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
