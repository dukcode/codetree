package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-small-but-big-number/description">LINK</a>
 */
public class TestSmallButBigNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static TreeSet<Integer> nums = new TreeSet<>();

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    nums = new TreeSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      nums.add(num);
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int query = Integer.parseInt(st.nextToken());
      if (nums.floor(query) == null) {
        bw.write(String.valueOf(-1));
      } else {
        int floor = nums.floor(query);
        nums.remove(floor);
        bw.write(String.valueOf(floor));
      }
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
