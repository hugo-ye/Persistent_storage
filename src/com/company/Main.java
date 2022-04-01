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
        homework1a(list);

    }

    public static void homework1a(List<Integer> list) {

        String fname = "data/textFile.txt";
        File file = new File(fname);
        if (!file.exists()) {
            try (PrintWriter out = new PrintWriter(fname)) {
                for (Integer integer : list) {
                    out.printf("%d ", integer);
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
        if (!file.exists()) {
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
     /*
    CREATE TABLE movie (
            id int PRIMARY KEY,
            name nvarchar(100) NOT NULL,
    yearOP int NOT NULL,
    director nvarchar(100) NOT NULL REFERENCES director(id)
            );

    CREATE TABLE director (
            id int PRIMARY KEY,
            firstname nvarchar(100) NOT NULL,
    lastname nvarchar(100) NOT NULL
);

    INSERT INTO movie (id, name, yearOP, director) VALUES
  (1, 'Jurrassic park', 1993, 1),
          (2, 'Interstellar', 2014, 2),
          (3, 'Inglorious Bastards', 2009, 3);


    INSERT INTO director (id, firstname, lastname) VALUES
  (1, "Steven", "Spielberg"),
          (2, "Christopher", "Nolan"),
          (3, "Quentin", "Tarantino");
*/

    public static void homework3() {
    }
}