package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-consecutive-n-integers/description">LINK</a>
 */
public class ChallengeSumOfConsecutiveNIntegers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    int toEx = 0;
    int sum = 0;
    for (int frIn = 0; frIn < n; frIn++) {

      while (sum < m && toEx < n) {
        sum += arr[toEx];
        toEx++;
      }

      if (sum < m) {
        break;
      }

      if (sum == m) {
        ans++;
      }

      sum -= arr[frIn];
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
