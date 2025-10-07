package org.dukcode.ps.codetree.trail05.chapter02.lesson06.review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-max-interval-without-overlapping-numbers/description">LINK</a>
 */
public class IntroMaxIntervalWithoutOverlappingNumbers {

  private static final int RANGE = 100_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

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

    int[] cnt = new int[RANGE + 1];

    int maxLen = 0;
    int right = 0; // exclusive
    for (int left = 0; left < n; left++) {
      while (right < n && cnt[arr[right]] != 1) {
        cnt[arr[right]]++;
        right++;
      }

      maxLen = Math.max(maxLen, right - left);

      cnt[arr[left]]--;
    }

    return maxLen;
  }
}
