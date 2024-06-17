package programmers.level_1;



public class P131705 {
    public static int solution(int[] number) {
        int answer = 0;
        // [-3, -2, -1, 0, 1, 2, 3]

        for(int i = 0; i < number.length - 1; i++) {
            for(int j =i+1; j < number.length; j++) {
                for(int k = j+1; k < number.length; k++) {
                     if(number[i] + number[j] == -1 * number[k]) {
                         answer++;
                }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println(solution(arr));
    }
}
