package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-high-number-of-cards-wins/description">LINK</a>
 */
public class ChallengeAHighNumberOfCardsWins {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] b;
  private static TreeSet<Integer> cards;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    cards = IntStream.rangeClosed(1, 2 * n).boxed().collect(Collectors.toCollection(TreeSet::new));

    b = new int[n];
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(br.readLine());
      b[i] = num;
      cards.remove(num);
    }

    int score = 0;
    for (int i = 0; i < n; ++i) {
      if (cards.ceiling(b[i]) != null) {
        score++;
        cards.remove(cards.ceiling(b[i]));
      }
    }

    bw.write(String.valueOf(score));

    bw.close();
    br.close();
  }
}
