package org.example.homework4;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        String[] arr = {"1, 2, 0", "4, 5"};
        String result = sortAndJoinNumbers(arr);
        System.out.println(result);
    }

    public static String sortAndJoinNumbers(String[] arr) {
        return Arrays.stream(arr)
                .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}

