package org.dukcode.ps.codetree.trail02.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-bomb-removal/description">LINK</a>
 */
public class ChallengeBombRemoval {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    String code = st.nextToken();
    String color = st.nextToken();
    int second = Integer.parseInt(st.nextToken());

    Bomb bomb = new Bomb(code, color, second);

    bw.write(bomb.toString());

    br.close();
    bw.close();

  }

  private static class Bomb {

    private String code;
    private String color;
    private int second;

    public Bomb(String code, String color, int second) {
      this.code = code;
      this.color = color;
      this.second = second;
    }

    @Override
    public String toString() {
      return "code : " + code + "\n"
          + "color : " + color + "\n"
          + "second : " + second;
    }
  }
}
