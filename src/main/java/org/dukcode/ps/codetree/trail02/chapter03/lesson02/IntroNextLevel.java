package org.dukcode.ps.codetree.trail02.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-next-level/description">LINK</a>
 */
public class IntroNextLevel {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Character c1 = new Character("codetree", 10);
    st = new StringTokenizer(br.readLine());
    Character c2 = new Character(st.nextToken(), Integer.parseInt(st.nextToken()));

    bw.write(c1.toString());
    bw.newLine();
    bw.write(c2.toString());

    br.close();
    bw.close();

  }

  private static class Character {

    private String id;
    private int level;

    public Character(String id, int level) {
      this.id = id;
      this.level = level;
    }

    @Override
    public String toString() {
      return "user " + id + " lv " + level;
    }
  }
}
