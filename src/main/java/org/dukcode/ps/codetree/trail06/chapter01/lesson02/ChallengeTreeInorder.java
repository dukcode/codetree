package org.dukcode.ps.codetree.trail06.chapter01.lesson02;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-tree-inorder/description">LINK</a>
 */
public class ChallengeTreeInorder {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  private static List<Integer>[] tree;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    int len = (1 << n) - 1;
    arr = new int[len];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < len; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    tree = new List[n];
    for (int i = 0; i < n; i++) {
      tree[i] = new ArrayList<>();
    }

    solve(0, len, 0);

    for (List<Integer> line : tree) {
      for (Integer num : line) {
        bw.write(String.valueOf(num));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static void solve(int frIn, int toEx, int depth) {
    if (frIn + 1 == toEx) {
      tree[depth].add(arr[frIn]);
      return;
    }

    int mid = (frIn + toEx) / 2;
    tree[depth].add(arr[mid]);

    solve(frIn, mid, depth + 1);
    solve(mid + 1, toEx, depth + 1);
  }
}
