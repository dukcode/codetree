package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-ya-rock/description">LINK</a>
 */
public class IntroYaRock {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] games;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    games = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      games[i][0] = Integer.parseInt(st.nextToken());
      games[i][1] = Integer.parseInt(st.nextToken());
      games[i][2] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int ball = 1; ball <= 3; ball++) {
      ans = Math.max(ans, cntCorrect(ball));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int cntCorrect(int ball) {
    int ret = 0;
    for (int i = 0; i < n; ++i) {
      int a = games[i][0];
      int b = games[i][1];
      if (ball == a || ball == b) {
        ball = ball == a ? b : a;
      }

      int c = games[i][2];

      if (ball == c) {
        ret++;
      }

    }

    return ret;
  }
}
