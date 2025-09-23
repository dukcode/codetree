package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-move-to-numbers-with-star/description">LINK</a>
 */
public class ChallengeMoveToNumbersWithStar {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // ~ 400
  private static int k; // ~ 800

  // arr[y][x] : 0 ~ 1_000

  private static int[][] pSum;

  // 시간 복잡도 예상
  // - 무식하게 풀기 :  모든 곳에서 사각형 합 구하기 -> O(K^2 * N^2)  -> O(102_400_000_000)
  // - 행 pSum 적용 : O(K * N^2) -> O(128_000_000) -> 가능!!

  // 합 최대값 예상 -> arr[y][x] * n^2 -> 1_000 * 400 * 400 -> 160_000_000 -> int!

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    pSum = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        int num = Integer.parseInt(st.nextToken());
        pSum[y][x] = (x == 0 ? 0 : pSum[y][x - 1]) + num;
      }
    }

    int ans = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        ans = Math.max(ans, area(y, x));
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int area(int r, int c) {
    int ret = 0;
    for (int y = r - k; y <= r + k; ++y) {
      if (y < 0 || y >= n) {
        continue;
      }

      int remain = k - Math.abs(y - r);

      int frXIn = c - remain;
      int toXIn = c + remain;

      ret += sum(y, frXIn, toXIn);
    }

    return ret;
  }

  private static int sum(int y, int frXIn, int toXIn) {
    return pSum[y][Math.min(n - 1, toXIn)] - (frXIn <= 0 ? 0 : pSum[y][frXIn - 1]);
  }
}
