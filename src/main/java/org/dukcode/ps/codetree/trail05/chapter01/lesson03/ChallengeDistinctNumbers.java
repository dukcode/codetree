package org.dukcode.ps.codetree.trail05.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-distinct-numbers/description">LINK</a>
 */
public class ChallengeDistinctNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    bw.write(String.valueOf(set.size()));

    br.close();
    bw.close();
  }
}
