package application;

import models.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionario = new ArrayList<>();

        funcionario.add(new Funcionario("Maria", LocalDate.parse("2000-10-18"), BigDecimal.valueOf(2009.44),"Operador"));
        funcionario.add(new Funcionario("João", LocalDate.parse("1990-05-12"), BigDecimal.valueOf(2284.38),"Operador"));
        funcionario.add(new Funcionario("Caio", LocalDate.parse("1961-05-02"), BigDecimal.valueOf(9836.14),"Coordenador"));
        funcionario.add(new Funcionario("Miguel", LocalDate.parse("1988-10-14"), BigDecimal.valueOf(19119.88),"Diretor"));
        funcionario.add(new Funcionario("Alice", LocalDate.parse("1995-01-05"), BigDecimal.valueOf(2234.68),"Recepcionista"));
        funcionario.add(new Funcionario("Heitor", LocalDate.parse("1999-11-19"), BigDecimal.valueOf(1582.72),"Operador"));
        funcionario.add(new Funcionario("Arthur", LocalDate.parse("1993-03-31"), BigDecimal.valueOf(4071.84),"Contador"));
        funcionario.add(new Funcionario("Laura", LocalDate.parse("1994-07-08"), BigDecimal.valueOf(3017.45),"Gerente"));
        funcionario.add(new Funcionario("Heloísa", LocalDate.parse("2003-05-24"), BigDecimal.valueOf(1606.85),"Eletricista"));
        funcionario.add(new Funcionario("Helena", LocalDate.parse("1996-09-02"), BigDecimal.valueOf(2799.93),"Gerente"));

        funcionario.forEach(System.out::println);

        funcionario.remove(1);

        System.out.println("--- Após remover o Funcionário João da lista ---");

        funcionario.forEach(System.out::println);
    }
}