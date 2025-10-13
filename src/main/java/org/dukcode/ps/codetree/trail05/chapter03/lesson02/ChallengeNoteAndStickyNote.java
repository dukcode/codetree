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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-note-and-sticky-note/description">LINK</a>
 */
public class ChallengeNoteAndStickyNote {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 공책 갯수
  private static int k; // 추가적으로 만들 포스트잇 최대 갯수
  private static int l; // 하나의 포스트잇에 적을 수 있는 공책의 번호 갯수

  private static int[] c; // c[i] -> i번 공책이 다른 포스트잇에 적힌 횟수
  private static int maxC;

  // c[i]가 h 이상인 공책이 h개 이상이 있으면 그 중 최대값을 h-index 라고 부름
  // 최대 h-index 를 구하라

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());

    c = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      c[i] = Integer.parseInt(st.nextToken());
      maxC = Math.max(maxC, c[i]);
    }

    Arrays.sort(c);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = n + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (isPossible(mid)) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn - 1;
  }

  private static boolean isPossible(int h) {
    long toAdd = 0;
    for (int i = n - 1; i >= n - h; i--) {
      if (c[i] >= h) {
        continue;
      }

      int need = h - c[i];
      if (need > k) {
        return false;
      }

      toAdd += need;
    }

    return toAdd <= (long) k * l;
  }
}
