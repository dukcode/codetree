package org.dukcode.ps.codetree.trail03.chapter03.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-implement-insertion-sort/description">LINK</a>
 */
public class ChallengeImplementInsertionSort {

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

    insertionSort(arr);

    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int target = 1; target < n; target++) {

      int value = arr[target];
      int idx = target - 1;
      while (idx >= 0 && arr[idx] > value) {
        arr[idx + 1] = arr[idx];
        idx--;
      }

      arr[idx + 1] = value;
    }
  }
}
