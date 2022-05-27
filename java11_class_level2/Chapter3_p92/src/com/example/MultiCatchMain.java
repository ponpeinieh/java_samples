package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MultiCatchMain {

    public static void main(String[] args) {
        System.out.println("About to open a file");
        try ( //InputStream in = new FileInputStream("data.txt");  
                InputStream in = new FileInputStream("notexistdata.txt");  
                Scanner s = new Scanner(in);) {
            System.out.println("File opened!");
            int data = s.nextInt(); //read an integer
            System.out.println("data="+data);
        } catch (NoSuchElementException | IOException e) {
            System.out.println(e.getClass().getName());
            e.printStackTrace();
        }
    }
}
