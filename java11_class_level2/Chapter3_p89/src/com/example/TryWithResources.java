package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResources {

    public static void main(String[] args) {
        Path p1 = Paths.get("data.txt");
        Path p2 = Paths.get("output.txt");
        try ( BufferedReader reader = Files.newBufferedReader(p1);  
              BufferedWriter writer = Files.newBufferedWriter(p2)) {
            String line;
            while((line = reader.readLine())!=null){
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
