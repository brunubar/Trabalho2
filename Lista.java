/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home.exercicio2;

/**
 *
 * 
 */
interface MetodosLista<T> {
    //Inserir outros métodos aqui

    void removeElemento(T elemento);
}

class Lista<T extends Comparable<T>> implements MetodosLista<T> {

    private T[] vetor;

    public Lista(T[] vetor) {
        this.vetor = vetor;
    }
    
    //Implementar outros métodos

    @Override
    public void removeElemento(T elemento) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null && vetor[i].compareTo(elemento) == 0) {
                vetor[i] = null;
                return;
            }
        }
    }
}




public class Main {

    public static void main(String[] args) {
        Integer[] intVetor = {1, 2, 3, 4, 5};
        String[] strVetor = {"maçã", "banana", "laranja"};

        Lista<Integer> intRemover = new Lista<>(intVetor);
        intRemover.removeElemento(3);

        Lista<String> strRemover = new Lista<>(strVetor);
        strRemover.removeElemento("banana");

        System.out.println("Integer após remoção:");
        for (Integer num : intVetor) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("String após remoção:");
        for (String str : strVetor) {
            System.out.print(str + " ");
        }
        System.out.println();

        Pessoa[] pessoas = {
            new Pessoa("Pedro", 25),
            new Pessoa("João", 30),
            new Pessoa("Ricardo", 20)
        };

        Lista<Pessoa> pessoaRemover = new Lista<>(pessoas);
        pessoaRemover.removeElemento(new Pessoa("Ricardo", 30)); // Removendo a pessoa "Bob"

        System.out.println("Pessoas após a remoção:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                System.out.println("Nome: " + pessoa.getNome() + ", Idade: " + pessoa.getIdade());
            }
        }

   //---***********************---//
        Animal[] animais = {
            new Animal("Gato", 3),
            new Animal("Cachorro", 5),
            new Animal("Pássaro", 2)
        };
//Exemplo de que a classe Animal não é comparável 
// Descomente o código para ver que a classe Animal não é comparável 

//        Remover<Animal> animalRemover = new Remover<>(animais); 
      
       
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
