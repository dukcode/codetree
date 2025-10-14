package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-merge-numbers/description">LINK</a>
 */
public class IntroMergeNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static PriorityQueue<Integer> nums;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    nums = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      nums.add(Integer.parseInt(st.nextToken()));
    }

    int totalCost = 0;
    while (nums.size() > 1) {
      int a = nums.poll();
      int b = nums.poll();

      totalCost += a + b;
      nums.offer(a + b);
    }

    bw.write(String.valueOf(totalCost));

    br.close();
    bw.close();
  }
}
