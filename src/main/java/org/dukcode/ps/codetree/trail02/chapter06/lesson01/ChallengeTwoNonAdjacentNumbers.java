package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-two-non-adjacent-numbers/description">LINK</a>
 */
public class ChallengeTwoNonAdjacentNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int maxSum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 2; j < n; j++) {
        maxSum = Math.max(maxSum, arr[j] + arr[i]);
      }
    }

    bw.write(String.valueOf(maxSum));

    br.close();
    bw.close();

  }
}
