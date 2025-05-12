package org.dukcode.ps.codetree.trail02.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-operational-values-for-two-integers-2/description">LINK</a>
 */
public class TestOperationalValuesForTwoIntegers2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[2];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    changeValue(arr);

    bw.write(String.valueOf(arr[0]));
    bw.write(' ');
    bw.write(String.valueOf(arr[1]));

    br.close();
    bw.close();

  }

  private static void changeValue(int[] arr) {
    if (arr[0] < arr[1]) {
      arr[0] += 10;
      arr[1] *= 2;
    } else {
      arr[0] *= 2;
      arr[1] += 10;
    }
  }
}
