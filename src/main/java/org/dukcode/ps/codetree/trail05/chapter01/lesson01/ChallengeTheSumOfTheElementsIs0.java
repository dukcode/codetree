package org.dukcode.ps.codetree.trail05.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-elements-is-0/description">LINK</a>
 */
public class ChallengeTheSumOfTheElementsIs0 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    Map<Integer, Integer> sumToCnt1 = sum(0, 1);
    Map<Integer, Integer> sumToCnt2 = sum(2, 3);

    int ret = 0;
    for (Integer sum1 : sumToCnt1.keySet()) {
      int cnt1 = sumToCnt1.get(sum1);
      int cnt2 = sumToCnt2.getOrDefault(-sum1, 0);
      ret += cnt1 * cnt2;
    }
    return ret;
  }

  private static Map<Integer, Integer> sum(int idx1, int idx2) {
    Map<Integer, Integer> ret = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        int sum = arr[idx1][i] + arr[idx2][j];
        ret.put(sum, ret.getOrDefault(sum, 0) + 1);
      }
    }

    return ret;
  }

  private static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

    arr = new int[4][n];
    for (int y = 0; y < 4; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        arr[y][x] = Integer.parseInt(st.nextToken());
      }
    }
  }
}
