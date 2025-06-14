package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-the-grace-form-teacher-3/description">LINK</a>
 */
public class TestTheGraceFormTeacher3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int b;

  private static int[] p;
  private static int[] s;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    p = new int[n];
    s = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      p[i] = Integer.parseInt(st.nextToken());
      s[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int[] prices = new int[n];
      for (int idx = 0; idx < n; idx++) {
        prices[idx] += s[idx] + (idx == i ? p[idx] / 2 : p[idx]);
      }

      ans = Math.max(ans, maxStudent(prices));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int maxStudent(int[] prices) {
    Arrays.sort(prices);

    int cnt = 0;
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      sum += prices[i];

      if (sum > b) {
        break;
      }

      cnt++;
    }

    return cnt;
  }

}
