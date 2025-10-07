package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-subsequence-with-k-or-more-1s/description">LINK</a>
 */
public class TestSubsequenceWithKOrMore1s {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] arr;

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ans = Integer.MAX_VALUE;
    int right = 0;
    int cntOne = 0;
    for (int left = 0; left < n; left++) {
      while (right < n && cntOne < k) {
        cntOne += arr[right] == 1 ? 1 : 0;
        right++;
      }

      if (cntOne == k) { // 이부분 틀렸음
        ans = Math.min(ans, right - left);
      }

      cntOne -= arr[left] == 1 ? 1 : 0;
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
