package org.dukcode.ps.codetree.trail02.chapter03.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-indices-of-sorted-array/description">LINK</a>
 */
public class ChallengeIndicesOfSortedArray {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine().trim());

    st = new StringTokenizer(br.readLine());
    Number[] nums = new Number[n];
    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(st.nextToken());
      nums[i] = new Number(i, value);
    }

    Arrays.sort(nums, Comparator.comparingInt(num -> num.value));

    int[] order = new int[n];
    for (int i = 0; i < n; i++) {
      order[nums[i].idx] = i;
    }

    for (int i : order) {
      bw.write(String.valueOf(i + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static class Number {

    int idx;
    int value;

    public Number(int idx, int value) {
      this.idx = idx;
      this.value = value;
    }
  }
}
