package org.dukcode.ps.codetree.trail02.chapter09.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-developers-rock-paper-scissors/description">LINK</a>
 */
public class ChallengeDevelopersRockPaperScissors {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] result;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    result = new int[3][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken()) - 1;
      int second = Integer.parseInt(st.nextToken()) - 1;

      result[first][second]++;
    }

    int ans = result[0][1] + result[1][2] + result[2][0];
    ans = Math.max(ans, result[0][2] + result[1][0] + result[2][1]);

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
