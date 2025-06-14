package org.dukcode.ps.codetree.trail02.chapter07.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-based-on-information-2/description">LINK</a>
 */
public class ChallengeNumberBasedOnInformation2 {

  private static final int RANGE = 1000;
  private static final String S = "S";
  private static final String N = "N";

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int t;
  private static int a;
  private static int b;

  private static String[] magnets;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    t = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    magnets = new String[RANGE + 1];
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      String polar = st.nextToken();
      int pos = Integer.parseInt(st.nextToken());

      magnets[pos] = polar;
    }

    int cnt = 0;
    for (int x = a; x <= b; x++) {
      if (isSpecialPos(x)) {
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  /**
   * @return k로부터 가장 가까이 있는 S와의 거리가 k로 부터 가장 가까이 있는 N과의 거리보다 작거나 같은 경우 참
   */
  private static boolean isSpecialPos(int k) {
    for (int dx = 0; dx < RANGE; dx++) {
      int fr = k - dx;
      int to = k + dx;

      if (fr >= 1 && S.equals(magnets[fr])) {
        return true;
      }

      if (to <= 1000 && S.equals(magnets[to])) {
        return true;
      }

      if (fr >= 1 && N.equals(magnets[fr])) {
        return false;
      }

      if (to <= 1000 && N.equals(magnets[to])) {
        return false;
      }

    }

    return false;
  }
}
