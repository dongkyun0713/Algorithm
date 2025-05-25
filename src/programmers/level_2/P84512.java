package programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class P84512 {
    private static final List<String> dictionary = new ArrayList<>();
    private static final String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("", 0);
        return dictionary.indexOf(word) + 1;
    }

    private void dfs(String current, int depth) {
        if (depth > 5) {
            return;
        }
        if (!current.isEmpty()) {
            dictionary.add(current);
        }

        for (String vowel : vowels) {
            dfs(current + vowel, depth + 1);
        }
    }
}
