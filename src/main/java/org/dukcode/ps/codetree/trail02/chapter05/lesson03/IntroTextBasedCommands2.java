package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-text-based-commands2/description">LINK</a>
 */
public class IntroTextBasedCommands2 {

  // 북 동 남 서
  private static final int[] DX = {0, 1, 0, -1};
  private static final int[] DY = {1, 0, -1, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] commands = br.readLine().toCharArray();

    int x = 0;
    int y = 0;
    int dir = 0;
    for (char command : commands) {
      switch (command) {
        case 'L':
          dir = (dir + 3) % 4;
          break;
        case 'R':
          dir = (dir + 1) % 4;
          break;
        case 'F':
          x += DX[dir];
          y += DY[dir];
          break;
        default:
          break;
      }
    }

    bw.write(x + " " + y);

    br.close();
    bw.close();

  }
}
