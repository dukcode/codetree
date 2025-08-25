package org.dukcode.ps.codetree.trail04.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-being-rich-by-working-part-time/description">LINK</a>
 */
public class TestBeingRichByWorkingPartTime {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Work[] works;

  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    works = new Work[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      works[i] = new Work(s, e, p);
    }

    Arrays.sort(works);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    cache = new int[n + 1];
    return solve(-1);
  }

  private static int solve(int idx) {
    if (cache[idx + 1] != 0) {
      return cache[idx + 1];
    }

    int nowP = idx == -1 ? 0 : works[idx].p;
    int nowE = idx == -1 ? -1 : works[idx].e;

    int ret = nowP;
    for (int nextIdx = idx + 1; nextIdx < n; ++nextIdx) {
      int nextS = works[nextIdx].s;
      if (nowE >= nextS) {
        continue;
      }

      ret = Math.max(ret, solve(nextIdx) + nowP);
    }

    return cache[idx + 1] = ret;
  }

  private static class Work implements Comparable<Work> {

    int s;
    int e;
    int p;

    public Work(int s, int e, int p) {
      this.s = s;
      this.e = e;
      this.p = p;
    }

    @Override
    public int compareTo(Work o) {
      if (this.e == o.e && this.s == o.s) {
        return this.p - o.p;
      }

      if (this.e == o.e) {
        return this.s - o.s;
      }

      return this.e - o.e;
    }
  }
}
