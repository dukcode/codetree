package org.dukcode.ps.codetree.trail02.chapter10.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-a-b-c-d/description">LINK</a>
 */
public class ChallengeFindABCD {

  private static final int N = 15;
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    // a b ( ... ) cd abd acd bcd abcd
    int a = arr[0];
    int b = arr[1];
    int d = arr[N - 4] - b - a;
    int c = arr[N - 2] - b - d;

    bw.write(a + " " + b + " " + c + " " + d);

    br.close();
    bw.close();

  }
}
