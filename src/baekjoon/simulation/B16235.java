package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class B16235 {
    static int N, M, K;
    static int[][] A; // 겨울에 추가될 양분
    static int[][] food; // 현재 땅의 양분
    static Deque<Tree> trees = new ArrayDeque<>();

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Tree {
        int r, c, age;
        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        food = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                food[i][j] = 5;
            }
        }

        List<Tree> initialTrees = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            initialTrees.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        initialTrees.sort(Comparator.comparingInt(t -> t.age));
        trees.addAll(initialTrees);

        while (K-- > 0) {
            Deque<Tree> aliveTrees = new ArrayDeque<>();
            List<Tree> deadTrees = new ArrayList<>();

            // 봄
            int size = trees.size();
            for (int i = 0; i < size; i++) {
                Tree tree = trees.pollFirst();
                if (food[tree.r][tree.c] >= tree.age) {
                    food[tree.r][tree.c] -= tree.age;
                    tree.age++;
                    aliveTrees.addLast(tree);
                } else {
                    deadTrees.add(tree);
                }
            }

            // 여름
            for (Tree tree : deadTrees) {
                food[tree.r][tree.c] += tree.age / 2;
            }

            // 가을
            Deque<Tree> newTrees = new ArrayDeque<>();
            for (Tree tree : aliveTrees) {
                if (tree.age % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int nr = tree.r + dr[d];
                        int nc = tree.c + dc[d];
                        if (nr >= 1 && nc >= 1 && nr <= N && nc <= N) {
                            newTrees.addFirst(new Tree(nr, nc, 1));
                        }
                    }
                }
            }
            // 새로 태어난 나이 1 나무들을 기존 살아남은 나무들 앞에 배치
            for(Tree nt : newTrees) aliveTrees.addFirst(nt);
            trees = aliveTrees;

            // 겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    food[i][j] += A[i][j];
                }
            }
        }
        System.out.println(trees.size());
    }
}
