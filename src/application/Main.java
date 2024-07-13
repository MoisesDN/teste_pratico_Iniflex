package application;

import models.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        //Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        List<Funcionario> funcionarios = new ArrayList<>();
        String path = "src/resources/in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");

                funcionarios.add(new Funcionario(fields[0], LocalDate.parse(fields[1]), BigDecimal.valueOf(Double.parseDouble(fields[2])), fields[3]));
                line = br.readLine();
            }
            funcionarios.forEach(System.out::println);

            //Remover o funcionário “João” da lista.
            funcionarios.remove(1);
            System.out.println();

            //Imprimir todos os funcionários com todas suas informações.
            funcionarios.forEach(System.out::println);
            System.out.println();

            // Aumento de 10% nos salários dos funcionários
            funcionarios.forEach(p -> p.setSalario(p.getSalario().multiply(new BigDecimal("1.1"))));
            funcionarios.forEach(System.out::println);
            System.out.println();

            //Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
            Map<Boolean, List<Funcionario>> listaDeFuncionarios = funcionarios.stream()
                    .collect(Collectors.partitioningBy(a -> Funcionario.containsUpperCase(String.valueOf(a))));

            List<Funcionario> finalOutput = listaDeFuncionarios.get(Boolean.TRUE)
                    .stream()
                    .sorted(Comparator.comparing(Funcionario::getFuncao))
                    .collect(Collectors.toList());

            finalOutput.addAll(listaDeFuncionarios.get(Boolean.FALSE)
                    .stream()
                    .sorted() // sorted naturally
                    .collect(Collectors.toList()));
            //Imprimir os funcionários, agrupados por função.
            finalOutput.forEach(System.out::println);

            System.out.println();
            //Imprimir a lista de funcionários por ordem alfabética.
            funcionarios.stream()
                    .sorted(Comparator.comparing(Funcionario::getNome))
                    .forEach(System.out::println);
            System.out.println();

            //Imprimir os funcionários que fazem aniversário no mês 10 e 12.
            funcionarios.stream()
                    .filter(d -> (d.dataNascimento.getMonth() == Month.OCTOBER) || (d.dataNascimento.getMonth() == Month.DECEMBER))
                    .forEach(System.out::println);
            System.out.println();

            //Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
            LocalDate maiorIdade = funcionarios.get(0).getDataNascimento();
            String nome = "";
            int idade = 0;

            for (int i=0; i< funcionarios.size(); i++) {
                if (funcionarios.get(i).getDataNascimento().getYear() < maiorIdade.getYear()) {
                    maiorIdade = funcionarios.get(i).getDataNascimento();
                    nome = funcionarios.get(i).getNome();

                    idade = Period.between(maiorIdade, LocalDate.now()).getYears();
                }
            }
            System.out.println(nome +", "+ idade + " anos");
            System.out.println();

            //Imprimir o total dos salários dos funcionários.
            double totalSalario = funcionarios.stream()
                    .mapToDouble(salario -> salario.getSalario().doubleValue()).sum();
            System.out.println("Total dos salários dos funcionários: " + numberFormat.format(totalSalario));
            System.out.println();

            //Imprimir quantos salários mínimos ganha cada funcionário.
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario.getNome() + ", salários mínimos " + String.format("%.2f", funcionario.salarioMinino(funcionario.getSalario().doubleValue())));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}