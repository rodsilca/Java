package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Post post = new Post(LocalDateTime.parse("20/04/2025 14:30:32",fmt),"MEU PAU E PIQUIENO","ssdkljfskdjfsdkfjsdkfjsdkfjdskfjsdkfjsdkfjsdkfjsdkfjsdkfjsdkfjsdkfjsdikf",1);

        post.addComment(new Comment("EU NAO LIGO"));
        post.addComment(new Comment("VAI TOMAR NO CU PORRA"));

        System.out.printf(post.toString());
        System.out.println("--------------------------------------------");


    }
}
