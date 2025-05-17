package org.dukcode.ps.codetree.trail02.chapter04.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-painting-white-black/description">LINK</a>
 */
public class ChallengePaintingWhiteBlack {

  private static final int RANGE = 100_000;

  private static final int NONE = 0;
  private static final int WHITE = 1;
  private static final int BLACK = 2;
  private static final int GRAY = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] currentColor;
  private static int[] numWhite;
  private static int[] numBlack;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    currentColor = new int[2 * RANGE + 1];
    numWhite = new int[2 * RANGE + 1];
    numBlack = new int[2 * RANGE + 1];

    int pos = 0;

    int minPos = 0;
    int maxPos = 0;
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      int dir = st.nextToken().equals("L") ? -1 : 1;
      int color = dir == -1 ? WHITE : BLACK;

      for (int move = 0; move < cnt - 1; ++move) {
        paintColor(color, pos);
        pos += dir;
      }
      paintColor(color, pos);

      minPos = Math.min(minPos, pos);
      maxPos = Math.max(maxPos, pos);
    }

    int cntWhite = 0;
    int cntBlack = 0;
    int cntGray = 0;

    for (int i = minPos; i <= maxPos; i++) {
      if (currentColor[i + RANGE] == WHITE) {
        cntWhite++;
      } else if (currentColor[i + RANGE] == BLACK) {
        cntBlack++;
      } else if (currentColor[i + RANGE] == GRAY) {
        cntGray++;
      }
    }

    bw.write(String.valueOf(cntWhite));
    bw.write(' ');
    bw.write(String.valueOf(cntBlack));
    bw.write(' ');
    bw.write(String.valueOf(cntGray));

    br.close();
    bw.close();

  }

  private static void paintColor(int color, int target) {
    if (currentColor[target + RANGE] == GRAY) {
      return;
    }

    if (color == WHITE) {
      numWhite[target + RANGE]++;
    } else {
      numBlack[target + RANGE]++;
    }

    if (numWhite[target + RANGE] >= 2 && numBlack[target + RANGE] >= 2) {
      currentColor[target + RANGE] = GRAY;
      return;
    }

    currentColor[target + RANGE] = color;
  }
}
