package org.dukcode.ps.codetree.trail02.chapter03.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-distance-from-origin/description">LINK</a>
 */
public class ChallengeDistanceFromOrigin {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Position[] positions = new Position[n];
    for (int idx = 0; idx < n; idx++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      positions[idx] = new Position(idx, x, y);
    }

    Arrays.sort(positions,
        Comparator.comparingInt(Position::getDistance).thenComparing(p -> p.idx));

    for (Position position : positions) {
      bw.write(String.valueOf(position.idx + 1));
      bw.newLine();
    }
    br.close();
    bw.close();

  }

  private static class Position {

    int idx;
    int x;
    int y;

    public Position(int idx, int x, int y) {
      this.idx = idx;
      this.x = x;
      this.y = y;
    }

    public int getDistance() {
      return Math.abs(this.x) + Math.abs(this.y);
    }


  }
}
