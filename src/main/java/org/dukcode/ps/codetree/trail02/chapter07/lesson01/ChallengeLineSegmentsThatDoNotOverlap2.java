package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-line-segments-that-do-not-overlap-2/description">LINK</a>
 */
public class ChallengeLineSegmentsThatDoNotOverlap2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] x1;
  private static int[] x2;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    x1 = new int[n];
    x2 = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x1[i] = Integer.parseInt(st.nextToken());
      x2[i] = Integer.parseInt(st.nextToken());
    }

    int cnt = 0;

    Loop:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }

        if (overlap(i, j)) {
          continue Loop;
        }
      }

      cnt++;
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static boolean overlap(int i, int j) {
    return (x1[i] - x1[j]) * (x2[i] - x2[j]) <= 0;
  }
}
