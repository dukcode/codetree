package org.dukcode.ps.codetree.trail04.chapter05.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rod-cutting/description">LINK</a>
 */
public class ChallengeRodCutting {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  private static int[] cache;

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
    cache = new int[n + 1];
    return solve(n);
  }

  private static int solve(int len) {
    if (cache[len] != 0) {
      return cache[len];
    }

    int ret = arr[len - 1];
    for (int len1 = 1; len1 <= len / 2; len1++) {
      int len2 = len - len1;
      ret = Math.max(ret, solve(len1) + solve(len2));
    }

    return cache[len] = ret;
  }
}

