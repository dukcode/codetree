package org.dukcode.ps.codetree.trail04.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-shortest-run-length-encoding/description">LINK</a>
 */
public class TestShortestRunLengthEncoding {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] line = br.readLine().toCharArray();
    int n = line.length;

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      ans = Math.min(ans, runLengthEncoding(line).length());
      shift(line);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static String runLengthEncoding(char[] line) {
    StringBuilder sb = new StringBuilder();

    int cnt = 0;
    for (int i = 0; i < line.length; ++i) {
      if (i != 0 && line[i - 1] != line[i]) {
        sb.append(line[i - 1]);
        sb.append(cnt);

        cnt = 1;
        continue;
      }

      cnt++;
    }

    sb.append(line[line.length - 1]);
    sb.append(cnt);

    return sb.toString();
  }

  private static void shift(char[] line) {
    int n = line.length;
    char tmp = line[n - 1];
    for (int i = n - 1; i > 0; --i) {
      line[i] = line[i - 1];
    }

    line[0] = tmp;
  }
}
