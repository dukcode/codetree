package org.dukcode.ps.codetree.trail05.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-find-number-fast/description">LINK</a>
 */
public class IntroFindNumberFast {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(br.readLine());
      bw.write(String.valueOf(findOrder(num)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int findOrder(int num) {
    int frIn = 0;
    int toEx = n;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (arr[mid] == num) {
        return mid + 1;
      }

      if (arr[mid] < num) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return -1;
  }
}
