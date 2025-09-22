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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-keep-picking-the-big-number/description">LINK</a>
 */
public class IntroKeepPickingTheBigNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    pq = new PriorityQueue<>(Comparator.reverseOrder());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      pq.add(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < m; ++i) {
      pq.offer(pq.poll() - 1);
    }

    bw.write(String.valueOf(pq.peek()));

    br.close();
    bw.close();
  }
}
