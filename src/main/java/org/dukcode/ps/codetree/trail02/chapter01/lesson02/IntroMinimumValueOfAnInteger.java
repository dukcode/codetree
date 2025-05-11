package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-minimum-value-of-an-integer/introduction">LINK</a>
 */
public class IntroMinimumValueOfAnInteger {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[3];
    st = new StringTokenizer(br.readLine());
    arr[0] = Integer.parseInt(st.nextToken());
    arr[1] = Integer.parseInt(st.nextToken());
    arr[2] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr);

    bw.write(String.valueOf(arr[0]));

    br.close();
    bw.close();

  }
}
