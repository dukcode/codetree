package org.dukcode.ps.codetree.trail04.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-The-1D-bomb-game/description">LINK</a>
 */
public class ChallengeThe1dBombGame {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int lastIdx = n;
    while (boom(lastIdx)) {
      lastIdx = drop(lastIdx);
    }

    bw.write(String.valueOf(lastIdx));
    bw.newLine();
    for (int i = 0; i < lastIdx; i++) {
      bw.write(String.valueOf(arr[i]));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static int drop(int lastIdx) {
    int idx = 0;
    for (int i = 0; i < lastIdx; i++) {
      if (arr[i] == 0) {
        continue;
      }
      arr[idx++] = arr[i];
    }

    return idx;
  }

  private static boolean boom(int lastIdx) {
    boolean ret = false;
    int cnt = 0;
    int before = -1;
    for (int i = 0; i < lastIdx; ++i) {

      if (arr[i] != before) {
        if (cnt >= m) {
          ret = true;
          remove(i - 1, cnt);
        }

        cnt = 1;
        before = arr[i];
        continue;
      }

      cnt++;
    }

    if (cnt >= m) {
      ret = true;
      remove(lastIdx - 1, cnt);
    }

    return ret;
  }

  private static void remove(int enIn, int cnt) {
    for (int i = enIn; i > enIn - cnt; --i) {
      arr[i] = 0;
    }
  }
}
