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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-korean-english-math-order/description">LINK</a>
 */
public class IntroKoreanEnglishMathOrder {

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
      int koreanScore = Integer.parseInt(st.nextToken());
      int englishScore = Integer.parseInt(st.nextToken());
      int mathScore = Integer.parseInt(st.nextToken());

      scores[i] = new Score(name, koreanScore, englishScore, mathScore);
    }

    Arrays.sort(scores);

    for (int i = 0; i < n; i++) {
      bw.write(scores[i].toString());
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static class Score implements Comparable<Score> {

    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;

    public Score(String name, int koreanScore, int englishScore, int mathScore) {
      this.name = name;
      this.koreanScore = koreanScore;
      this.englishScore = englishScore;
      this.mathScore = mathScore;
    }

    @Override
    public String toString() {
      return name + " " + koreanScore + " " + englishScore + " " + mathScore;
    }

    @Override
    public int compareTo(Score o) {
      if (this.koreanScore == o.koreanScore && this.englishScore == o.englishScore) {
        return o.mathScore - this.mathScore;
      }

      if (this.koreanScore == o.koreanScore) {
        return o.englishScore - this.englishScore;
      }

      return o.koreanScore - this.koreanScore;
    }
  }
}
