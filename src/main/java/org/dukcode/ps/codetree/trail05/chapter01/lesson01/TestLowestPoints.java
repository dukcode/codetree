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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-lowest-points/description">LINK</a>
 */
public class TestLowestPoints {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Map<Integer, Integer> xToLowestY;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    xToLowestY = new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int lowestY = Math.min(xToLowestY.getOrDefault(x, Integer.MAX_VALUE), y);
      xToLowestY.put(x, lowestY);
    }

    long ans = xToLowestY.values()
        .stream()
        .mapToLong(y -> y)
        .sum();

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
