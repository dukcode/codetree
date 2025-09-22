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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-delete-it-from-the-beginning-2/description">LINK</a>
 */
public class ChallengeDeleteItFromTheBeginning2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.format("%.2f", solve()));

    br.close();
    bw.close();
  }

  private static double solve() {
    double ret = Double.MIN_VALUE;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int sum = arr[n - 1];
    pq.offer(arr[n - 1]);
    for (int i = n - 2; i > 0; --i) {
      pq.offer(arr[i]);
      sum += arr[i];

      double avg = 1.0 * (sum - pq.peek()) / (pq.size() - 1);
      ret = Math.max(ret, avg);
    }

    return ret;
  }
}
