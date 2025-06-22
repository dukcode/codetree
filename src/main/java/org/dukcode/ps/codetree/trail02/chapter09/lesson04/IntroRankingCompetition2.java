package org.dukcode.ps.codetree.trail02.chapter09.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-ranking-competition2/description">LINK</a>
 */
public class IntroRankingCompetition2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int status = 0;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String target = st.nextToken();
      int score = Integer.parseInt(st.nextToken());

      int newStatus = status + score * (target.equals("A") ? 1 : -1);
      if (changed(status, newStatus)) {
        cnt++;
      }

      status = newStatus;
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static boolean changed(int status, int newStatus) {

    if (status == 0 && newStatus == 0) {
      return false;
    }

    if (status * newStatus <= 0) {
      return true;
    }

    return false;
  }
}
