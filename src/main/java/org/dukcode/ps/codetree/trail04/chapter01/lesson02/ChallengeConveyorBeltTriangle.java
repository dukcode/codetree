package org.dukcode.ps.codetree.trail04.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-conveyor-belt-triangle/description">LINK</a>
 */
public class ChallengeConveyorBeltTriangle {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int t;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    arr = new int[3 * n];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int idx = 0; idx < n; idx++) {
        arr[n * i + idx] = Integer.parseInt(st.nextToken());
      }
    }

    while (t-- > 0) {
      rotate();
    }

    for (int i = 0; i < 3; ++i) {
      for (int idx = 0; idx < n; idx++) {
        bw.write(String.valueOf(arr[i * n + idx]));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void rotate() {
    int n = arr.length;

    int tmp = arr[n - 1];

    for (int i = n - 1; i > 0; --i) {
      arr[i] = arr[i - 1];
    }

    arr[0] = tmp;
  }
}
