package org.dukcode.ps.codetree.trail05.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-kth-smallest-pair/description">LINK</a>
 */
public class ChallengeSumOfKthSmallestPair {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;

  private static int[] a;
  private static int[] b;

  private static PriorityQueue<Info> pq;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    b = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);
    Arrays.sort(b);

    pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pq.offer(new Info(i, 0));
    }

    for (int i = 0; i < k - 1; ++i) {
      Info info = pq.poll();
      if (info.bIdx + 1 < m) {
        pq.offer(new Info(info.aIdx, info.bIdx + 1));
      }
    }

    bw.write(String.valueOf(pq.peek().sum));

    br.close();
    bw.close();
  }

  private static class Info implements Comparable<Info> {

    int aIdx;
    int bIdx;
    int sum;

    public Info(int aIdx, int bIdx) {
      this.aIdx = aIdx;
      this.bIdx = bIdx;
      sum = a[aIdx] + b[bIdx];
    }

    @Override
    public int compareTo(Info o) {
      return Integer.compare(sum, o.sum);
    }
  }
}
