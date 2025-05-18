package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-come-back-2/description">LINK</a>
 */
public class ChallengeComeBack2 {

  // N E S W
  private static final int[] DY = {-1, 0, 1, 0};
  private static final int[] DX = {0, 1, 0, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] commands = br.readLine().toCharArray();
    bw.write(String.valueOf(move(commands)));

    br.close();
    bw.close();

  }

  private static int move(char[] commands) {
    int y = 0;
    int x = 0;
    int dir = 0;

    boolean moved = false;
    for (int i = 0; i < commands.length; i++) {
      char command = commands[i];
      switch (command) {
        case 'L':
          dir = (dir + 1) % 4;
          break;
        case 'R':
          dir = (dir + 3) % 4;
          break;
        case 'F':
          moved = true;
          y += DY[dir];
          x += DX[dir];
          break;
        default:
          break;
      }

      if (moved && y == 0 && x == 0) {
        return i + 1;
      }
    }

    return -1;
  }
}
