package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximize-the-number-of-parenthesis-matches/description">LINK</a>
 */
public class ChallengeMaximizeTheNumberOfParenthesisMatches {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static String[] tokens;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    tokens = new String[n];
    BracketCnt[] bracketCnts = new BracketCnt[n];
    for (int i = 0; i < n; i++) {
      tokens[i] = br.readLine();
      bracketCnts[i] = new BracketCnt(i, tokens[i]);
    }

    Arrays.sort(bracketCnts);

    StringBuilder sb = new StringBuilder();
    for (BracketCnt bracketCnt : bracketCnts) {
      String token = tokens[bracketCnt.idx];
      sb.append(token);
    }

    bw.write(String.valueOf(score(sb.toString())));

    br.close();
    bw.close();
  }

  private static long score(String token) {
    long ret = 0;
    int openCnt = 0;
    for (int i = 0; i < token.length(); i++) {
      char c = token.charAt(i);

      if (c == '(') {
        openCnt++;
      } else {
        ret += openCnt;
      }
    }

    return ret;
  }

  /*
  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    tokens = new String[n];
    for (int i = 0; i < n; i++) {
      tokens[i] = br.readLine();
    }

    Arrays.sort(tokens, (t1, t2) -> Long.compare(score(t2 + t1), score(t1 + t2)));

    StringBuilder sb = new StringBuilder();
    for (String token : tokens) {
      sb.append(token);
    }

    bw.write(String.valueOf(score(sb.toString())));

    br.close();
    bw.close();
  }
   */

  private static class BracketCnt implements Comparable<BracketCnt> {

    int idx;
    int open;
    int close;

    public BracketCnt(int idx, String token) {
      int open = 0;
      int close = 0;
      for (int i = 0; i < token.length(); i++) {
        char c = token.charAt(i);
        if (c == '(') {
          open++;
        } else {
          close++;
        }
      }

      this.idx = idx;
      this.open = open;
      this.close = close;
    }

    @Override
    public int compareTo(BracketCnt o) {
      return Integer.compare(o.open * this.close, this.open * o.close);
    }
  }
}
