package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-take-place/description">LINK</a>
 */
public class ChallengeTakePlace {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    TreeSet<Integer> unused = IntStream.rangeClosed(1, m).boxed()
        .collect(Collectors.toCollection(TreeSet::new));

    st = new StringTokenizer(br.readLine());
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      int seat = Integer.parseInt(st.nextToken());

      if (unused.floor(seat) == null) {
        break;
      } else {
        unused.remove(unused.floor(seat));
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();
  }
}
