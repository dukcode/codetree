package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-use-the-swimming-pool-efficiently/description">LINK</a>
 */
public class TestUseTheSwimmingPoolEfficiently {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] times;
  private static int total;
  private static int max;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    times = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      times[i] = Integer.parseInt(st.nextToken());
      total += times[i];
      max = Math.max(max, times[i]);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = max;
    int toEx = total + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (cntMinLane(mid) > m) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn;
  }

  private static int cntMinLane(int timeLimit) {
    int cnt = 0;
    int sum = timeLimit;
    for (int idx = 0; idx < n; ++idx) {
      if (sum + times[idx] > timeLimit) {
        cnt++;
        sum = times[idx];
      } else {
        sum += times[idx];
      }
    }

    return cnt;
  }
}
