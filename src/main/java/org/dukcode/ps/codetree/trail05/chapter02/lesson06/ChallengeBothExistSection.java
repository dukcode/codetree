package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-both-exist-section/description">LINK</a>
 */
public class ChallengeBothExistSection {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] arr;

  private static int[] cntOutside;
  private static int distinctOutsideCnt;

  private static int[] cntInside;
  private static int distinctInsideCnt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    cntOutside = new int[m + 1];
    distinctOutsideCnt = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());

      cntOutside[arr[i]]++;
      if (cntOutside[arr[i]] == 1) {
        distinctOutsideCnt++;
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = Integer.MAX_VALUE;

    cntInside = new int[m + 1];
    distinctInsideCnt = 0;

    int right = 0;
    for (int left = 0; left < n; left++) {
      while (right < n && distinctInsideCnt < m) {
        int num = arr[right];

        cntInside[num]++;
        cntOutside[num]--;

        if (cntInside[num] == 1) {
          distinctInsideCnt++;
        }

        if (cntOutside[num] == 0) {
          distinctOutsideCnt--;
        }

        right++;
      }

      if (distinctInsideCnt != m) {
        break;
      }

      if (distinctOutsideCnt == m) {
        ret = Math.min(ret, right - left);
      }

      int num = arr[left];
      cntInside[num]--;
      cntOutside[num]++;

      if (cntInside[num] == 0) {
        distinctInsideCnt--;
      }

      if (cntOutside[num] == 1) {
        distinctOutsideCnt++;
      }
    }
    return ret == Integer.MAX_VALUE ? -1 : ret;
  }
}
