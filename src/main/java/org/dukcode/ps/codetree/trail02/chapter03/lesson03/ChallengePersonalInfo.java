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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-personal-info/description">LINK</a>
 */
public class ChallengePersonalInfo {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = 5;
    Person[] people = new Person[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int height = Integer.parseInt(st.nextToken());
      double weight = Double.parseDouble(st.nextToken());

      people[i] = new Person(name, height, weight);
    }

    Arrays.sort(people, Comparator.comparing(p -> p.name));
    bw.write("name");
    bw.newLine();
    for (Person person : people) {
      bw.write(person.toString());
      bw.newLine();
    }
    bw.newLine();

    Arrays.sort(people, Comparator.comparingInt(p -> -p.height));
    bw.write("height");
    bw.newLine();
    for (Person person : people) {
      bw.write(person.toString());
      bw.newLine();
    }
    bw.newLine();

    br.close();
    bw.close();

  }

  private static class Person {

    private final String name;
    private final int height;
    private final double weight;

    public Person(String name, int height, double weight) {
      this.name = name;
      this.height = height;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return String.format("%s %d %.1f", name, height, weight);
    }
  }
}
