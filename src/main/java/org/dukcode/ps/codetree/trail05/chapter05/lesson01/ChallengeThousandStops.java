package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-thousand-stops/description">LINK</a>
 */
public class ChallengeThousandStops {

  private static final int MX_V = 1_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int a;
  private static int b;
  private static int n;

  private static State[][] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken()) - 1;
    b = Integer.parseInt(st.nextToken()) - 1;
    n = Integer.parseInt(st.nextToken());

    adj = new State[MX_V][MX_V];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      long cost = Long.parseLong(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int[] stops = new int[m];
      st = new StringTokenizer(br.readLine());
      for (int idx = 0; idx < stops.length; idx++) {
        stops[idx] = Integer.parseInt(st.nextToken()) - 1;
      }

      for (int fr = 0; fr < m; fr++) {
        for (int to = fr + 1; to < m; to++) {
          State state = new State(cost, to - fr);
          if (adj[stops[fr]][stops[to]] == null || adj[stops[fr]][stops[to]].compareTo(state) > 0) {
            adj[stops[fr]][stops[to]] = state;
          }
        }
      }

    }

    State ans = dijkstra(a, b);

    bw.write(ans.toString());

    br.close();
    bw.close();
  }

  private static State dijkstra(int a, int b) {
    boolean[] vis = new boolean[MX_V];

    State[] states = new State[MX_V];
    Arrays.fill(states, State.INF);

    states[a] = State.ZERO;

    for (int i = 0; i < MX_V; ++i) {

      int curIdx = -1;
      State minState = State.INF;
      for (int idx = 0; idx < MX_V; ++idx) {
        if (vis[idx]) {
          continue;
        }

        if (states[idx].compareTo(minState) < 0) {
          curIdx = idx;
          minState = states[idx];
        }
      }

      if (curIdx == -1) {
        break;
      }

      vis[curIdx] = true;

      for (int nextIdx = 0; nextIdx < MX_V; ++nextIdx) {
        if (vis[nextIdx]) {
          continue;
        }

        if (adj[curIdx][nextIdx] == null) {
          continue;
        }

        State nextState = minState.add(adj[curIdx][nextIdx]);

        if (states[nextIdx].compareTo(nextState) <= 0) {
          continue;
        }

        states[nextIdx] = nextState;
      }
    }

    return states[b];
  }

  public static class State implements Comparable<State> {

    public static State ZERO = new State(0L, 0L);
    public static State INF = new State(Long.MAX_VALUE, Long.MAX_VALUE);

    final long cost;
    final long time;

    public State(long cost, long time) {
      this.cost = cost;
      this.time = time;
    }

    public State add(State state) {
      return new State(this.cost + state.cost, this.time + state.time);
    }

    @Override
    public int compareTo(State o) {
      return this.cost == o.cost ? Long.compare(time, o.time) : Long.compare(cost, o.cost);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }

      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      State other = (State) o;
      return this.cost == other.cost && this.time == other.time;
    }

    @Override
    public String toString() {
      return this.equals(State.INF) ? "-1 -1" : this.cost + " " + this.time;
    }
  }
}
