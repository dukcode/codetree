package org.dukcode.ps.codetree.trail02.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-ability-of-developer-3/description">LINK</a>
 */
public class IntroAbilityOfDeveloper3 {

  private static final int N = 6;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] arr;
  private static int totalSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      totalSum += arr[i];
    }

    bw.write(String.valueOf(solve(-1, 0, 0)));

    br.close();
    bw.close();

  }

  private static int solve(int lastIdx, int picked, int sum) {
    if (picked == N / 2) {
      return Math.abs(sum * 2 - totalSum);
    }

    int ret = Integer.MAX_VALUE;
    for (int i = lastIdx + 1; i < N; i++) {
      ret = Math.min(ret, solve(i, picked + 1, sum + arr[i]));
    }

    return ret;
  }
}
