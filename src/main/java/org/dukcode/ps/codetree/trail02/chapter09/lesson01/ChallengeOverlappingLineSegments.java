package org.dukcode.ps.codetree.trail02.chapter09.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-overlapping-line-segments/description">LINK</a>
 */
public class ChallengeOverlappingLineSegments {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    boolean ans = false;

    int maxX1 = Integer.MIN_VALUE;
    int minX2 = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      maxX1 = Math.max(maxX1, x1);
      minX2 = Math.min(minX2, x2);
    }

    bw.write(minX2 >= maxX1 ? "Yes" : "No");

    br.close();
    bw.close();

  }
}
