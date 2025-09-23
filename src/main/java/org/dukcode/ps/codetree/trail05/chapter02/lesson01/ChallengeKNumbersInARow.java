package org.dukcode.ps.codetree.trail05.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-k-numbers-in-a-row/description">LINK</a>
 */
public class ChallengeKNumbersInARow {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 1 ~ n까지의 숫자
  private static int k;
  private static int b; // 빠져 있는 숫자 갯수

  private static int[] notExists; // 빠져 있는 숫자 목록
  private static int[] pSum;

  // 최소 k개의 숫자들이 연속되게 하기 위해 추가해야 하는 숫자 갯수의 최솟값을 구하라

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    notExists = new int[n];
    for (int i = 0; i < b; i++) {
      int num = Integer.parseInt(br.readLine());
      notExists[num - 1] = 1;
    }

    pSum = new int[n];
    pSum[0] = notExists[0];
    for (int i = 1; i < n; i++) {
      pSum[i] = pSum[i - 1] + notExists[i];
    }

    int ret = Integer.MAX_VALUE;
    for (int frIn = 0; frIn <= n - k; frIn++) {
      int toEx = frIn + k;
      ret = Math.min(ret, sum(frIn, toEx));
    }

    bw.write(String.valueOf(ret));

    br.close();
    bw.close();
  }

  private static int sum(int frIn, int toEx) {
    return pSum[toEx - 1] - (frIn == 0 ? 0 : pSum[frIn - 1]);
  }

  // 쓰레기 방법
  /*
  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < b; i++) {
      set.add(Integer.parseInt(br.readLine()));
    }

    int ret = Integer.MAX_VALUE;
    for (int start = 1; start <= n - (k - 1); start++) {
      int end = start + k - 1;
      ret = Math.min(ret, set.subSet(start, end + 1).size());
    }

    bw.write(String.valueOf(ret));

    br.close();
    bw.close();
  }
  */
}
