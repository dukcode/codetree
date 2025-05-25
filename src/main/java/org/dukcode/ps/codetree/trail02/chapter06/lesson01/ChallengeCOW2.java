package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-c-o-w-2/description">LINK</a>
 */
public class ChallengeCOW2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String line = br.readLine();

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (line.charAt(i) != 'C') {
        continue;
      }
      for (int j = i + 1; j < n; j++) {
        if (line.charAt(j) != 'O') {
          continue;
        }
        for (int k = j + 1; k < n; k++) {
          if (line.charAt(k) != 'W') {
            continue;
          }

          cnt++;
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }
}
