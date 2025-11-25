package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-assembly-2/description">LINK</a>
 */
public class ChallengeAssembly2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<Integer>[] adj;
  private static int[] indegrees;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    indegrees = new int[n];

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int target = Integer.parseInt(st.nextToken()) - 1;
      int k = Integer.parseInt(st.nextToken());

      indegrees[target] += k;

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < k; ++j) {
        int part = Integer.parseInt(st.nextToken()) - 1;

        adj[part].add(target);
      }
    }

    boolean[] created = new boolean[n];
    Queue<Integer> q = new ArrayDeque<>();
    int size = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < size; ++i) {
      int idx = Integer.parseInt(st.nextToken()) - 1;
      q.offer(idx);
      created[idx] = true;
    }

    List<Integer> ans = new ArrayList<>();
    while (!q.isEmpty()) {
      int cur = q.poll();

      ans.add(cur);

      for (int next : adj[cur]) {
        indegrees[next]--;

        if (created[next]) {
          continue;
        }

        if (indegrees[next] == 0) {
          q.offer(next);
        }
      }
    }

    ans.sort(Comparator.naturalOrder());

    bw.write(String.valueOf(ans.size()));
    bw.newLine();
    for (int idx : ans) {
      bw.write(String.valueOf(idx + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }
}
