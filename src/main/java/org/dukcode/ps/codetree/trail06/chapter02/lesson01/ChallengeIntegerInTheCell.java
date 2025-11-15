package org.dukcode.ps.codetree.trail06.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-integer-in-the-cell/description">LINK</a>
 */
public class ChallengeIntegerInTheCell {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int m;

  private static int[] lastEmpties;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    lastEmpties = IntStream.range(0, n).toArray();

    int ans = 0;
    for (int i = 0; i < m; i++) {
      int k = Integer.parseInt(br.readLine()) - 1;

      int lastEmpty = findLastEmpty(k);

      if (lastEmpty == -1) {
        break;
      }

      int beforeEmpty = findLastEmpty(lastEmpty - 1);
      lastEmpties[lastEmpty] = beforeEmpty;
      ans++;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int findLastEmpty(int x) {
    if (x < 0) {
      return -1;
    }

    if (lastEmpties[x] == x) {
      return x;
    }

    return lastEmpties[x] = findLastEmpty(lastEmpties[x]);
  }
}
