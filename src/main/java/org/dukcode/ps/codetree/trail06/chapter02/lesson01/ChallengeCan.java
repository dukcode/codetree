package org.dukcode.ps.codetree.trail06.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-can/description">LINK</a>
 */
public class ChallengeCan {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static int[] mins;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    mins = IntStream.range(0, n).toArray();

    int cnt = n;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      while (true) {
        b = findMin(b);

        if (b <= a) {
          break;
        }

        mins[b] = findMin(b - 1);
        cnt--;
      }

      bw.write(String.valueOf(cnt));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int findMin(int x) {
    if (mins[x] == x) {
      return x;
    }

    return mins[x] = findMin(mins[x]);
  }
}
