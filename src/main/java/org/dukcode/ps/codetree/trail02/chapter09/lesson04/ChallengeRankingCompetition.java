package org.dukcode.ps.codetree.trail02.chapter09.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-ranking-competition/description">LINK</a>
 */
public class ChallengeRankingCompetition {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] scores = new int[]{0, 0, 0};
    int prize = getPrize(scores);
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int person = st.nextToken().charAt(0) - 'A';
      int scoreDiff = Integer.parseInt(st.nextToken());

      scores[person] += scoreDiff;
      int nowPrize = getPrize(scores);

      if (prize != nowPrize) {
        cnt++;
      }

      prize = nowPrize;
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static int getPrize(int[] score) {
    int maxScore = score[0];
    for (int person = 0; person < 3; ++person) {
      maxScore = Math.max(maxScore, score[person]);
    }

    int ret = 0;
    for (int person = 0; person < 3; ++person) {
      if (score[person] == maxScore) {
        ret = ret | (1 << person);
      }
    }

    return ret;
  }
}
