package org.dukcode.ps.codetree.trail05.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-reversing-g-and-h/description">LINK</a>
 */
public class IntroReversingGAndH {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static char[] word;
  private static char[] target;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    word = br.readLine().toCharArray();
    target = br.readLine().toCharArray();

    int cnt = 0;
    boolean different = false;
    for (int i = 0; i < n; i++) {
      if (different && word[i] == target[i]) {
        cnt++;
      }
      different = word[i] != target[i];
    }

    if (different) {
      cnt++;
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }
}
