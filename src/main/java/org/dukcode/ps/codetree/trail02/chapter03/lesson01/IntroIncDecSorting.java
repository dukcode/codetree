package org.dukcode.ps.codetree.trail02.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-inc-dec-sorting/description">LINK</a>
 */
public class IntroIncDecSorting {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Integer[] arr = new Integer[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, Comparator.naturalOrder());
    print(arr);
    Arrays.sort(arr, Comparator.reverseOrder());
    print(arr);

    br.close();
    bw.close();

  }

  private static void print(Integer[] arr) throws IOException {
    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }
    bw.newLine();
  }
}
