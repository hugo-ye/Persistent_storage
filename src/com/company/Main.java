package com.company;

import java.util.*;
import java.io.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        homework3();

    }

    public static ArrayList<Integer> list() {
        ArrayList<Integer> templist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            templist.add(i);
        }
        return templist;
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


    public static void homework3() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        String database = "jdbc:ucanaccess://data/Homework2.accdb";
        try (Connection connection = DriverManager.getConnection(database)) {
            String sql = "SELECT movie.title, movie.yearOP, director.firstname, director.lastname FROM movie JOIN director ON movie.director=Director.id";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String title = result.getString("title");
                int yearOP = result.getInt("yearOP");
                String directorFN = result.getString("director.firstname");
                String directorLN = result.getString("director.lastname");

                movies.add(new Movie(title, yearOP, String.format("%s %s", directorFN, directorLN)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
    }
}