package programmers.level_1;

public class P86491 {
    public static int solution(int[][] sizes) {
        int max_v = 0;
        int max_h = 0;

        // [[60, 50], [30, 70], [60, 30], [80, 40]]
        // 가로에 무조건 큰 수
        // [[60, 50], [70, 30], [60, 30], [80, 40]]

        for(int i = 0; i < sizes.length; i++) {
            int v = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            max_v = Math.max(max_v, v);
            max_h = Math.max(max_h, h);
        }
        return max_v * max_h;
    }

    public static void main(String[] args) {
        int arr[][] = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(arr));

    }
}
