package org.dukcode.ps.codetree.trail04.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-roll-a-dice/description">LINK</a>
 */
public class ChallengeRollADice {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int r;
  private static int c;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

    int[][] dice = {
        {0, 5, 0},
        {4, 1, 3},
        {0, 2, 0},
        {0, 6, 0}
    };

    board = new int[n][n];
    board[r][c] = getNum(dice);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      String dir = st.nextToken();
      int nr = r;
      int nc = c;
      switch (dir) {
        case "U":
          nr--;
          break;
        case "D":
          nr++;
          break;
        case "L":
          nc--;
          break;
        case "R":
          nc++;
          break;
        default:
          break;
      }

      if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
        continue;
      }

      r = nr;
      c = nc;

      moveDice(dice, dir);
      board[r][c] = getNum(dice);
    }

    int sum = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        sum += board[y][x];
      }
    }

    bw.write(String.valueOf(sum));

    br.close();
    bw.close();

  }

  public static int getNum(int[][] dice) {
    return dice[3][1];
  }


  public static void moveDice(int[][] dice, String dir) {

    int tmp;
    switch (dir) {
      case "U":
        tmp = dice[0][1];
        dice[0][1] = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = tmp;
        break;
      case "D":
        tmp = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = tmp;
        break;
      case "L":
        tmp = dice[1][0];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][1];
        dice[3][1] = tmp;
        break;
      case "R":
        tmp = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = tmp;
        break;
      default:
        break;
    }
  }
}
