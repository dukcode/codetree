package org.dukcode.ps.codetree.trail02.chapter04.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-strange-flipping-tiles/description">LINK</a>
 */
public class TestStrangeFlippingTiles {

  private static final int RANGE = 100_000;

  private static final int BLACK = 1;
  private static final int WHITE = 2;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] tiles = new int[2 * RANGE + 1];
    int pos = 0;
    int minPos = pos;
    int maxPos = pos;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int dir = st.nextToken().equals("L") ? -1 : 1;

      for (int move = 0; move < x - 1; ++move) {
        flip(tiles, pos, dir);
        pos += dir;
      }
      flip(tiles, pos, dir);

      minPos = Math.min(minPos, pos);
      maxPos = Math.max(maxPos, pos);
    }

    int cntBlack = 0;
    int cntWhite = 0;
    for (int i = minPos; i <= maxPos; ++i) {
      if (tiles[i + RANGE] == BLACK) {
        cntBlack++;
      } else if (tiles[i + RANGE] == WHITE) {
        cntWhite++;
      }
    }

    bw.write(String.valueOf(cntWhite));
    bw.write(' ');
    bw.write(String.valueOf(cntBlack));

    br.close();
    bw.close();
  }

  private static void flip(int[] tiles, int pos, int dir) {
    int color = dir == -1 ? WHITE : BLACK;
    tiles[pos + RANGE] = color;
  }
}
