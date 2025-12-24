package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Truck> waiting = new ArrayDeque<>();
        List<Truck> bridge = new ArrayList<>();
        List<Truck> arrived = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Truck truck = new Truck(Integer.parseInt(st.nextToken()));
            waiting.add(truck);
        }

        int remainWeight = l;
        int minTime = 0;

        while (arrived.size() < n) {
            for (Truck truck : bridge) {
                truck.move();
            }

            if (!bridge.isEmpty() && bridge.get(0).currentPosition == w) {
                Truck outTruck = bridge.remove(0);
                arrived.add(outTruck);
                remainWeight += outTruck.weight;
            }

            if (!waiting.isEmpty()) {
                Truck nextTruck = waiting.peek();
                if (bridge.size() < w && remainWeight >= nextTruck.weight) {
                    waiting.remove();
                    bridge.add(nextTruck);
                    remainWeight -= nextTruck.weight;
                }
            }
            ++minTime;
        }
        System.out.println(minTime);
    }

    private static class Truck {
        int weight;
        int currentPosition;

        public Truck(int weight) {
            this.weight = weight;
            this.currentPosition = 0;
        }

        void move() {
            ++currentPosition;
        }
    }
}
