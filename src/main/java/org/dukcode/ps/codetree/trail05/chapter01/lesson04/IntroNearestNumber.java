package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-nearest-number/description">LINK</a>
 */
public class IntroNearestNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static TreeSet<Integer> points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    points = new TreeSet<>();
    points.add(0);
    st = new StringTokenizer(br.readLine());
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());

      if (points.lower(x) != null) {
        minDist = Math.min(minDist, x - points.lower(x));
      }

      if (points.higher(x) != null) {
        minDist = Math.min(minDist, points.higher(x) - x);
      }

      bw.write(String.valueOf(minDist));
      bw.newLine();

      points.add(x);
    }

    br.close();
    bw.close();
  }
}
