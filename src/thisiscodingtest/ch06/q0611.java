package thisiscodingtest.ch06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q0611 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }

    private static class Student implements Comparable<Student> {

        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Student other) {
            if (this.score < other.score) {
                return -1;
            }
            return 1;
        }
    }
}
