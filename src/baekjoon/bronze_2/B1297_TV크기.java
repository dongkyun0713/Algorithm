package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
    public class B1297_TV크기 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            double D = Double.parseDouble(st.nextToken());
            double H = Double.parseDouble(st.nextToken());
            double W = Double.parseDouble(st.nextToken());

            double pow = Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2));
            double sqrt = Math.sqrt(pow);

            System.out.println((int) (sqrt * H) + " " + (int) (sqrt * W));
        }

    }

