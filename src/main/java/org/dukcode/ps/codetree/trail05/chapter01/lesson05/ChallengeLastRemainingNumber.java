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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-last-remaining-number/description">LINK</a>
 */
public class ChallengeLastRemainingNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    pq = new PriorityQueue<>(Comparator.reverseOrder());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      pq.offer(num);
    }

    while (pq.size() >= 2) {
      int first = pq.poll();
      int second = pq.poll();

      int diff = first - second;

      if (diff == 0) {
        continue;
      }

      pq.offer(diff);
    }

    bw.write(String.valueOf(pq.isEmpty() ? -1 : pq.peek()));

    br.close();
    bw.close();
  }
}
