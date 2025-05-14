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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sort-by-height/description">LINK</a>
 */
public class IntroSortByHeight {

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

    Arrays.sort(people);

    for (Person person : people) {
      bw.write(person.toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static class Person implements Comparable<Person> {

    private String name;
    private int height;
    private int weight;

    public Person(String name, int height, int weight) {
      this.name = name;
      this.height = height;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return name + " " + height + " " + weight;
    }

    @Override
    public int compareTo(Person o) {
      return this.height - o.height;
    }
  }
}
