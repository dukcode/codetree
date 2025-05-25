package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-pair-parentheses-2/description">LINK</a>
 */
public class ChallengePairParentheses2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] line = br.readLine().toCharArray();
    bw.write(String.valueOf(cntPairing(line, new ArrayList<>())));

    br.close();
    bw.close();
  }

  private static int cntPairing(char[] line, List<Integer> picked) {
    if (picked.size() == 4) {
      if (isOpen(line[picked.get(0)]) && isOpen(line[picked.get(1)]) &&
          isClose(line[picked.get(2)]) && isClose(line[picked.get(3)]) &&
          picked.get(0) + 1 == picked.get(1) && picked.get(2) + 1 == picked.get(3)) {
        return 1;
      }

      return 0;
    }

    int lastIdx = picked.isEmpty() ? -1 : picked.get(picked.size() - 1);
    int ret = 0;
    for (int i = lastIdx + 1; i < line.length; i++) {
      picked.add(i);
      ret += cntPairing(line, picked);
      picked.remove(picked.size() - 1);
    }

    return ret;
  }

  private static boolean isOpen(char c) {
    return c == '(';
  }

  private static boolean isClose(char c) {
    return c == ')';
  }
}
