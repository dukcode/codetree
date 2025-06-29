package org.dukcode.ps.codetree.trail03.chapter03.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-implement-merge-sort/description">LINK</a>
 */
public class ChallengeImplementMergeSort {

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

    mergeSort(arr);

    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static void mergeSort(int[] arr) {
    int n = arr.length;
    mergeSort(arr, 0, n);
  }

  private static void mergeSort(int[] arr, int frIn, int toEx) {
    if (frIn + 1 == toEx) {
      return;
    }

    int mid = (frIn + toEx) / 2;
    mergeSort(arr, frIn, mid);
    mergeSort(arr, mid, toEx);
    merge(arr, frIn, mid, toEx);
  }

  private static void merge(int[] arr, int frIn, int mid, int toEx) {
    int n = toEx - frIn;
    int[] tmp = new int[n];

    int i = frIn;
    int j = mid;
    for (int idx = 0; idx < n; ++idx) {
      if (i == mid) {
        tmp[idx] = arr[j++];
        continue;
      }

      if (j == toEx) {
        tmp[idx] = arr[i++];
        continue;
      }

      if (arr[i] < arr[j]) {
        tmp[idx] = arr[i++];
      } else {
        tmp[idx] = arr[j++];
      }
    }

    System.arraycopy(tmp, 0, arr, frIn, n);
  }
}
