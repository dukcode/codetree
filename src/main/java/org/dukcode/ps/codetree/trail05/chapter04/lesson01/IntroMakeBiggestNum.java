package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-make-biggest-num/description">LINK</a>
 */
public class IntroMakeBiggestNum {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] nums = new String[n];
    for (int i = 0; i < n; i++) {
      nums[i] = br.readLine();
    }

    Arrays.sort(nums,
        (n1, n2) -> Long.compare(Long.parseLong(n2 + n1), Long.parseLong(n1 + n2)));

    for (String num : nums) {
      bw.write(num);
    }

    br.close();
    bw.close();
  }
}
