package org.dukcode.ps.codetree.trail02.chapter03.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-line-up-students/description">LINK</a>
 */
public class IntroLineUpStudents {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Student[] students = new Student[n];
    for (int idx = 1; idx <= n; idx++) {
      st = new StringTokenizer(br.readLine());
      int height = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      students[idx - 1] = new Student(idx, height, weight);
    }

    Arrays.sort(students);

    for (Student student : students) {
      bw.write(student.toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static class Student implements Comparable<Student> {

    private final int idx;
    private final int height;
    private final int weight;

    public Student(int idx, int height, int weight) {
      this.idx = idx;
      this.height = height;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return height + " " + weight + " " + idx;
    }

    @Override
    public int compareTo(Student o) {
      if (this.height == o.height) {
        return o.weight - this.weight;
      }
      return o.height - this.height;
    }
  }
}
