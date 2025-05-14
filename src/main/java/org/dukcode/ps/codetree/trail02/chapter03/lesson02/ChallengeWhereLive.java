package org.dukcode.ps.codetree.trail02.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-where-live/description">LINK</a>
 */
public class ChallengeWhereLive {

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
      String address = st.nextToken();
      String city = st.nextToken();
      people[i] = new Person(name, address, city);
    }

    Arrays.sort(people);

    bw.write(people[n - 1].toString());

    br.close();
    bw.close();

  }

  private static class Person implements Comparable<Person> {

    private String name;
    private String addr;
    private String city;

    public Person(String name, String addr, String city) {
      this.name = name;
      this.addr = addr;
      this.city = city;
    }

    @Override
    public String toString() {
      return "name " + name + "\n"
          + "addr " + addr + "\n"
          + "city " + city + "\n";
    }

    @Override
    public int compareTo(Person o) {
      return this.name.compareTo(o.name);
    }
  }
}
