package org.example.homework4;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names {
    public static String oddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(names::get)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Peter", "Mary", "John", "Alice");
        String result = oddIndexedNames(names);
        System.out.println(result);
    }
}



