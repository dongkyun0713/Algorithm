package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3190 {
    static int[][] board;  // 사과 있으면 1, 뱀이면 2

    //  0=오른쪽, 1=아래, 2=왼쪽, 3=위
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<SnakeDirection> snakeDirections = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            snakeDirections.add(new SnakeDirection(x, c));
        }

        Snake snake = new Snake();
        board[1][1] = 2;   // 시작 위치 표시

        int time = 0;

        while (true) {
            ++time;
            Point head = snake.body.peekFirst();
            int nr = head.r + dr[snake.direction];
            int nc = head.c + dc[snake.direction];

            // 벽/자기몸 충돌
            if (nr < 1 || nr > n || nc < 1 || nc > n || board[nr][nc] == 2) break;

            boolean hasApple = (board[nr][nc] == 1);

            snake.body.addFirst(new Point(nr, nc));
            board[nr][nc] = 2;

            if (!hasApple) {
                Point tail = snake.body.removeLast();
                board[tail.r][tail.c] = 0;
            }

            if (!snakeDirections.isEmpty() && snakeDirections.peek().x == time) {
                SnakeDirection sd = snakeDirections.remove();
                if (sd.c == 'D') snake.direction = (snake.direction + 1) % 4;
                else snake.direction = (snake.direction + 3) % 4;
            }
        }
        System.out.println(time);
    }

    static class Snake {
        ArrayDeque<Point> body;
        int direction;  // 0=오른쪽, 1=아래, 2=왼쪽, 3=위

        Snake() {
            ArrayDeque<Point> body = new ArrayDeque<>();
            body.add(new Point(1, 1));
            this.body = body;
            this.direction = 0;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class SnakeDirection {
        int x;
        char c;

        SnakeDirection(int x, char c) {
            this.x = x;
            this.c = c;
        }
    }
}
