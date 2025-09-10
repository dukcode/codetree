package org.dukcode.ps.codetree.trail05.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-changing-seats-2/description">LINK</a>
 */
public class ChallengeChangingSeats2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] a;
  private static int[] b;

  private static Set<Integer>[] log; // 사람 -> 자리
  private static int[] seat; // 자리 -> 사람

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[k];
    b = new int[k];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken()) - 1;
      b[i] = Integer.parseInt(st.nextToken()) - 1;
    }

    seat = IntStream.range(0, n).toArray();

    log = new Set[n];
    for (int i = 0; i < n; i++) {
      log[i] = new HashSet<>();
      log[i].add(i);
    }

    for (int i = 0; i < 3 * k; i++) {
      int idx = i % k;
      int tmp = seat[a[idx]];
      seat[a[idx]] = seat[b[idx]];
      seat[b[idx]] = tmp;

      log[seat[a[idx]]].add(a[idx]);
      log[seat[b[idx]]].add(b[idx]);
    }

    for (int i = 0; i < n; i++) {
      bw.write(String.valueOf(log[i].size()));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
