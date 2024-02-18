package org.example.module11;
import java.util.List;

public class Names {
    public static String oddIndexedNames(List<String> names) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i % 2 == 0) {
                result.append((i + 1) + ". " + names.get(i));
                result.append(", ");
            }
        }

        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Peter", "Mary", "John", "Alice");
        String result = oddIndexedNames(names);
        System.out.println(result);
    }
}

