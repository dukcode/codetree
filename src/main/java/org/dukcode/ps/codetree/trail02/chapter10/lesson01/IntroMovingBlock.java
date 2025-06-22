package org.dukcode.ps.codetree.trail02.chapter10.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-moving-block/description">LINK</a>
 */
public class IntroMovingBlock {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
    }

    int target = sum / n;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += Math.abs(target - arr[i]);
    }
    ans /= 2;

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
