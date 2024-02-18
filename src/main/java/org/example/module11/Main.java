package org.example.module11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<String> sortAndUppercase(List<String> strings) {
        strings.replaceAll(String::toUpperCase);


        Collections.sort(strings, Collections.reverseOrder());
        return strings;
    }

    public static void main(String[] args) {
        List<String> inputStrings = new ArrayList<>(List.of("Ivan", "Peter", "Mary", "John", "Alice"));
        List<String> result = sortAndUppercase(inputStrings);
        System.out.println(result);
    }
}




