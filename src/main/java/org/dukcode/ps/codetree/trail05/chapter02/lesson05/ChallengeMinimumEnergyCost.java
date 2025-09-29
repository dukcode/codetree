package org.dukcode.ps.codetree.trail05.chapter02.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimum-energy-cost/description">LINK</a>
 */
public class ChallengeMinimumEnergyCost {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] energy; // idx로 가기위한 에너지
  private static int[] cost; // idx에서 에너지를 얻기위해 필요한 코스트

  private static long[] minCost; // idx 전까지 에너지당 가장 작은 코스트

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    energy = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n; i++) {
      energy[i] = Integer.parseInt(st.nextToken());
    }

    cost = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
    }

    minCost = new long[n];
    minCost[0] = cost[0];
    for (int i = 1; i < n; i++) {
      minCost[i] = Math.min(minCost[i - 1], cost[i - 1]);
    }

    long ans = 0;
    for (int i = 1; i < n; i++) {
      ans += minCost[i] * energy[i];
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
