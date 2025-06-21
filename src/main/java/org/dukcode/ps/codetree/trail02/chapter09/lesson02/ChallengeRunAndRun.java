package org.dukcode.ps.codetree.trail02.chapter09.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-run-and-run/description">LINK</a>
 */
public class ChallengeRunAndRun {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[] before = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      before[i] = Integer.parseInt(st.nextToken());
    }

    int[] after = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      after[i] = Integer.parseInt(st.nextToken());
    }

    int totalMove = 0;
    for (int i = 0; i < n - 1; ++i) {
      int toMove = before[i] - after[i];
      before[i + 1] += toMove;
      totalMove += toMove;
    }

    bw.write(String.valueOf(totalMove));

    br.close();
    bw.close();

  }
}
