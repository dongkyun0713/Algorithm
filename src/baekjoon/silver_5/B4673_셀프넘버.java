package baekjoon.silver_5;

public class B4673_셀프넘버 {
    public static void main(String[] args) {
        boolean check[] = new boolean[100001];

        for(int i =1; i<= 10000; i++){
            int n = d(i);
            if(n <10001) check[d(i)] = true;
        }
        for(int i = 1; i <= 10000; i++){
            if(!check[i]) System.out.println(i);
        }
    }
    public static int d(int n) {
        int sum = n;

        while(n != 0){
            sum += (n%10);
            n /= 10;
        }
        return sum;
    }
}
