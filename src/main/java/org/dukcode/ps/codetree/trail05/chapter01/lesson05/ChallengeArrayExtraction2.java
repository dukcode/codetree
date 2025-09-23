package org.dukcode.ps.codetree.trail05.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-array-extraction-2/description">LINK</a>
 */
public class ChallengeArrayExtraction2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    pq = new PriorityQueue<>((a, b) ->
        Math.abs(a) == Math.abs(b) ?
            Integer.compare(a, b) :
            Integer.compare(Math.abs(a), Math.abs(b))
    );

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) {
        bw.write(String.valueOf(pq.isEmpty() ? 0 : pq.poll()));
        bw.newLine();
      } else {
        pq.offer(num);
      }
    }

    br.close();
    bw.close();
  }
}
