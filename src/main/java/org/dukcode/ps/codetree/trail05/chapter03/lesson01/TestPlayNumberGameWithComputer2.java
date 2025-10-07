package org.dukcode.ps.codetree.trail05.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-play-number-game-with-computer-2/description">LINK</a>
 */
public class TestPlayNumberGameWithComputer2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static long m;
  private static long a;
  private static long b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    m = Long.parseLong(br.readLine());

    st = new StringTokenizer(br.readLine());
    a = Long.parseLong(st.nextToken());
    b = Long.parseLong(st.nextToken());

    int minCnt = Integer.MAX_VALUE;
    int maxCnt = Integer.MIN_VALUE;
    for (long target = a; target <= b; ++target) {
      int cnt = cnt(target);
      minCnt = Math.min(minCnt, cnt);
      maxCnt = Math.max(maxCnt, cnt);
    }

    bw.write(String.valueOf(minCnt));
    bw.write(' ');
    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();
  }

  private static int cnt(long target) {
    long frIn = 1;
    long toIn = m;

    int cnt = 0;
    while (frIn <= toIn) {
      long mid = (frIn + toIn) / 2;
      cnt++;

      if (mid == target) {
        return cnt;
      }

      if (mid < target) {
        frIn = mid + 1;
      } else {
        toIn = mid - 1;
      }
    }

    return -1;
  }
}
