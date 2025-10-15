package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-red-stone-and-black-stone-2/description">LINK</a>
 */
public class ChallengeRedStoneAndBlackStone2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int c;
  private static int n;
  private static TreeSet<Integer> a;
  private static Range[] b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    a = new TreeSet<>();
    for (int i = 0; i < c; i++) {
      a.add(Integer.parseInt(br.readLine()));
    }

    b = new Range[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken());
      int toIn = Integer.parseInt(st.nextToken());
      b[i] = new Range(frIn, toIn);
    }

    Arrays.sort(b, Comparator.comparingInt(r -> r.toIn));

    int cnt = 0;
    for (Range range : b) {
      if (a.ceiling(range.frIn) != null) {
        int t = a.ceiling(range.frIn);
        if (t <= range.toIn) {
          a.remove(t);
          cnt++;
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }

  private static class Range {

    int frIn;
    int toIn;

    public Range(int frIn, int toIn) {
      this.frIn = frIn;
      this.toIn = toIn;
    }
  }
}
