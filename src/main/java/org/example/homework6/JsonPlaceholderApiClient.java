package org.example.homework6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonPlaceholderApiClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) {
        JsonPlaceholderApiClient client = new JsonPlaceholderApiClient();


        String createdUser = client.createUser("{\"name\": \"John Doe\", \"username\": \"johndoe\"}");
        System.out.println("Created user: " + createdUser);


        String updatedUser = client.updateUser(1, "{\"name\": \"John Updated\", \"username\": \"johnupdated\"}");
        System.out.println("Updated user: " + updatedUser);

        String allUsers = client.getAllUsers();
        System.out.println("All users: " + allUsers);

        String userById = client.getUserById(1);
        System.out.println("User by id: " + userById);

        String userByUsername = client.getUserByUsername("Bret");
        System.out.println("User by username: " + userByUsername);

        boolean deleted = client.deleteUser(1);
        System.out.println("User deleted: " + deleted);
    }

    public String createUser(String jsonBody) {
        return sendRequest("/users", "POST", jsonBody);
    }

    public String updateUser(int userId, String jsonBody) {
        return sendRequest("/users/" + userId, "PUT", jsonBody);
    }

    public String getAllUsers() {
        return sendRequest("/users", "GET", null);
    }

    public String getUserById(int userId) {
        return sendRequest("/users/" + userId, "GET", null);
    }

    public String getUserByUsername(String username) {
        return sendRequest("/users?username=" + username, "GET", null);
    }

    public boolean deleteUser(int userId) {
        int responseCode = sendDeleteRequest("/users/" + userId);
        return responseCode >= 200 && responseCode < 300;
    }

    private String sendRequest(String endpoint, String method, String body) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            if (body != null) {
                conn.setDoOutput(true);
                OutputStream os = conn.getOutputStream();
                os.write(body.getBytes());
                os.flush();
                os.close();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int sendDeleteRequest(String endpoint) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            return conn.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void printOpenTasksForUser(int i) {
    }
}

