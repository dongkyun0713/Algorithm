package programmers.level_1;

import java.util.Arrays;

public class P42748 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i =0; i < commands.length; i++){
            int n = commands[i][1] - commands[i][0] + 1;
            int a = commands[i][0] -1;
            int arr[] = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = array[a];
                a++;
            }
            Arrays.sort(arr);
            int k = commands[i][2];

            answer[i] = arr[k-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int array[] = {1, 5, 2, 6, 3, 7, 4};
        int arr[][] = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, arr)));
    }
}
