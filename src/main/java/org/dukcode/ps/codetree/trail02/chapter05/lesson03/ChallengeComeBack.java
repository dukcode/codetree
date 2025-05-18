package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-come-back/description">LINK</a>
 */
public class ChallengeComeBack {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int y = 0;
    int x = 0;
    boolean comeBack = false;
    int time = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String dir = st.nextToken();
      int d = Integer.parseInt(st.nextToken());
      int dy = getDy(dir);
      int dx = getDx(dir);

      while (d-- > 0) {
        time++;
        y += dy;
        x += dx;

        if (y == 0 && x == 0) {
          comeBack = true;
          break;
        }
      }

      if (comeBack) {
        break;
      }
    }

    bw.write(String.valueOf(comeBack ? time : -1));

    br.close();
    bw.close();
  }

  private static int getDy(String dir) {
    switch (dir) {
      case "N":
        return -1;
      case "S":
        return 1;
      default:
        return 0;
    }
  }

  private static int getDx(String dir) {
    switch (dir) {
      case "W":
        return -1;
      case "E":
        return 1;
      default:
        return 0;
    }
  }
}
