package org.example.module11;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<String> sortAndUppercase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> inputStrings = List.of("Ivan", "Peter", "Mary", "John", "Alice");
        List<String> result = sortAndUppercase(inputStrings);
        System.out.println(result);
    }
}




