package org.dukcode.ps.codetree.trail02.chapter09.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-district-cleaning/description">LINK</a>
 */
public class ChallengeDistrictCleaning {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] a = new int[2];
    st = new StringTokenizer(br.readLine());
    a[0] = Integer.parseInt(st.nextToken());
    a[1] = Integer.parseInt(st.nextToken());

    int[] b = new int[2];
    st = new StringTokenizer(br.readLine());
    b[0] = Integer.parseInt(st.nextToken());
    b[1] = Integer.parseInt(st.nextToken());

    int area = intersected(a, b) ? Math.max(a[1], b[1]) - Math.min(a[0], b[0])
        : a[1] - a[0] + b[1] - b[0];
    bw.write(String.valueOf(area));

    br.close();
    bw.close();

  }

  private static boolean intersected(int[] a, int[] b) {
    return a[1] >= b[0] && b[1] >= a[0];
  }
}
