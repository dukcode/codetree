package org.dukcode.ps.codetree.trail02.chapter03.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-line-up-students-2/description">LINK</a>
 */
public class TestLineUpStudents2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Student[] students = new Student[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int height = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      students[i] = new Student(height, weight, i + 1);
    }

    Arrays.sort(students, Comparator.comparingInt(Student::getHeight)
        .thenComparing(Student::getWeight, Comparator.reverseOrder()));

    for (Student student : students) {
      bw.write(student.toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static class Student {

    int height;
    int weight;
    int idx;

    public Student(int height, int weight, int idx) {
      this.height = height;
      this.weight = weight;
      this.idx = idx;
    }

    @Override
    public String toString() {
      return height + " " + weight + " " + idx;
    }

    public int getHeight() {
      return height;
    }

    public int getWeight() {
      return weight;
    }
  }
}
