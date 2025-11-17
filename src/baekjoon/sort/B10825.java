package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class B10825 {
    private static class Student {
        String name;
        int korea, english, math;  // 국영수

        public Student(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korea = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name, korea, english, math);
            students.add(student);
        }
        students.sort((s1, s2) -> {
            if (s1.korea != s2.korea) return s2.korea - s1.korea;
            if (s1.english != s2.english) return s1.english - s2.english;
            if (s1.math != s2.math) return s2.math - s1.math;
            return s1.name.compareTo(s2.name);
        });

        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.name).append("\n");
        }
        System.out.println(sb);
    }
}
