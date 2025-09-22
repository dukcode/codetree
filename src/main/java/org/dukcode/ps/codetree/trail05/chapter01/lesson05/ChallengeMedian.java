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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-median/description">LINK</a>
 */
public class ChallengeMedian {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static PriorityQueue<Integer> lower;
  private static PriorityQueue<Integer> higher;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());

      lower = new PriorityQueue<>(Comparator.reverseOrder());
      higher = new PriorityQueue<>();
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        int num = Integer.parseInt(st.nextToken());

        if (lower.size() < higher.size()) {
          lower.offer(num);
        } else {
          higher.offer(num);
        }

        while (!lower.isEmpty() && lower.peek() > higher.peek()) {
          int a = lower.poll();
          int b = higher.poll();
          lower.offer(b);
          higher.offer(a);
        }

        if (i % 2 == 0) {
          bw.write(String.valueOf(higher.peek()));
          bw.write(' ');
        }
      }

      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
