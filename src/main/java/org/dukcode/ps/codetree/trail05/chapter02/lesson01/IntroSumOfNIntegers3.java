package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sum-of-n-integers-3/description">LINK</a>
 */
public class IntroSumOfNIntegers3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[][] partialSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    partialSum = new int[n + 1][n + 1];
    for (int y = 1; y <= n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 1; x <= n; x++) {
        int num = Integer.parseInt(st.nextToken());
        partialSum[y][x] =
            partialSum[y - 1][x] + partialSum[y][x - 1] - partialSum[y - 1][x - 1] + num;
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = -1;
    for (int y = k - 1; y < n; y++) {
      for (int x = k - 1; x < n; x++) {
        ret = Math.max(ret, areaSquare(y, x, k));
      }
    }
    return ret;
  }

  private static int areaSquare(int y, int x, int size) {
    return area(y, x) - area(y - size, x) - area(y, x - size) + area(y - size, x - size);
  }

  private static int area(int y, int x) {
    return partialSum[y + 1][x + 1];
  }
}
