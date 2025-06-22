package org.dukcode.ps.codetree.trail02.chapter09.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-maximum-product-of-three-numbers/description">LINK</a>
 */
public class TestMaximumProductOfThreeNumbers {

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

    Arrays.sort(arr);

    int ans = arr[0] * arr[1] * arr[n - 1]; // 음 음 양
    ans = Math.max(ans, arr[n - 3] * arr[n - 2] * arr[n - 1]); // 양 양 양 or 음 음 음
    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
