package org.dukcode.ps.codetree.trail02.chapter10.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-odd-even-bundle/description">LINK</a>
 */
public class ChallengeOddEvenBundle {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int even = 0;
    int odd = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (num % 2 == 0) {
        even++;
      } else {
        odd++;
      }
    }

    bw.write(String.valueOf(solve(even, odd)));

    br.close();
    bw.close();

  }

  private static int solve(int even, int odd) {
    if (odd > even) {
      int diff = odd - even;
      return (2 * even) + (2 * (diff / 3)) + (1 - ((1 + (diff % 3)) % 3));
      // diff : 3x -> x, x(2x) -> 2x
      // diff : 3x + 1 -> x - 1(x + 1), x(2x) -> 2x - 1
      // diff : 3x + 2 -> x, x + 1(2x + 2) -> 2x + 1
      // f(1) = -1 -> 1 - mod3(1 + 1)
      // f(0) = 0  -> 1 - mod3(1 + 0)
      // f(2) = 1  -> 1 - mod3(1 + 2) -> 1
    }

    if (even > odd) {
      // 3x -> 1(3x), 0 -> 1
      // 3x + 1 -> 1(3x + 1), 0 -> 1
      // 3x + 2 -> 1(3x + 2), 0 -> 1
      return 2 * odd + 1;
    }

    return even + odd;
  }
}
