package org.dukcode.ps.codetree.trail06.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-circular-movement/description">LINK</a>
 */
public class ChallengeCircularMovement {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;

  private static int[] costs;

  private static Map<Integer, Integer>[] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()) + 1;
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    costs = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n; i++) {
      costs[i] = Integer.parseInt(st.nextToken());
    }

    adj = new Map[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new HashMap<>();
    }

    for (int i = 1; i < n; i++) {
      adj[0].put(i, costs[i]);
      adj[i].put(0, costs[i]);
    }

    for (int i = 1; i < n; i++) {
      int j = i == n - 1 ? 1 : i + 1;

      adj[i].put(j, 0);
      adj[j].put(i, 0);
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      adj[a].remove(b);
      adj[b].remove(a);
    }

    bw.write(String.valueOf(solve() ? 1 : 0));

    br.close();
    bw.close();
  }


  private static boolean solve() {
    boolean[] visited = new boolean[n];

    PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(
        Comparator.comparingInt(Entry::getValue));

    for (Entry<Integer, Integer> e : adj[1].entrySet()) {
      pq.offer(e);
    }

    visited[1] = true;

    int cost = 0;
    int visCnt = 1;
    while (!pq.isEmpty()) {
      Entry<Integer, Integer> cur = pq.poll();
      int curIdx = cur.getKey();
      int curCost = cur.getValue();

      if (visited[curIdx]) {
        continue;
      }

      visited[curIdx] = true;
      visCnt++;
      cost += curCost;

      for (Entry<Integer, Integer> next : adj[curIdx].entrySet()) {
        int nextIdx = next.getKey();

        if (visited[nextIdx]) {
          continue;
        }

        pq.offer(next);
      }
    }

    return (visCnt == n || !visited[0] && visCnt == n - 1) && cost <= k;
  }

}
