package org.example.homework3;

import java.io.*;
import com.google.gson.Gson;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

 class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("user.json"));

            String line;

            reader.readLine();
            Gson gson = new Gson();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);

                User user = new User(name, age);
                String jsonUser = gson.toJson(user);
                writer.write(jsonUser + "\n");
            }

            reader.close();
            writer.close();
            System.out.println("Файл user.json успішно створено!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

