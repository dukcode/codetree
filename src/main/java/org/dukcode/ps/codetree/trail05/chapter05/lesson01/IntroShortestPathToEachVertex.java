package org.dukcode.ps.codetree.trail05.chapter05.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-shortest-path-to-each-vertex/description">LINK</a>
 */
public class IntroShortestPathToEachVertex {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 정점의 수
  private static int m; // 간선의 수
  private static int k; // 시작 정점

  private static List<Neighbor>[] adj; // 인접 리스트

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    k = Integer.parseInt(br.readLine()) - 1;

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken()) - 1;
      int to = Integer.parseInt(st.nextToken()) - 1;
      int weight = Integer.parseInt(st.nextToken());

      // 양방향 그래프
      adj[from].add(new Neighbor(to, weight));
      adj[to].add(new Neighbor(from, weight));
    }

    int[] shortestDistances = dijkstra(k);

    for (int i = 0; i < n; ++i) {
      bw.write(
          String.valueOf(shortestDistances[i] == Integer.MAX_VALUE ? -1 : shortestDistances[i]));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  /**
   * 다익스트라 알고리즘을 사용하여 시작 정점으로부터 모든 다른 정점까지의 최단 거리를 계산합니다.
   *
   * @param startNode 시작 정점 인덱스
   * @return 각 정점까지의 최단 거리를 담은 배열
   */
  private static int[] dijkstra(int startNode) {
    int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);

    boolean[] visited = new boolean[n];

    // 우선순위 큐에는 시작점으로부터의 최단 거리 '상태'를 저장합니다.
    PriorityQueue<State> pq = new PriorityQueue<>();

    // 시작점 초기화
    distances[startNode] = 0;
    pq.offer(new State(startNode, 0));

    while (!pq.isEmpty()) {
      State currentState = pq.poll();
      int currentNode = currentState.nodeIndex;
      int currentDistance = currentState.distance;

      if (visited[currentNode]) {
        continue;
      }

      visited[currentNode] = true;

      for (Neighbor neighbor : adj[currentNode]) {
        int neighborNode = neighbor.destination;
        int newDistance = currentDistance + neighbor.distance;

        if (distances[neighborNode] <= newDistance) {
          continue;
        }

        distances[neighborNode] = newDistance;
        pq.offer(new State(neighborNode, newDistance));
      }
    }

    return distances;
  }

  private static class State implements Comparable<State> {

    int nodeIndex;
    int distance; // 시작점으로부터의 총 거리

    public State(int nodeIndex, int distance) {
      this.nodeIndex = nodeIndex;
      this.distance = distance;
    }

    @Override
    public int compareTo(State other) {
      return Integer.compare(this.distance, other.distance);
    }
  }

  private static class Neighbor {

    int destination;
    int distance;

    public Neighbor(int destination, int distance) {
      this.destination = destination;
      this.distance = distance;
    }
  }
}
