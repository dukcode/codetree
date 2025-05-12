package org.dukcode.ps.codetree.trail02.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-divide-even-numbers-by-2/description">LINK</a>
 */
public class IntroDivideEvenNumbersBy2 {

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

    divideEvenNumbersBy2(arr);

    for (int i = 0; i < n; ++i) {
      bw.write(String.valueOf(arr[i]));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static void divideEvenNumbersBy2(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      if (arr[i] % 2 == 0) {
        arr[i] /= 2;
      }
    }
  }
}
