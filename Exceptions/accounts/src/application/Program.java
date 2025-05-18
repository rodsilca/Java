package application;

import entities.Account;
import model.exceptions.DomainException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial Balance: ");
        Double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        Double wl = sc.nextDouble();

        Account conta1= new Account(number,holder,balance,wl);

        try{
            System.out.print("Enter the amount for withdraw: ");
            Double nBalance = conta1.withdraw(sc.nextDouble());

            System.out.print("New balance: "+ nBalance);
        }
        catch (DomainException e){
            System.out.println("Error in withdraw: "+ e.getMessage());
        }
    }
}
