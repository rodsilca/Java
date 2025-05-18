package exercicioSalarioAumento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Funcionarios>  listaFuncionarios = new ArrayList<>();
        System.out.println("How many employees to register? ");
        int qtd = sc.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.println("Employee #"+(i+1));
            System.out.println("Id: ");
            Integer idFuncionario = sc.nextInt();
            while (hasId(listaFuncionarios,idFuncionario)){
                System.out.println("Id is already taken! Try again:");
                System.out.println("Id: ");
                idFuncionario = sc.nextInt();
            }

            System.out.println("Name: ");
            String nomeFuncionario = sc.next();
            System.out.println("Salary");
            Double salaryFuncionario = sc.nextDouble();
            Funcionarios funcionario = new Funcionarios(idFuncionario,nomeFuncionario,salaryFuncionario);

            listaFuncionarios.add(funcionario);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        Integer id = sc.nextInt();
        Integer pos= position(listaFuncionarios, id);

        //Essa linha faz a mesma coisa que a variavel aqui em cima e a funcao static la embaixo
        Funcionarios funcionarios = listaFuncionarios.stream().filter(x-> x.getId() == id).findFirst().orElse(null);

        if (funcionarios == null){
            System.out.println("This is id does not exist");
        }else {
            System.out.println("Enter the percentage of employee #"+listaFuncionarios.get(pos).getId());
            Double pct = sc.nextDouble();
            funcionarios.salaryIncrease(pct);
        }

//        for (Funcionarios funcionarios:listaFuncionarios){
//            if (funcionarios.getId() == id){
//                System.out.println("Enter the percentage of employee #"+funcionarios.getId());
//                Double pct = sc.nextDouble();
//                funcionarios.salaryIncrease(pct);
//            }
//        }

        System.out.println("List of Employees");
        for(Funcionarios funcionario:listaFuncionarios){
            System.out.printf("Id %d\n",funcionario.getId());
            System.out.printf("Nome: \n" + funcionario.getNome());
            System.out.printf("Salary: %.2f\n", funcionario.getSalario());
        }

    }

    public static Integer position(List<Funcionarios> lista, int id){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                return id;
            }
        }
        return null;
    }

    //pra saber se o id ja foi usado ou nao
    public static boolean hasId(List<Funcionarios> list, int id){
        Funcionarios funcionarios = list.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
        return funcionarios !=null;
    }
}
