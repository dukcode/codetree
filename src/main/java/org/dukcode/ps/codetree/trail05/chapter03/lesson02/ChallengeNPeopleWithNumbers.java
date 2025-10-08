package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-n-people-with-numbers/description">LINK</a>
 */
public class ChallengeNPeopleWithNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int tMax;
  private static int[] durations;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    tMax = Integer.parseInt(st.nextToken());

    durations = new int[n];
    for (int i = 0; i < n; i++) {
      durations[i] = Integer.parseInt(br.readLine());
    }

    bw.write(String.valueOf(minNumStage(tMax)));

    br.close();
    bw.close();
  }

  private static int minNumStage(int tMax) {
    int frIn = 1;
    int toEx = n + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (minTime(mid) > tMax) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }

    return frIn;
  }

  private static int minTime(int numStage) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int idx = 0; idx < n; idx++) {
      if (pq.size() < numStage) {
        pq.offer(durations[idx]);
        continue;
      }

      pq.offer(pq.poll() + durations[idx]);
    }

    int ret = -1;
    while (!pq.isEmpty()) {
      ret = pq.poll();
    }

    return ret;
  }
}
