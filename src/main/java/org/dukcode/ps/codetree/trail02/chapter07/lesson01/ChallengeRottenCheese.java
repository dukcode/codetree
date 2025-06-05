package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rotten-cheese/description">LINK</a>
 */
public class ChallengeRottenCheese {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 사람
  private static int m; // 치즈
  private static int d; // 먹은 기록
  private static int s; // 아픈 기록

  private static Eating[] eating;
  private static Sickness[] sickness;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    eating = new Eating[d + 1];
    sickness = new Sickness[n + 1];

    for (int i = 0; i < d; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken()); // 사람 번호
      int m = Integer.parseInt(st.nextToken()); // 치즈 번호
      int t = Integer.parseInt(st.nextToken()); // 먹은 시간
      eating[i] = new Eating(p, m, t);
    }

    for (int i = 0; i < s; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken()); // 사람 번호
      int t = Integer.parseInt(st.nextToken()); // 아픈 시간
      sickness[i] = new Sickness(p, t);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ans = 0;
    for (int cheese = 1; cheese <= m; cheese++) {
      int[] time = getFirstEatingTime(cheese);
      if (!isPossible(time)) {
        continue;
      }
      int pill = getPill(time);
      ans = Math.max(ans, pill);
    }
    return ans;
  }

  private static int getPill(int[] firstEatingTime) {
    int pill = 0;

    for (int person = 1; person <= n; person++) {
      if (haveNotEaten(firstEatingTime, person)) {
        continue;
      }

      pill++;
    }

    return pill;
  }

  private static boolean haveNotEaten(int[] firstEatingTime, int pIdx) {
    return firstEatingTime[pIdx] == Integer.MAX_VALUE;
  }

  private static boolean isPossible(int[] firstEatingTime) {
    for (int idx = 0; idx < s; idx++) {
      int person = sickness[idx].p;

      if (haveNotEaten(firstEatingTime, person)) {
        return false;
      }

      // 모순
      if (firstEatingTime[person] >= sickness[idx].t) {
        return false;
      }
    }
    return true;
  }

  private static int[] getFirstEatingTime(int cheese) {
    int[] time = new int[n + 1];
    Arrays.fill(time, Integer.MAX_VALUE);
    for (int idx = 0; idx < d; idx++) {
      if (eating[idx].m != cheese) {
        continue;
      }

      int person = eating[idx].p;
      time[person] = Math.min(time[person], eating[idx].t);
    }
    return time;
  }

  private static class Eating {

    int p;
    int m;
    int t;

    public Eating(int p, int m, int t) {
      this.p = p;
      this.m = m;
      this.t = t;
    }
  }

  private static class Sickness {

    int p;
    int t;

    public Sickness(int p, int t) {
      this.p = p;
      this.t = t;
    }
  }
}
