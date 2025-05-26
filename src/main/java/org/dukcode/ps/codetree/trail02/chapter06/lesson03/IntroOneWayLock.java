package org.dukcode.ps.codetree.trail02.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-one-way-lock/description">LINK</a>
 */
public class IntroOneWayLock {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[3];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int cnt = 1;
    for (int num : arr) {
      cnt *= n - (Math.min(n, num + 2) - Math.max(1, num - 2) + 1);
    }

    bw.write(String.valueOf(n * n * n - cnt));

    br.close();
    bw.close();

  }
}
