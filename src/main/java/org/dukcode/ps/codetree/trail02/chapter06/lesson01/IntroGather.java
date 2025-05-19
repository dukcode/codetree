package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-gather/description">LINK</a>
 */
public class IntroGather {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] people = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      people[i] = Integer.parseInt(st.nextToken());
    }

    int ans = Integer.MAX_VALUE;
    for (int target = 0; target < n; target++) {
      int sum = 0;
      for (int source = 0; source < n; source++) {
        int numPeople = people[source];
        sum += Math.abs(target - source) * numPeople;
      }

      ans = Math.min(ans, sum);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
