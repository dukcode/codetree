package org.dukcode.ps.codetree.trail02.chapter09.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-abc-line-up/description">LINK</a>
 */
public class TestAbcLineUp {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] line;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    line = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      line[i] = st.nextToken().toCharArray()[0] - 'A';
    }

    int cnt = 0;
    for (int target = 0; target < n; ++target) {
      for (int bubble = n - 1; bubble > target; --bubble) {
        if (line[bubble - 1] > line[bubble]) {
          swap(bubble - 1, bubble);
          cnt++;
        }
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static void swap(int i, int j) {
    int tmp = line[i];
    line[i] = line[j];
    line[j] = tmp;
  }
}
