package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-subsequences-with-few-overlapping-elements/description">LINK</a>
 */
public class ChallengeSubsequencesWithFewOverlappingElements {

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
    int ret = 0;

    Map<Integer, Integer> map = new HashMap<>();

    int right = 0;
    for (int left = 0; left < n; ++left) {
      while (right < n && map.getOrDefault(arr[right], 0) < k) {
        map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
        right++;
      }

      ret = Math.max(ret, right - left);

      map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
    }

    return ret;
  }
}
