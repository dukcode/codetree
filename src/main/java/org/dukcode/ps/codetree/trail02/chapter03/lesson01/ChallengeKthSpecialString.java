package org.dukcode.ps.codetree.trail02.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-kth-special-string/description">LINK</a>
 */
public class ChallengeKthSpecialString {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    String t = st.nextToken();

    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
    }

    bw.write(kthSpecialString(words, t, k));

    br.close();
    bw.close();

  }

  private static String kthSpecialString(String[] words, String t, int k) {
    Arrays.sort(words);

    int order = 0;
    for (String word : words) {
      if (word.startsWith(t)) {
        order++;
        if (order == k) {
          return word;
        }
      }
    }

    return "";
  }
}
