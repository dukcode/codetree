package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-great-jump/description">LINK</a>
 */
public class IntroGreatJump {

  private static int n;
  private static int k;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {

      if (arr[i] < Math.max(arr[0], arr[n - 1])) {
        continue;
      }

      if (isPossible(i)) {
        ans = Math.min(ans, arr[i]);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static boolean isPossible(int i) {
    int maxVal = arr[i];
    List<Integer> cands = new ArrayList<>();
    for (int idx = 0; idx < n; ++idx) {
      if (arr[idx] <= maxVal) {
        cands.add(idx);
      }
    }

    for (int order = 1; order < cands.size(); ++order) {
      int dist = cands.get(order) - cands.get(order - 1);
      if (dist > k) {
        return false;
      }
    }

    return true;
  }
}
