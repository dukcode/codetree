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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-waiting-for-the-bus/description">LINK</a>
 */
public class ChallengeWaitingForTheBus {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 번호표
  private static int m; // 버스 수
  private static int c; // 각 버스 최대 탑승 가능 인원
  private static int[] arriveAt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arriveAt = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arriveAt[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arriveAt);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = arriveAt[n - 1] - arriveAt[0] + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;
      if (minBus(mid) > m) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn;
  }

  private static int minBus(int maxWait) {
    int ret = 0;
    int startIdx = -1;
    for (int idx = 0; idx < n; ++idx) {
      if (idx == 0 || arriveAt[idx] - arriveAt[startIdx] > maxWait || idx - startIdx >= c) {
        startIdx = idx;
        ret++;
      }
    }

    return ret;
  }
}
