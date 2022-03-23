package com.company;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        homework1b(list);

    }

    public static void homework1a(List list) {

        String fname = "data/textFile.txt";
        File file = new File(fname);
        if (file.exists()) {
            try (PrintWriter out = new PrintWriter(new File(fname))) {
                for (int i = 0; i < list.size(); i++) {
                    out.printf("%d ", i);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        try (Scanner in = new Scanner(new File(fname))) {
            List<Integer> another = new ArrayList<>();
            while (in.hasNextInt()) {
                another.add(in.nextInt());

            }
            System.out.println(another);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void homework1b(List list) {
        String fname = "data/serious.ser";
        File file = new File(fname);
        if (file.exists()) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fname))) {
                out.writeObject(list);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname))) {
            List another = (List) in.readObject();
            System.out.println(another);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}