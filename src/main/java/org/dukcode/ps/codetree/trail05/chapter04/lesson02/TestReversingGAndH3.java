package org.dukcode.ps.codetree.trail05.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-reversing-g-and-h-3/description">LINK</a>
 */
public class TestReversingGAndH3 {

  private static BufferedReader br;
  private static BufferedWriter bw;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    char[] word = br.readLine().toCharArray();
    char[] target = br.readLine().toCharArray();

    int ans = 0;
    int diffSize = 0;
    for (int i = 0; i < n; i++) {
      if (word[i] != target[i]) {
        diffSize++;
      } else {
        ans += (diffSize + 3) / 4;
        diffSize = 0;
      }
    }

    ans += (diffSize + 3) / 4;

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
