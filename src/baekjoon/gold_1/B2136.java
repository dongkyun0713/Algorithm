package baekjoon.gold_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2136 {
    private static class Ant {
        int index;
        int direction;
        int startPosition;
        int time;

        public Ant(int index, int direction, int startPosition, int time) {
            this.index = index;
            this.direction = direction;
            this.startPosition = startPosition;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 개미 수, L: 막대 길이
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        List<Ant> ants = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int raw = Integer.parseInt(br.readLine());
            int index = i + 1;
            int direction = raw < 0 ? -1 : 1;
            int position = Math.abs(raw);
            int time = direction < 0 ? position : L - position;
            ants.add(new Ant(index, direction, position, time));
        }

        List<Ant> copyAnts = new ArrayList<>(ants);

        copyAnts.sort((a, b) -> {
            if (a.direction != b.direction) {
                return a.direction - b.direction;
            }
            if (a.direction == -1) {
                return a.time - b.time;
            } else {
                return b.time - a.time;
            }
        });

        int maxIndex = 0;
        int maxTime = 0;

        for (int i = 0; i < N; i++) {
            int antTime = copyAnts.get(i).time;
            if (maxTime < antTime ) {
                maxTime = antTime;
                maxIndex = i;
            }
        }
        ants.sort((a, b) -> a.startPosition - b.startPosition);
        System.out.println(ants.get(maxIndex).index + " " + maxTime);

    }
}
