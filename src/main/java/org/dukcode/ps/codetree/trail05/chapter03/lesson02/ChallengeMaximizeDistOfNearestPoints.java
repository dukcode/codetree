package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximize-dist-of-nearest-points/description">LINK</a>
 */
public class ChallengeMaximizeDistOfNearestPoints {

  private static final int MX_DIST = 1_000_000_000 - 1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Line[] lines;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    lines = new Line[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      lines[i] = new Line(x1, x2);
    }

    Arrays.sort(lines,
        (l1, l2) -> l1.x1 == l2.x1 ? Integer.compare(l1.x2, l2.x2) : Integer.compare(l1.x1, l2.x1));

    bw.write(String.valueOf(maximinDist()));

    br.close();
    bw.close();
  }

  /**
   * @return 각 선분위에 1개씩 점을 찍었을 때 점들 사이의 거리 중 가장 가까운 거리의 최대 값
   */
  private static int maximinDist() {
    int frIn = 1;
    int toEx = MX_DIST + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (isPossible(mid) >= 1) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn - 1;
  }

  /**
   * @return 각 거리들을 minDist 이상으로 잡을 수 있는지 여부
   */
  private static int isPossible(int minDist) {
    int posBefore = lines[0].x1 - minDist;
    for (Line line : lines) {
      if (line.x2 < posBefore + minDist) {
        return 0;
      }

      posBefore = Math.max(line.x1, posBefore + minDist);
    }

    return 1;
  }

  private static class Line {

    int x1;
    int x2;

    public Line(int x1, int x2) {
      this.x1 = x1;
      this.x2 = x2;
    }
  }
}
