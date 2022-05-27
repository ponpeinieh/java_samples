package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TraditionalTryCatch {

    public static void main(String[] args) {
        Path p1 = Paths.get("data.txt");
        Path p2 = Paths.get("output.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = Files.newBufferedReader(p1);
            writer = Files.newBufferedWriter(p2);
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
