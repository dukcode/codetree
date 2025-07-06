package org.dukcode.ps.codetree.trail04.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-conveyor-belt/description">LINK</a>
 */
public class IntroConveyorBelt {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int t;
  private static int[] arr1;
  private static int[] arr2;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    arr1 = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr1[i] = Integer.parseInt(st.nextToken());
    }

    arr2 = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr2[i] = Integer.parseInt(st.nextToken());
    }

    while (t-- > 0) {
      rotate();
    }

    print(arr1);
    print(arr2);

    br.close();
    bw.close();

  }

  private static void rotate() {
    int tmp = arr1[n - 1];

    for (int i = n - 1; i > 0; --i) {
      arr1[i] = arr1[i - 1];
    }

    arr1[0] = arr2[n - 1];

    for (int i = n - 1; i > 0; --i) {
      arr2[i] = arr2[i - 1];
    }

    arr2[0] = tmp;
  }

  private static void print(int[] arr) throws IOException {
    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    bw.newLine();
  }
}
