package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> productList = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int op = sc.nextInt();
        for (int i = 0; i < op; i++) {
            System.out.println("Product "+(i+1)+" data");
            System.out.print("Common, imported or used? (c/i/u)? ");
            char isOutsourced = sc.next().toLowerCase().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (isOutsourced == 'i'){
                System.out.print("Customs Fee: ");
                Double customsFee = sc.nextDouble();

                Product prod = new ImportedProduct(name,price,customsFee);
                productList.add(prod);

            }else if(isOutsourced =='u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(),fmt);

                Product prod = new UsedProduct(name,price,date);
                productList.add(prod);
            }else{
                Product prod = new Product(name,price);
                productList.add(prod);
            }
        }
        System.out.println(" ");
        System.out.println("PRICE TAGS: ");
        for (Product product : productList){
            System.out.println(product.priceTag());
        }
    }
}
