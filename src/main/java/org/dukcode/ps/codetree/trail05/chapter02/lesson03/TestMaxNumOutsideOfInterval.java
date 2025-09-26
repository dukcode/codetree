package org.dukcode.ps.codetree.trail05.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-max-num-outside-of-interval/description">LINK</a>
 */
public class TestMaxNumOutsideOfInterval {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int q;
  private static int[] arr;

  private static int[] leftMax;
  private static int[] rightMax;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    leftMax = new int[n];
    for (int i = 0; i < n; ++i) {
      leftMax[i] = Math.max(i == 0 ? Integer.MIN_VALUE : leftMax[i - 1], arr[i]);
    }

    rightMax = new int[n];
    for (int i = n - 1; i >= 0; --i) {
      rightMax[i] = Math.max(i == n - 1 ? Integer.MIN_VALUE : rightMax[i + 1], arr[i]);
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken()) - 1;
      int toIn = Integer.parseInt(st.nextToken()) - 1;

      int maxValue = Math.max(leftMax[frIn - 1], rightMax[toIn + 1]);

      bw.write(String.valueOf(maxValue));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
