

package models;

import java.time.LocalDate;

public class Pessoa {
    public String nome;
    public LocalDate dataNascimento;


    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return this.getNome();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public LocalDate setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this.getDataNascimento();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" +  +
                '}';
    }

}
