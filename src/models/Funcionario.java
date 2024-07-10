package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Funcionario extends Pessoa{

    private BigDecimal salario;
    private String funcao;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Funcionario setSalario(BigDecimal salario) {
        this.salario = salario;
        return this;
    }

    public String getFuncao() {
        return funcao;
    }

    public Funcionario setFuncao(String funcao) {
        this.funcao = funcao;
        return this;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;

        return Objects.equals(getSalario(), that.getSalario()) && Objects.equals(getFuncao(), that.getFuncao());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getSalario());
        result = 31 * result + Objects.hashCode(getFuncao());
        return result;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome
                + ", data de nascimento: " + formatter.format(dataNascimento)
                + ", salário: " + salario +
                ", função: " + funcao;
    }
}
