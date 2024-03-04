package org.example.homework6;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {


            int userId = 1;
            int postId = getLatestPostId(userId);

            JSONArray comments = getPostComments(postId);


            writeCommentsToFile(userId, postId, comments);

            System.out.println("Коментарі до останнього поста користувача " + userId + " записані у файл user-" + userId + "-post-" + postId + "-comments.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int getLatestPostId(int userId) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users/" + userId + "/posts");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        JSONArray posts = new JSONArray(response.toString());
        int latestPostId = -1;
        for (int i = 0; i < posts.length(); i++) {
            JSONObject post = posts.getJSONObject(i);
            int postId = post.getInt("id");
            if (postId > latestPostId) {
                latestPostId = postId;
            }
        }

        return latestPostId;
    }

    private static JSONArray getPostComments(int postId) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/" + postId + "/comments");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return new JSONArray(response.toString());
    }

    private static void writeCommentsToFile(int userId, int postId, JSONArray comments) throws IOException {
        JSONObject data = new JSONObject();
        data.put("userId", userId);
        data.put("postId", postId);
        data.put("comments", comments.length());

        FileWriter file = new FileWriter("user-" + userId + "-post-" + postId + "-comments.json");
        file.write(data.toString());
        file.close();
    }
}

