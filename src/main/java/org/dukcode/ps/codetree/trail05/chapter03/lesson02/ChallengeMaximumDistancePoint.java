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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-distance-point/description">LINK</a>
 */
public class ChallengeMaximumDistancePoint {

  private static final int MX_DIST = 1_000_000_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    points = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(points);

    bw.write(String.valueOf(cntToMaxDist(m)));

    br.close();
    bw.close();
  }

  private static int cntToMaxDist(int targetCnt) {
    int frIn = 1;
    int toEx = MX_DIST + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (minDistToCnt(mid) >= targetCnt) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn - 1;
  }

  /**
   * n번째 부터 선택해서 최대 point 수를 가질 수 있다고 가정 그러면 n번 빼고 n - 1번째로 선택해도 똑같음.
   *
   * @return 물건 사이 최소 간격이 minDist 이상일 때 선택할 수 있는 최대 point 수
   */
  private static int minDistToCnt(int minDist) {
    int ret = 1;
    int lastPos = points[0];

    for (int i = 1; i < n; i++) {
      if (points[i] - lastPos >= minDist) {
        ret++;
        lastPos = points[i];
      }
    }

    return ret;
  }
}
