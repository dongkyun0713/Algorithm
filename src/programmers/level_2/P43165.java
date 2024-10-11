package level_2;

public class P43165 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) answer++;
        }
        else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        P43165 instance = new P43165();
        System.out.println(instance.solution(numbers, 3));
    }
}
