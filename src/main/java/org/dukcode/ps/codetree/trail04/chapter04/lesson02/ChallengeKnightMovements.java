package org.dukcode.ps.codetree.trail04.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-knight-movements/description">LINK</a>
 */
public class ChallengeKnightMovements {

  private static final int[] DY = {-2, -1, 1, 2, 2, 1, -1, -2};
  private static final int[] DX = {1, 2, 2, 1, -1, -2, -2, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Pos start;
  private static Pos end;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int r1 = Integer.parseInt(st.nextToken()) - 1;
    int c1 = Integer.parseInt(st.nextToken()) - 1;
    int r2 = Integer.parseInt(st.nextToken()) - 1;
    int c2 = Integer.parseInt(st.nextToken()) - 1;

    start = new Pos(r1, c1);
    end = new Pos(r2, c2);

    bw.write(String.valueOf(solve(start, end)));

    br.close();
    bw.close();

  }

  private static int solve(Pos start, Pos end) {
    int[][] dist = new int[n][n];
    for (int y = 0; y < n; y++) {
      Arrays.fill(dist[y], -1);
    }

    Queue<Pos> q = new ArrayDeque<>();
    q.add(start);
    dist[start.y][start.x] = 0;
    while (!q.isEmpty()) {
      Pos cur = q.poll();
      if (cur.equals(end)) {
        return dist[cur.y][cur.x];
      }

      for (int dir = 0; dir < 8; ++dir) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (dist[ny][nx] != -1) {
          continue;
        }

        dist[ny][nx] = dist[cur.y][cur.x] + 1;
        q.offer(new Pos(ny, nx));
      }
    }

    return -1;
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
      if (o == null || this.getClass() != o.getClass()) {
        return false;
      }

      Pos pos = (Pos) o;
      return y == pos.y && x == pos.x;
    }

  }
}
