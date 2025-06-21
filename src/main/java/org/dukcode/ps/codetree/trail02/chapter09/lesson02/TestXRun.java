package org.dukcode.ps.codetree.trail02.chapter09.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-x-run/description">LINK</a>
 */
public class TestXRun {

  private static final int MN_SEC = 1;
  private static final int MX_SEC = 10_000;

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int dist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    dist = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int t = 0;
    int leftDist = dist;
    int v = 1;
    while (true) {
      leftDist -= v;
      t++;

      if (leftDist == 0) {
        return t;
      }

      int accelMinDist = (v + 1) * (v + 2) / 2;
      if (leftDist >= accelMinDist) {
        v++;
        continue;
      }

      int holdMinDist = v * (v + 1) / 2;
      if (leftDist >= holdMinDist) {
        continue;
      }

      v--;
    }
  }

  private static int calcMinSec(int dist) {
    int frInSec = MN_SEC;
    int enExSec = MX_SEC;

    while (frInSec < enExSec) {
      int midSec = (frInSec + enExSec) / 2;

      if (calcMaxDist(midSec) < dist) {
        frInSec = midSec + 1;
      } else {
        enExSec = midSec;
      }
    }

    return frInSec;
  }

  private static int calcMaxDist(int sec) {
    if (sec % 2 == 0) {
      int half = sec / 2;
      return (1 + half) * half;
    }

    int half = sec / 2;
    return (1 + half) * half + (sec + 1) / 2;
  }
}
