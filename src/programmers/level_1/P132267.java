package programmers.level_1;

public class P132267 {
    public static int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int bottle = (n / a) * b;
            n = (n % a) + bottle;
            answer += bottle;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1, 20));
    }
}
