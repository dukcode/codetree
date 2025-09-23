package org.dukcode.ps.codetree.trail05.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-count-number-of-points/description">LINK</a>
 */
public class TestCountNumberOfPoints {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int q;

  private static int[] points;
  private static TreeMap<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    points = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      points[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(points);

    map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      int cnt = i + 1;
      map.put(points[i], cnt);
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken());
      int toIn = Integer.parseInt(st.nextToken());

      bw.write(String.valueOf(cnt(frIn, toIn)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int cnt(int frIn, int toIn) {

    return (map.floorKey(toIn) == null ? 0 : map.floorEntry(toIn).getValue())
        - (map.lowerKey(frIn) == null ? 0 : map.lowerEntry(frIn).getValue());
  }
}
