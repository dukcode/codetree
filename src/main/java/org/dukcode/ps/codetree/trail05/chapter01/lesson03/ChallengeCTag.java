package org.dukcode.ps.codetree.trail05.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-c-tag/description">LINK</a>
 */
public class ChallengeCTag {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static char[][] a;
  private static char[][] b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new char[n][m];
    for (int y = 0; y < n; ++y) {
      String line = br.readLine();
      for (int x = 0; x < m; ++x) {
        a[y][x] = line.charAt(x);
      }
    }

    b = new char[n][m];
    for (int y = 0; y < n; ++y) {
      String line = br.readLine();
      for (int x = 0; x < m; ++x) {
        b[y][x] = line.charAt(x);
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = 0;
    for (int i = 0; i < m; ++i) {
      for (int j = i + 1; j < m; ++j) {
        for (int k = j + 1; k < m; ++k) {
          if (distinguishable(i, j, k)) {
            ret++;
          }
        }
      }
    }

    return ret;
  }

  private static boolean distinguishable(int i, int j, int k) {
    Set<String> groupA = new HashSet<>();
    for (int idx = 0; idx < n; ++idx) {
      groupA.add(String.valueOf(new char[]{a[idx][i], a[idx][j], a[idx][k]}));
    }

    for (int idx = 0; idx < n; ++idx) {
      if (groupA.contains(String.valueOf(new char[]{b[idx][i], b[idx][j], b[idx][k]}))) {
        return false;
      }
    }

    return true;
  }
}
