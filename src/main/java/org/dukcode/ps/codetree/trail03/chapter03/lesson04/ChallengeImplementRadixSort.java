package org.dukcode.ps.codetree.trail03.chapter03.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-implement-radix-sort/description">LINK</a>
 */
public class ChallengeImplementRadixSort {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    int k = -1;
    for (int i = 0; i < n; i++) {
      String numStr = st.nextToken();
      k = Math.max(k, numStr.length());
      arr[i] = Integer.parseInt(numStr);
    }

    radixSort(arr, k);

    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  public static void radixSort(int[] arr, int k) {
    for (int pos = 0; pos < k; pos++) {
      List<Integer>[] temp = new ArrayList[10];
      for (int i = 0; i < 10; i++) {
        temp[i] = new ArrayList<>();
      }

      for (int num : arr) {
        int digit = (num / (int) Math.pow(10, pos)) % 10;
        temp[digit].add(num);
      }

      int idx = 0;
      for (int i = 0; i < 10; i++) {
        for (int num : temp[i]) {
          arr[idx] = num;
          ++idx;
        }
      }

    }
  }
}
