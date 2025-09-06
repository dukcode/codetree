package org.dukcode.ps.codetree.trail05.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-number-frequency/description">LINK</a>
 */
public class IntroNumberFrequency {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Map<Integer, Integer> map;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());
      bw.write(String.valueOf(map.getOrDefault(num, 0)));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }
}
