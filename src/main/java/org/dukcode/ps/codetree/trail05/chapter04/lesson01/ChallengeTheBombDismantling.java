package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-bomb-dismantling/description">LINK</a>
 */
public class ChallengeTheBombDismantling {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Bomb[] bombs;
  private static int maxT;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    bombs = new Bomb[n];
    maxT = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int score = Integer.parseInt(st.nextToken());
      int timeLimit = Integer.parseInt(st.nextToken());
      bombs[i] = new Bomb(score, timeLimit);
      maxT = Math.max(maxT, timeLimit - 1);
    }

    Arrays.sort(bombs);

    int ans = 0;
    int bombIdx = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int t = maxT; t >= 0; t--) {
      while (bombIdx < n && bombs[bombIdx].timeLimit > t) {
        pq.offer(bombs[bombIdx].score);
        bombIdx++;
      }

      if (!pq.isEmpty()) {
        ans += pq.poll();
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static class Bomb implements Comparable<Bomb> {

    int score;
    int timeLimit;

    public Bomb(int score, int timeLimit) {
      this.score = score;
      this.timeLimit = timeLimit;
    }

    @Override
    public int compareTo(Bomb o) {
      return Integer.compare(o.timeLimit, timeLimit);
    }

  }
}
