package org.dukcode.ps.codetree.trail05.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-admission-to-the-garden-is-on-a-first-come-first-served-basis/description">LINK</a>
 */
public class ChallengeAdmissionToTheGardenIsOnAFirstComeFirstServedBasis {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static PriorityQueue<StayTime> pq;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      pq.offer(new StayTime(i, a, t));
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = 0;

    PriorityQueue<StayTime> line = new PriorityQueue<>(Comparator.comparingInt(a -> a.idx));

    int now = pq.peek().arrivedAt;

    line.offer(pq.poll());

    while (!line.isEmpty()) {
      StayTime stayTime = line.poll();

      int wait = Math.max(0, now - stayTime.arrivedAt);
      ret = Math.max(ret, wait);

      now = Math.max(now, stayTime.arrivedAt) + stayTime.duration;

      while (!pq.isEmpty() && now >= pq.peek().arrivedAt) {
        line.add(pq.poll());
      }

      if (line.isEmpty() && !pq.isEmpty()) {
        line.offer(pq.poll());
      }
    }

    return ret;
  }

  private static class StayTime implements Comparable<StayTime> {

    int idx;
    int arrivedAt;
    int duration;

    public StayTime(int idx, int arrivedAt, int duration) {
      this.idx = idx;
      this.arrivedAt = arrivedAt;
      this.duration = duration;
    }

    @Override
    public int compareTo(StayTime o) {
      if (this.arrivedAt == o.arrivedAt) {
        return Integer.compare(this.idx, o.idx);
      }

      return Integer.compare(this.arrivedAt, o.arrivedAt);
    }
  }
}
