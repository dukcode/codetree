package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-specific-zone-above-the-2d-coordinate-2/description">LINK</a>
 */
public class IntroSpecificZoneAboveThe2dCoordinate2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] x;
  private static int[] y;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    x = new int[n];
    y = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int minX = except(x, i, Math::min);
      int minY = except(y, i, Math::min);
      int maxX = except(x, i, Math::max);
      int maxY = except(y, i, Math::max);

      int area = Math.abs(maxX - minX) * Math.abs(maxY - minY);

      ans = Math.min(ans, area);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int except(int[] arr, int exceptIdx, BiFunction<Integer, Integer, Integer> func) {
    int ret = arr[exceptIdx == 0 ? 1 : 0];
    for (int i = 1; i < n; ++i) {
      if (i == exceptIdx) {
        continue;
      }

      ret = func.apply(ret, arr[i]);
    }

    return ret;
  }
}
