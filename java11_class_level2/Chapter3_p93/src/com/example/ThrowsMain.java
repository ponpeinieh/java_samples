package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ThrowsMain {

    public static void main(String[] args) {
        try {
            int data = readByteFromFile();
            System.out.println("data=" + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readByteFromFile() throws IOException {
        try ( InputStream in = new FileInputStream("notexistdata.txt")) {
            System.out.println("File opened!");
            return in.read();
        }
    }
}
