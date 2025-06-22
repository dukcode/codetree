package org.dukcode.ps.codetree.trail02.chapter09.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-study-cafe-keeping-distance-2/description">LINK</a>
 */
public class ChallengeStudyCafeKeepingDistance2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static char[] line;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    line = br.readLine().toCharArray();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = Integer.MIN_VALUE;
    for (int seatIdx = 0; seatIdx < n; ++seatIdx) {
      if (line[seatIdx] == '1') {
        continue;
      }

      line[seatIdx] = '1';
      ret = Math.max(ret, minDist());
      line[seatIdx] = '0';
    }

    return ret;
  }

  private static int minDist() {
    int ret = Integer.MAX_VALUE;
    int beforeIdx = -1;
    for (int idx = 0; idx < n; ++idx) {
      if (line[idx] == '0') {
        continue;
      }

      if (beforeIdx == -1) {
        beforeIdx = idx;
        continue;
      }

      ret = Math.min(ret, idx - beforeIdx);
      beforeIdx = idx;
    }

    return ret;
  }
}
