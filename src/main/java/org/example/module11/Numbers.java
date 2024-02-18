package org.example.module11;
import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        String[] arr = {"1, 2, 0", "4, 5"};
        String result = sortAndJoinNumbers(arr);
        System.out.println(result);
    }

    public static String sortAndJoinNumbers(String[] arr) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String str : arr) {
            String[] nums = str.split(",\\s*");

            for (String num : nums) {
                int n = Integer.parseInt(num);
                numbers.add(n);
            }
        }
        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}

