package org.dukcode.ps.codetree.trail04.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-collision-experiment-without-wall/description">LINK</a>
 */
public class ChallengeCollisionExperimentWithoutWall {

  // U D R L
  private static final int[] DX = {0, 0, 1, -1};
  private static final int[] DY = {1, -1, 0, 0};

  private static final int RANGE = 2_000;
  private static final int MAX_T = 4_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Marble[] marbles;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());

      marbles = new Marble[n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) * 2;
        int y = Integer.parseInt(st.nextToken()) * 2;
        int w = Integer.parseInt(st.nextToken());
        int d = parseDir(st.nextToken());

        marbles[i] = new Marble(i, x, y, d, w);
      }

      int time = solve();

      bw.write(String.valueOf(time));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int solve() {
    int time = 0;
    while (time < MAX_T) {
      int interval = nextCollisionInterval();

      if (interval == Integer.MAX_VALUE) {
        break;
      }

      Map<Pos, PriorityQueue<Marble>> positions = move(interval);
      explode(positions);

      time += interval;
    }
    return time == 0 ? -1 : time;
  }

  private static int nextCollisionInterval() {
    int ret = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {

      if (marbles[i] == null) {
        continue;
      }

      for (int j = i + 1; j < n; j++) {

        if (marbles[j] == null) {
          continue;
        }

        ret = Math.min(ret, calcCollisionInterval(marbles[i], marbles[j]));
      }
    }

    return ret;
  }

  private static int calcCollisionInterval(Marble a, Marble b) {

    // U D R L
    if (a.x == b.x &&
        ((a.y < b.y && a.d == 0 && b.d == 1) || (a.y > b.y && a.d == 1 && b.d == 0))) {
      return Math.abs(a.y - b.y) / 2;
    }

    if (a.y == b.y &&
        ((a.x < b.x && a.d == 2 && b.d == 3) || (a.x > b.x && a.d == 3 && b.d == 2))) {
      return Math.abs(a.x - b.x) / 2;
    }

    int dx = a.x - b.x;
    int dy = a.y - b.y;
    int dist = Math.abs(dx);

    if (Math.abs(dx) != Math.abs(dy)) {
      return Integer.MAX_VALUE;
    }

    // a가 b의 왼쪽 아래 (dx < 0, dy < 0)
    if (dx < 0 && dy < 0) {
      if (a.d == 0 && b.d == 3) {
        return dist; // a는 위로(U), b는 왼쪽으로(L)
      }
      if (a.d == 2 && b.d == 1) {
        return dist; // a는 오른쪽으로(R), b는 아래로(D)
      }
    }

    // a가 b의 오른쪽 아래 (dx > 0, dy < 0)
    if (dx > 0 && dy < 0) {
      if (a.d == 0 && b.d == 2) {
        return dist; // a는 위로(U), b는 오른쪽으로(R)
      }
      if (a.d == 3 && b.d == 1) {
        return dist; // a는 왼쪽으로(L), b는 아래로(D)
      }
    }

    // a가 b의 왼쪽 위 (dx < 0, dy > 0)
    if (dx < 0 && dy > 0) {
      if (a.d == 1 && b.d == 3) {
        return dist; // a는 아래로(D), b는 왼쪽으로(L)
      }
      if (a.d == 2 && b.d == 0) {
        return dist; // a는 오른쪽으로(R), b는 위로(U)
      }
    }

    // a가 b의 오른쪽 위 (dx > 0, dy > 0)
    if (dx > 0 && dy > 0) {
      if (a.d == 1 && b.d == 2) {
        return dist; // a는 아래로(D), b는 오른쪽으로(R)
      }
      if (a.d == 3 && b.d == 0) {
        return dist; // a는 왼쪽으로(L), b는 위로(U)
      }
    }

    return Integer.MAX_VALUE;
  }

  private static void explode(Map<Pos, PriorityQueue<Marble>> positions) {
    Marble[] newMarbles = new Marble[n];
    for (Pos pos : positions.keySet()) {
      PriorityQueue<Marble> list = positions.get(pos);

      if (list == null || list.isEmpty()) {
        throw new RuntimeException();
      }

      Marble toRemain = list.poll();
      newMarbles[toRemain.id] = marbles[toRemain.id];
    }

    marbles = newMarbles;
  }

  private static Map<Pos, PriorityQueue<Marble>> move(int interval) {
    Map<Pos, PriorityQueue<Marble>> positions = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      Marble m = marbles[i];

      if (m == null) {
        continue;
      }

      int nx = m.x + DX[m.d] * interval;
      int ny = m.y + DY[m.d] * interval;

      if (nx < -RANGE || nx > RANGE || ny < -RANGE || ny > RANGE) {
        marbles[i] = null;
        continue;
      }

      marbles[i] = new Marble(m.id, nx, ny, m.d, m.w);

      PriorityQueue<Marble> pq =
          positions.getOrDefault(new Pos(nx, ny), new PriorityQueue<>());
      pq.offer(marbles[i]);
      positions.put(new Pos(nx, ny), pq);
    }

    return positions;
  }

  private static int parseDir(String dirStr) {
    switch (dirStr) {
      case "U":
        return 0;
      case "D":
        return 1;
      case "R":
        return 2;
      case "L":
        return 3;
      default:
        throw new RuntimeException();
    }
  }

  private static class Pos {

    int x;
    int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pos pos = (Pos) o;
      return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  private static class Marble implements Comparable<Marble> {

    int id;
    int x;
    int y;
    int d;
    int w;

    public Marble(int id, int x, int y, int d, int w) {
      this.id = id;
      this.x = x;
      this.y = y;
      this.d = d;
      this.w = w;
    }

    @Override
    public int compareTo(Marble o) {
      if (this.w == o.w) {
        return o.id - this.id;
      }

      return o.w - this.w;
    }
  }
}
