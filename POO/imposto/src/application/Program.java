package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);

            List<Pessoa> pessoas = new ArrayList<>();

            System.out.println("Enter the number of tax payers: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println("Tax payer #"+(i+1)+" data:");
                System.out.print("Individual or company? (i/c):");
                char isOutsourced = sc.next().toLowerCase().charAt(0);
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Annual income: ");
                Double annualIncome = sc.nextDouble();

                if (isOutsourced == 'i'){
                    System.out.print("Health expenditures: ");
                    Double healthExp = sc.nextDouble();

                    Pessoa p = new PessoaFisica(name,annualIncome,healthExp);
                    pessoas.add(p);
                }else {
                    System.out.print("Number of Employees: ");
                    Integer number = sc.nextInt();
                    Pessoa emp = new PessoaJuridica(name,annualIncome,number);
                    pessoas.add(emp);
                }
            }

            System.out.println(" ");

            Double totalTaxes = 0.0;
            System.out.println("TAXES PAID:");
            for (Pessoa pessoa : pessoas){
                System.out.println(pessoa.getNome()+": $"+ String.format("%.2f",pessoa.calculoImposto()));
                totalTaxes += pessoa.calculoImposto();
            }

            System.out.println(" ");

            System.out.println("TOTAL TAXES: ");
            System.out.println(totalTaxes);
        }

}
