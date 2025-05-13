package org.dukcode.ps.codetree.trail02.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-get-median-2/description">LINK</a>
 */
public class TestGetMedian2 {

  private static final int MX_LEN = 100;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int currentLen = 0;
    int[] arr = new int[MX_LEN];

    int n = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      currentLen++;

      if (i % 2 == 0) {
        Arrays.sort(arr, 0, currentLen);
        bw.write(String.valueOf(arr[currentLen / 2]));
        bw.write(' ');
      }
    }

    br.close();
    bw.close();

  }
}
