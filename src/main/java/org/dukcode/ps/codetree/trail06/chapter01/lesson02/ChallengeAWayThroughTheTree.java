package org.dukcode.ps.codetree.trail06.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-way-through-the-tree/description">LINK</a>
 */
public class ChallengeAWayThroughTheTree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int q;

  private static boolean[] checked;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    checked = new boolean[n + 1];
    for (int i = 0; i < q; i++) {
      int target = Integer.parseInt(br.readLine());
      bw.write(String.valueOf(findFirstChecked(target)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int findFirstChecked(int target) {
    int now = target;
    int ret = 0;
    while (now > 0) {
      if (checked[now]) {
        ret = now;
      }

      now /= 2;
    }

    if (ret == 0) {
      checked[target] = true;
    }

    return ret;
  }
}
