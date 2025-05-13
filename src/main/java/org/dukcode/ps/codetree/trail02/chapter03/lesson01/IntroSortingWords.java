package org.dukcode.ps.codetree.trail02.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-sorting-words/description">LINK</a>
 */
public class IntroSortingWords {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
    }

    Arrays.sort(words);

    for (String word : words) {
      bw.write(word);
      bw.newLine();
    }

    br.close();
    bw.close();

  }
}
