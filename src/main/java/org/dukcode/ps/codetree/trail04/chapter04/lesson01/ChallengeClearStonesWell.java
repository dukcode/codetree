package org.dukcode.ps.codetree.trail04.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-clear-stones-well/description">LINK</a>
 */
public class ChallengeClearStonesWell {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int m;

  private static int[][] board;

  private static List<Pos> stones;

  private static Pos[] starts;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    stones = new ArrayList<>();
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        if (board[y][x] == 1) {
          stones.add(new Pos(y, x));
        }
      }
    }

    starts = new Pos[k];
    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      starts[i] = new Pos(y, x);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    boolean[] taken = new boolean[stones.size()];
    List<Integer> picked = new ArrayList<>();
    return solve(-1, picked, taken);
  }

  private static int solve(int lastIdx, List<Integer> picked, boolean[] taken) {
    if (picked.size() == m) {
      return cntBlocks(picked);
    }

    int ret = 0;
    for (int idx = lastIdx + 1; idx < stones.size(); idx++) {
      if (taken[idx]) {
        continue;
      }

      taken[idx] = true;
      picked.add(idx);

      ret = Math.max(ret, solve(idx, picked, taken));

      picked.remove(picked.size() - 1);
      taken[idx] = false;
    }

    return ret;
  }

  private static int cntBlocks(List<Integer> picked) {
    for (Integer stoneIdx : picked) {
      board[stones.get(stoneIdx).y][stones.get(stoneIdx).x] = 0;
    }

    int ret = 0;
    ret += bfs();

    for (Integer stoneIdx : picked) {
      board[stones.get(stoneIdx).y][stones.get(stoneIdx).x] = 1;
    }

    return ret;
  }

  private static int bfs() {
    boolean[][] discovered = new boolean[n][n];
    Queue<Pos> q = new ArrayDeque<>();

    for (Pos start : starts) {
      discovered[start.y][start.x] = true;
      q.offer(new Pos(start.y, start.x));
    }

    int cnt = 0;
    while (!q.isEmpty()) {
      Pos cur = q.poll();
      cnt++;
      for (int dir = 0; dir < 4; dir++) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (discovered[ny][nx]) {
          continue;
        }

        if (board[ny][nx] == 1) {
          continue;
        }

        discovered[ny][nx] = true;
        q.offer(new Pos(ny, nx));
      }
    }

    return cnt;
  }

  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
