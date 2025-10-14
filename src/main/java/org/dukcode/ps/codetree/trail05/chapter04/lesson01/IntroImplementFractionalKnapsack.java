package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-implement-fractional-knapsack/description">LINK</a>
 */
public class IntroImplementFractionalKnapsack {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static Jewel[] jewels;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    jewels = new Jewel[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      jewels[i] = new Jewel(w, v);
    }

    Arrays.sort(jewels, Comparator.reverseOrder());

    double weightSum = 0.0;
    double valueSum = 0.0;
    for (Jewel jewel : jewels) {
      if (Math.abs(m - weightSum) <= 0.0001) {
        break;
      }

      double portion = Math.min(1.0, (m - weightSum) / jewel.w);
      weightSum += portion * jewel.w;
      valueSum += portion * jewel.v;
    }

    bw.write(String.format("%.3f", valueSum));

    br.close();
    bw.close();
  }

  private static class Jewel implements Comparable<Jewel> {

    int w;
    int v;

    public Jewel(int w, int v) {
      this.w = w;
      this.v = v;
    }

    @Override
    public int compareTo(Jewel o) {
      return Double.compare((double) v / w, (double) o.v / o.w);
    }
  }
}
