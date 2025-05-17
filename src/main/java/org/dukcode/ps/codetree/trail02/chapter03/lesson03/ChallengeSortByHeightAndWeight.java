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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sort-by-height-and-weight/description">LINK</a>
 */
public class ChallengeSortByHeightAndWeight {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Person[] people = new Person[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int height = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      people[i] = new Person(name, height, weight);
    }

    Arrays.sort(people, (p1, p2) -> p1.height == p2.height ?
        Integer.compare(p2.weight, p1.weight) :
        Integer.compare(p1.height, p2.height));

    for (Person person : people) {
      bw.write(person.toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static class Person {

    final String name;
    final int height;
    final int weight;

    public Person(String name, int height, int weight) {
      this.name = name;
      this.height = height;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return String.format("%s %d %d", name, height, weight);
    }
  }
}
