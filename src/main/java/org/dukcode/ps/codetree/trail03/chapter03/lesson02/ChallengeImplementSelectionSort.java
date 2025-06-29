package org.dukcode.ps.codetree.trail03.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-implement-selection-sort/description">LINK</a>
 */
public class ChallengeImplementSelectionSort {

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

    selectionSort(arr);

    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int target = 0; target < n - 1; target++) {
      int minIdx = target;
      for (int idx = target + 1; idx < n; idx++) {
        if (arr[idx] < arr[minIdx]) {
          minIdx = idx;
        }
      }

      swap(arr, target, minIdx);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
