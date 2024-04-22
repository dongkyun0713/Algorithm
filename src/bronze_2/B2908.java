package bronze_2;

import java.io.IOException;

public class B2908 {

    public static void main(String[] args) throws IOException {
        int A = 0;
        int B = 0;

        A += System.in.read() - 48;
        A += (System.in.read() - 48)*10;
        A += (System.in.read() - 48)*100;

        System.in.read();	// 공백

        B += System.in.read() - 48;
        B += (System.in.read() - 48)*10;
        B += (System.in.read() - 48)*100;

        System.out.println(Math.max(A, B));
    }
}