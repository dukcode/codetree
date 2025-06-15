package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-tic-tac-to-as-a-team-2/description">LINK</a>
 */
public class ChallengeTicTacToAsATeam2 {

  private static final int N = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    board = new int[N][N];
    for (int y = 0; y < N; y++) {
      String line = br.readLine();
      for (int x = 0; x < N; x++) {
        board[y][x] = line.charAt(x) - '0';
      }
    }

    bw.write(String.valueOf(solve()));

    bw.close();

  }

  private static int solve() {
    Set<Set<Integer>> winTeams = new HashSet<>();
    for (int[] line : board) {
      winTeams.add(calcWinTeam(line));
    }

    int[] diagonal = {board[0][0], board[1][1], board[2][2]};
    int[] counterDiagonal = {board[0][2], board[1][1], board[2][0]};
    winTeams.add(calcWinTeam(diagonal));
    winTeams.add(calcWinTeam(counterDiagonal));

    transpose(board);

    for (int[] line : board) {
      winTeams.add(calcWinTeam(line));
    }

    winTeams.remove(new HashSet<>());

    return winTeams.size();
  }

  private static Set<Integer> calcWinTeam(int[] line) {
    Set<Integer> set = new HashSet<>();
    for (int num : line) {
      set.add(num);
    }

    if (set.size() == 2) {
      return set;
    }

    return new HashSet<>();
  }

  private static void transpose(int[][] board) {
    for (int y = 0; y < N; y++) {
      for (int x = y + 1; x < N; x++) {
        int tmp = board[y][x];
        board[y][x] = board[x][y];
        board[x][y] = tmp;
      }
    }
  }
}
