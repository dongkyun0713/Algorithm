package bronze_3;

import java.io.*;

public class B11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while(true){
            String str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }
            builder.append(str).append("\n");
        }
        br.close();
        System.out.println(builder);
    }

}