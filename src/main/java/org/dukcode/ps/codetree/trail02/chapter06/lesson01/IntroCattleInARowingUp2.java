package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-cattle-in-a-rowing-up-2/description">LINK</a>
 */
public class IntroCattleInARowingUp2 {

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

    bw.write(String.valueOf(solve(arr, -1, 0)));

    br.close();
    bw.close();
  }

  private static int solve(int[] arr, int idxBefore, int cnt) {
    if (cnt == 3) {
      return 1;
    }

    int ret = 0;
    for (int idxNow = idxBefore + 1; idxNow < arr.length; idxNow++) {
      if (idxBefore != -1 && arr[idxBefore] > arr[idxNow]) {
        continue;
      }

      ret += solve(arr, idxNow, cnt + 1);
    }

    return ret;
  }
}
