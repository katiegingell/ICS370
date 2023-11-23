package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class PasswordUtils {

    public static User authenticate(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("Logins.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        User user = getUserFromFile(username);
                        if (user == null) {
                            user = new User(username,new ArrayList<>());
                            saveUserToFile(user);
                        }
                        return user;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void saveUserToFile(User user) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(user.getUsername()));
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static User getUserFromFile(String username) {
        try {
            ObjectInputStream ois = new ObjectInputStream( new FileInputStream(username));
            User user = (User)ois.readObject();
            ois.close();
            return user;

        } catch (Exception e) {
            return null;
        }

    }
}

