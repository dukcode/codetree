package org.dukcode.ps.codetree.trail04.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-merge-marbles/description">LINK</a>
 */
public class TestMergeMarbles {

  // U D R L
  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, 1, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int t;

  private static Marble[] marbles;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    marbles = new Marble[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int d = parseDir(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      Marble m = new Marble(i, r, c, d, w);
      marbles[i] = m;
    }

    for (int time = 0; time < t; time++) {
      move();
    }

    int cnt = 0;
    int maxW = -1;
    for (int i = 0; i < m; i++) {
      Marble m = marbles[i];
      if (m == null) {
        continue;
      }

      cnt++;
      maxW = Math.max(maxW, m.w);
    }

    bw.write(String.valueOf(cnt));
    bw.write(' ');
    bw.write(String.valueOf(maxW));

    br.close();
    bw.close();

  }

  private static void move() {
    Map<Pos, List<Integer>> positions = new HashMap<>();

    for (int i = 0; i < m; i++) {
      move(i, positions);
    }

    explode(positions);

  }

  private static void move(int i, Map<Pos, List<Integer>> positions) {
    Marble marble = marbles[i];

    if (marble == null) {
      return;
    }

    int ny = marble.y + DY[marble.d];
    int nx = marble.x + DX[marble.d];

    if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
      List<Integer> list =
          positions.getOrDefault(new Pos(marble.y, marble.x), new ArrayList<>());
      list.add(marble.id);
      positions.put(new Pos(marble.y, marble.x), list);

      marbles[i] = new Marble(marble.id, marble.y, marble.x, opposite(marble.d), marble.w);
    } else {
      List<Integer> list =
          positions.getOrDefault(new Pos(ny, nx), new ArrayList<>());
      list.add(marble.id);
      positions.put(new Pos(ny, nx), list);

      marbles[i] = new Marble(marble.id, ny, nx, marble.d, marble.w);
    }
  }

  private static void explode(Map<Pos, List<Integer>> positions) {
    Marble[] newMarbles = new Marble[m];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        List<Integer> ids = positions.getOrDefault(new Pos(y, x), new ArrayList<>());

        if (ids.isEmpty()) {
          continue;
        }

        int id = -1;
        int sumW = 0;
        for (Integer i : ids) {
          Marble m = marbles[i];
          if (m == null) {
            continue;
          }

          id = Math.max(id, m.id);
          sumW += m.w;
        }

        Marble marble = marbles[id];
        newMarbles[id] = new Marble(marble.id, marble.y, marble.x, marble.d, sumW);
      }
    }

    marbles = newMarbles;
  }

  private static int opposite(int dir) {
    // U D R L
    if (dir == 0) {
      return 1;
    }

    if (dir == 1) {
      return 0;
    }

    if (dir == 2) {
      return 3;
    }

    if (dir == 3) {
      return 2;
    }

    return -1;
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

  private static class Marble {

    int id;
    int y;
    int x;
    int d;
    int w;

    public Marble(int id, int y, int x, int d, int w) {
      this.id = id;
      this.y = y;
      this.x = x;
      this.d = d;
      this.w = w;
    }
  }

  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
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
      return y == pos.y && x == pos.x;
    }

    @Override
    public int hashCode() {
      return Objects.hash(y, x);
    }
  }
}
