package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-study-cafe-keeping-distance-5/description">LINK</a>
 */
public class IntroStudyCafeKeepingDistance5 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] seats;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    String line = br.readLine();
    seats = new int[n];
    for (int i = 0; i < n; i++) {
      seats[i] = line.charAt(i) - '0';
    }

    int ans = Integer.MIN_VALUE;
    for (int idx = 0; idx < n; ++idx) {
      if (seats[idx] == 1) {
        continue;
      }
      ans = Math.max(ans, minDist(idx));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int minDist(int idx) {
    int ret = Integer.MAX_VALUE;

    int before = -1;

    for (int i = 0; i < n; i++) {
      if (i != idx && seats[i] == 0) {
        continue;
      }

      if (before == -1) {
        before = i;
        continue;
      }

      ret = Math.min(ret, i - before);
      before = i;
    }

    return ret;
  }
}
