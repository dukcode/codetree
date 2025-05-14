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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-compare-total-points/description">LINK</a>
 */
public class IntroCompareTotalPoints {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Score[] scores = new Score[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();

      int[] s = new int[3];
      for (int idx = 0; idx < 3; idx++) {
        s[idx] = Integer.parseInt(st.nextToken());
      }

      scores[i] = new Score(name, s);
    }

    Arrays.sort(scores);

    for (Score score : scores) {
      bw.write(score.toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static class Score implements Comparable<Score> {

    private final String name;
    private final int[] scores;

    public Score(String name, int[] scores) {
      this.name = name;
      this.scores = scores;
    }

    private int getTotalScore() {
      return Arrays.stream(scores).sum();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(name);
      sb.append(" ");
      for (int score : scores) {
        sb.append(score);
        sb.append(" ");
      }

      return sb.toString();
    }

    @Override
    public int compareTo(Score o) {
      return this.getTotalScore() - o.getTotalScore();
    }
  }
}
