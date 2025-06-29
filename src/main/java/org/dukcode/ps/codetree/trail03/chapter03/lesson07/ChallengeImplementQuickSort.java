package org.dukcode.ps.codetree.trail03.chapter03.lesson07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-implement-quick-sort/description">LINK</a>
 */
public class ChallengeImplementQuickSort {

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

    quickSort(arr);

    for (int num : arr) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static void quickSort(int[] arr) {
    int n = arr.length;
    quickSort(arr, 0, n);
  }

  private static void quickSort(int[] arr, int frIn, int toEx) {
    // == 으로 하면 안됨
    if (frIn + 1 >= toEx) {
      return;
    }

    int pivotIdx = partition(arr, frIn, toEx);

    quickSort(arr, frIn, pivotIdx);
    quickSort(arr, pivotIdx + 1, toEx);
  }

  private static int partition(int[] arr, int frIn, int toEx) {
    int pivotIndex = getMedianOfThreePivot(arr, frIn, toEx - 1);
    int pivot = arr[pivotIndex];

    swap(arr, pivotIndex, toEx - 1);

    // Lomuto 분할 방식 (피벗은 arr[toEx - 1]에 있음)
    int i = frIn;
    for (int j = frIn; j < toEx - 1; j++) {
      if (arr[j] < pivot) {
        swap(arr, i, j);
        i++;
      }
    }

    swap(arr, i, toEx - 1);

    return i;
  }

  private static int getMedianOfThreePivot(int[] arr, int low, int high) {
    int mid = low + (high - low) / 2; // 오버플로우 방지

    int a = arr[low];
    int b = arr[mid];
    int c = arr[high];

    if ((a > b) ^ (a > c)) {
      return low;
    }

    if ((c > a) ^ (c > b)) {
      return high;
    }

    return mid;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
