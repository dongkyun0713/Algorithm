package programmers.level_2;

import java.util.Arrays;
import java.util.Collections;

public class P49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String filtered = skillTree.replaceAll("[^" + skill + "]", "");
            if (skill.startsWith(filtered)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a1 = {1,3,4,6};

        a1 = Arrays.stream(a1)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        Integer[] a2 = {1,2,3};
        Arrays.sort(a2, Collections.reverseOrder());

       

    }
}
