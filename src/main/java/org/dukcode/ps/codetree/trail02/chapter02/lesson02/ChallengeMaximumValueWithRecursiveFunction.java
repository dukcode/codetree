package org.dukcode.ps.codetree.trail02.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-value-with-recursive-function/description">LINK</a>
 */
public class ChallengeMaximumValueWithRecursiveFunction {

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

    bw.write(String.valueOf(getMaxValue(arr, 0, n)));

    br.close();
    bw.close();

  }

  private static int getMaxValue(int[] arr, int frIn, int toEx) {
    if (frIn + 1 == toEx) {
      return arr[frIn];
    }

    if (frIn + 2 == toEx) {
      return Math.max(arr[frIn], arr[frIn + 1]);
    }

    int mid = (frIn + toEx) / 2;

    return Math.max(getMaxValue(arr, frIn, mid), getMaxValue(arr, mid, toEx));
  }
}
