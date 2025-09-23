package org.dukcode.ps.codetree.trail05.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-top-3-smallest-number/description">LINK</a>
 */
public class TestTop3SmallestNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static PriorityQueue<Long> bottom3;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    bottom3 = new PriorityQueue<>(Comparator.reverseOrder());
    long multiply = 1;
    st = new StringTokenizer(br.readLine());
    // 10_000^4 -> overflow Long.MAX_VALUE 19자리
    for (int i = 0; i < n; i++) {
      long num = Long.parseLong(st.nextToken());

      bottom3.offer(num);

      if (bottom3.size() > 3) {
        long largest = bottom3.poll();
        if (largest != num) {
          multiply /= largest;
          multiply *= num;
        }
      } else {
        multiply *= num;
      }

      if (bottom3.size() == 3) {
        bw.write(String.valueOf(multiply));
      } else {
        bw.write(String.valueOf(-1));
      }

      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
