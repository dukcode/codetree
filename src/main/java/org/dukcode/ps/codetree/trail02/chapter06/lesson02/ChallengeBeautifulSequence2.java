package org.dukcode.ps.codetree.trail02.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-beautiful-sequence-2/description">LINK</a>
 */
public class ChallengeBeautifulSequence2 {

  private static final int MAX_NUM = 100;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] a;
  private static int[] b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int cnt = 0;

    Loop:
    for (int start = 0; start <= n - m; ++start) {
      int[] freqA = new int[MAX_NUM + 1];
      int[] freqB = new int[MAX_NUM + 1];
      for (int delta = 0; delta < m; ++delta) {
        freqA[a[start + delta]]++;
        freqB[b[delta]]++;
      }

      for (int num = 1; num <= MAX_NUM; ++num) {
        if (freqA[num] != freqB[num]) {
          continue Loop;
        }
      }

      cnt++;
    }

    return cnt;
  }
}
