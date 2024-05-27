package Main;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<String> lines = new ArrayList<>();
    public static void main(String[] args) {

//        rewriteFile();
//
//        int opt;
//        do {
//            writeFile();
//            System.out.println("Ingrese 0 para salir");
//            opt = ConsoleReader.readInteger();
//        } while (opt != 0);

        addLinesToArrayList();
        System.out.println("Las líneas de su archivo: ");
        invokeFileReader();
        System.out.println();
        rewriteSorted();
        System.out.println("El archivo ordenado alfabeticamente: ");
        invokeFileReader();


    }

    public static void addLinesToArrayList() {
        try(FileReader fr = new FileReader("pichirila.txt");
            BufferedReader br = new BufferedReader(fr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void invokeFileReader() {
        try(FileReader fr = new FileReader("pichirila.txt");
            BufferedReader br = new BufferedReader(fr);
            ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try (
                FileWriter fw = new FileWriter("pichirila.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
            ) {

            System.out.println("Ingrese una cadena");
            String input = Utilities.ConsoleReader.readString();

            bw.write(input + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rewriteFile() {
        try (
                FileWriter fw = new FileWriter("pichirila.txt");
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rewriteSorted() {
        rewriteFile();
        Collections.sort(lines);

        try (
                FileWriter fw = new FileWriter("pichirila.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            for (String s : lines) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}