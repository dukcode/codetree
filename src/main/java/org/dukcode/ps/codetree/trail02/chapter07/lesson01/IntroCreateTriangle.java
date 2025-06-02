package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-create-triangle/description">LINK</a>
 */
public class IntroCreateTriangle {

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

    List<Integer> picked = new ArrayList<>();
    bw.write(String.valueOf(solve(picked)));

    br.close();
    bw.close();

  }

  private static int solve(List<Integer> picked) {
    if (picked.size() == 3) {
      return calcArea(picked);
    }

    int lastIdx = picked.isEmpty() ? -1 : picked.get(picked.size() - 1);
    int ans = 0;
    for (int i = lastIdx + 1; i < n; i++) {
      picked.add(i);
      ans = Math.max(ans, solve(picked));
      picked.remove(picked.size() - 1);
    }

    return ans;
  }

  private static int calcArea(List<Integer> picked) {
    int[] idx = new int[]{
        picked.get(0),
        picked.get(1),
        picked.get(2)
    };

    for (int pIdx = 0; pIdx < 3; pIdx++) {
      int p = idx[pIdx];
      int q = idx[(pIdx + 1) % 3];
      int r = idx[(pIdx + 2) % 3];

      int area = areaIfRightTriangle(p, q, r);
      if (area != 0) {
        return area;
      }
    }

    return 0;
  }

  private static int areaIfRightTriangle(int p, int q, int r) {
    if (x[p] == x[q] && y[p] == y[r]) {
      return Math.abs((x[r] - x[p]) * (y[q] - y[p]));
    }

    if (x[p] == x[r] && y[p] == y[q]) {
      return Math.abs((x[q] - x[p]) * (y[r] - y[p]));
    }

    return 0;
  }
}
