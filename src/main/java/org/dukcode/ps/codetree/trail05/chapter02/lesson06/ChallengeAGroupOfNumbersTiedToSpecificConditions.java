package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-group-of-numbers-tied-to-specific-conditions/description">LINK</a>
 */
public class ChallengeAGroupOfNumbersTiedToSpecificConditions {

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
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int curMaxSuffixLen = 0;
    int right = n - 1;
    int[] suffixMaxLen = new int[n];
    for (int left = n - 1; left >= 0; --left) {
      while (right > left && arr[right] - arr[left] > k) {
        right--;
      }

      curMaxSuffixLen = Math.max(curMaxSuffixLen, right - left + 1);
      suffixMaxLen[left] = curMaxSuffixLen;
    }

    int curMaxPrefixLen = 0;
    int left = 0;
    int[] prefixMaxLen = new int[n];
    for (right = 0; right < n; ++right) {
      while (left < right && arr[right] - arr[left] > k) {
        left++;
      }

      curMaxPrefixLen = Math.max(curMaxPrefixLen, right - left + 1);
      prefixMaxLen[right] = curMaxPrefixLen;
    }

    int ret = 0;
    for (int i = 0; i < n - 1; ++i) {
      ret = Math.max(ret, prefixMaxLen[i] + suffixMaxLen[i + 1]);
    }

    return ret;
  }
}
