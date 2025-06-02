package org.dukcode.ps.codetree.trail02.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-ability-of-developer-2/description">LINK</a>
 */
public class ChallengeAbilityOfDeveloper2 {

  private static final int N = 6;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] arr;
  private static int totalSum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());

    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      totalSum += arr[i];
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = 0; k < N; k++) {
          for (int l = k + 1; l < N; l++) {
            if (i == k || i == l || j == k || j == l) {
              continue;
            }

            ans = Math.min(ans, diff(i, j, k, l));
          }
        }
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int diff(int i, int j, int k, int l) {
    int a = arr[i] + arr[j];
    int b = arr[k] + arr[l];
    int c = totalSum - a - b;

    int ret = Math.abs(a - b);
    ret = Math.max(ret, Math.abs(b - c));
    return Math.max(ret, Math.abs(c - a));
  }

}
