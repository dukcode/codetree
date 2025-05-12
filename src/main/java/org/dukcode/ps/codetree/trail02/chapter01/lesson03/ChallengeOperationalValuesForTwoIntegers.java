package org.dukcode.ps.codetree.trail02.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-operational-values-for-two-integers/description">LINK</a>
 */
public class ChallengeOperationalValuesForTwoIntegers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[2];
    arr[0] = Integer.parseInt(st.nextToken());
    arr[1] = Integer.parseInt(st.nextToken());

    solve(arr);

    bw.write(String.valueOf(arr[0]));
    bw.write(' ');
    bw.write(String.valueOf(arr[1]));

    br.close();
    bw.close();

  }

  private static void solve(int[] arr) {
    if (arr[0] > arr[1]) {
      arr[0] += 25;
      arr[1] *= 2;
    } else {
      arr[0] *= 2;
      arr[1] += 25;
    }
  }
}
