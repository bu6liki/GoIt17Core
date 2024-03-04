package org.example.homework6;

public class Tasks {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) {
        Tasks client = new Tasks();

        client.printOpenTasksForUser(1);
    }

    public void printOpenTasksForUser(int userId) {
        String tasks = sendRequest("/users/" + userId + "/todos", "GET", null);
        JSONArray tasksArray = new JSONArray(tasks);

        System.out.println("Open tasks for user " + userId + ":");
        for (int i = 0; i < tasksArray.length(); i++) {
            JSONObject task = tasksArray.getJSONObject(i);
            if (!task.getBoolean("completed")) {
                System.out.println("Task ID: " + task.getInt("id"));
                System.out.println("Title: " + task.getString("title"));
                System.out.println("Completed: " + task.getBoolean("completed"));
                System.out.println();
            }
        }
    }

    private String sendRequest(String endpoint, String method, String body) {
        return endpoint;
    }
}

