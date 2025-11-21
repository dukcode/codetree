package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-size-comparison-3/description">LINK</a>
 */
public class IntroSizeComparison3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static List<Integer>[] adj;
  private static int[] inbounds;

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

    inbounds = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int before = Integer.parseInt(st.nextToken()) - 1;
      int after = Integer.parseInt(st.nextToken()) - 1;

      adj[before].add(after);
      inbounds[after]++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int idx = 0; idx < n; idx++) {
      if (inbounds[idx] == 0) {
        pq.offer(idx);
      }
    }

    List<Integer> order = new ArrayList<>();
    while (!pq.isEmpty()) {
      int cur = pq.poll();

      order.add(cur);

      for (int next : adj[cur]) {
        inbounds[next]--;
        if (inbounds[next] == 0) {
          pq.offer(next);
        }
      }
    }

    for (Integer idx : order) {
      bw.write(String.valueOf(idx + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }
}
