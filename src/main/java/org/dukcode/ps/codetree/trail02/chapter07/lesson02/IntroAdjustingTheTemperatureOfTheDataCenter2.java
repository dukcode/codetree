package org.dukcode.ps.codetree.trail02.chapter07.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-adjusting-the-temperature-of-the-data-center-2/description">LINK</a>
 */
public class IntroAdjustingTheTemperatureOfTheDataCenter2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int c; // 미만인 경우 작업량
  private static int g; // 이상, 이하인 경우의 작업량
  private static int h; // 초과인 경우 작업량

  private static int[] frIn;
  private static int[] toIn;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    int minT = Integer.MAX_VALUE;
    int maxT = Integer.MIN_VALUE;

    frIn = new int[n];
    toIn = new int[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      frIn[i] = Integer.parseInt(st.nextToken());
      toIn[i] = Integer.parseInt(st.nextToken());

      minT = Math.min(minT, frIn[i]);
      maxT = Math.max(maxT, frIn[i]);
    }

    int ans = Integer.MIN_VALUE;
    for (int t = minT - 1; t <= maxT + 1; t++) { // 범위 확장 시켜야함!!
      ans = Math.max(ans, calc(t));
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int calc(int t) {
    int ret = 0;
    for (int i = 0; i < n; ++i) {
      if (t < frIn[i]) {
        ret += c;
      } else if (t > toIn[i]) {
        ret += h;
      } else {
        ret += g;
      }
    }

    return ret;
  }
}
