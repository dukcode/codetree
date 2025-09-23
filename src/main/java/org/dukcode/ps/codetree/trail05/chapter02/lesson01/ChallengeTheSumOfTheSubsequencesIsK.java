package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-sum-of-the-subsequences-is-k/description">LINK</a>
 */
public class ChallengeTheSumOfTheSubsequencesIsK {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 3 ~ 1_000
  private static int k; // 1 ~ 1_000_000
  private static int[] arr; // arr[i] : 1 ~ 1_000_000

  // 최대 합 : 1_000_000_000 -> int
  // 시간 복잡도: O(N^2)

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int cnt = 0;
    for (int pivot = 0; pivot < n; pivot++) {
      int sum = 0;
      for (int idx = pivot; idx < n; idx++) {
        sum += arr[idx];

        if (sum > k) {
          continue;
        }

        if (sum == k) {
          cnt++;
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }
}
