package org.dukcode.ps.codetree.trail03.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-implement-bubble-sort/description">LINK</a>
 */
public class ChallengeImplementBubbleSort {

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

    bubbleSort(arr);

    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      boolean sorted = true;
      for (int idx = 0; idx < n - 1 - i; ++idx) {
        if (arr[idx] > arr[idx + 1]) {
          swap(arr, idx, idx + 1);
          sorted = false;
        }
      }

      if (sorted) {
        return;
      }
    }
  }

  private static void bubbleSort2(int[] arr) {
    int n = arr.length;

    boolean sorted;
    do {
      sorted = true;
      for (int idx = 0; idx < n - 1; ++idx) {
        if (arr[idx] > arr[idx + 1]) {
          swap(arr, idx, idx + 1);
          sorted = false;
        }
      }
    } while (!sorted);
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
