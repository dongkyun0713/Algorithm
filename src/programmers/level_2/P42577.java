package level_2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P42577 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        Collections.addAll(set, phone_book);

        for (int i = 0; i< phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (set.contains(phone_book[i].substring(0, j))) return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"12","123","1235","567","88"};
        System.out.println(solution(arr));
    }
}
