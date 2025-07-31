package org.dukcode.ps.codetree.trail04.chapter01.lesson05;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-marble-movement/description">LINK</a>
 */
public class ChallengeMarbleMovement {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int t;
  private static int k;

  private static Marble[] marbles;
  private static List<Integer>[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new List[n][n];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        board[y][x] = new ArrayList<>();
      }
    }

    marbles = new Marble[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      int dir = convert(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      marbles[i] = new Marble(i, y, x, v, dir);
      board[y][x].add(i);
    }

    for (int i = 0; i < t; i++) {
      moveMarbles();
      deleteMarbles();
    }

    int ans = 0;
    for (Marble marble : marbles) {
      if (marble != null) {
        ans++;
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static void deleteMarbles() {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (board[y][x].size() <= k) {
          continue;
        }

        List<Marble> cands = new ArrayList<>();
        for (int idx : board[y][x]) {
          cands.add(marbles[idx]);
        }

        cands.sort((m1, m2) -> m1.v == m2.v ? -Integer.compare(m1.idx, m2.idx)
            : -Integer.compare(m1.v, m2.v));

        for (int i = k; i < cands.size(); i++) {
          Marble marble = cands.get(i);
          marbles[marble.idx] = null;
        }

      }
    }
  }

  private static void moveMarbles() {

    board = new List[n][n];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        board[y][x] = new ArrayList<>();
      }
    }

    for (int idx = 0; idx < m; ++idx) {
      Marble marble = marbles[idx];

      if (marble == null) {
        continue;
      }

      int y = marble.y;
      int x = marble.x;
      int dir = marble.dir;
      int v = marble.v;

      if (dir == 4) {
        System.out.println();
      }

      for (int i = 0; i < v; ++i) {
        int ny = y + DY[dir];
        int nx = x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          dir = opposite(dir);
        }

        y += DY[dir];
        x += DX[dir];
      }

      marbles[idx] = new Marble(idx, y, x, v, dir);
      board[y][x].add(idx);
    }
  }

  private static int opposite(int dir) {
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

  private static int convert(String dir) {
    switch (dir) {
      case "U":
        return 0;
      case "D":
        return 1;
      case "L":
        return 2;
      case "R":
        return 3;
      default:
        return -1;
    }
  }

  private static class Marble {

    int idx;
    int y;
    int x;
    int v;
    int dir;

    public Marble(int idx, int y, int x, int v, int dir) {
      this.idx = idx;
      this.y = y;
      this.x = x;
      this.v = v;
      this.dir = dir;
    }
  }
}