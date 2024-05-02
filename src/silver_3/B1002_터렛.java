package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1002_터렛 {
    static int T;
    static int x1, y1, r1, x2, y2, r2;
    static int R;
    static int rs, rd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(tokenizer.nextToken());
            y1 = Integer.parseInt(tokenizer.nextToken());
            r1 = Integer.parseInt(tokenizer.nextToken());
            x2 = Integer.parseInt(tokenizer.nextToken());
            y2 = Integer.parseInt(tokenizer.nextToken());
            r2 = Integer.parseInt(tokenizer.nextToken());

            R = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

            rs = (r1 + r2) * (r1 + r2);
            rd = (r1 - r2) * (r1 - r2);

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1);
            } else if (R > rs) {
                sb.append(0);
            } else if (R == rs) {
                sb.append(1);
            } else if (rd < R) {
                sb.append(2);
            } else if (R == rd) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
