package org.dukcode.ps.codetree.trail06.chapter01.lesson03;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-value-of-node/description">LINK</a>
 */
public class ChallengeValueOfNode {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] values;
  private static List<Integer>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    values = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      values[i] = Integer.parseInt(st.nextToken());
    }

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      adj[a].add(b);
      adj[b].add(a);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    return dfs(0, -1)[1];
  }

  /**
   * @return int[] {toCarry, moves} - [0] : 부모 노드로 전달할 잉여/부족분 (toCarry) - [1] : 현재 서브트리에서 발생한 총 연산
   * 횟수 (moves)
   */
  private static int[] dfs(int cur, int parent) {
    int carried = 0;
    int moves = 0;
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      int[] result = dfs(next, cur);
      carried += result[0];
      moves += result[1];
    }

    int toCarry = values[cur] + carried - 1;
    moves += Math.abs(toCarry);

    return new int[]{toCarry, moves};
  }
}
