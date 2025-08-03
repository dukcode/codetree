package org.dukcode.ps.codetree.trail04.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-yutnori-1d/description">LINK</a>
 */
public class ChallengeYutnori1d {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // 턴 수
  private static int m; // 칸 수
  private static int k; // 말 갯수
  private static int[] moves;

  private static int[] positions;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    moves = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      moves[i] = Integer.parseInt(st.nextToken());
    }

    positions = new int[k];
    bw.write(String.valueOf(solve(0)));

    br.close();
    bw.close();

  }

  private static int solve(int idx) {
    if (idx == n) {
      return calcScore();
    }

    int cntArrived = 0;
    int ret = 0;
    for (int piece = 0; piece < k; ++piece) {
      if (positions[piece] >= m - 1) {
        cntArrived++;
        continue;
      }
      positions[piece] += moves[idx];
      ret = Math.max(ret, solve(idx + 1));
      positions[piece] -= moves[idx];
    }

    ret = Math.max(ret, cntArrived);

    return ret;
  }

  private static int calcScore() {
    int ret = 0;
    for (int p : positions) {
      if (p >= m - 1) {
        ret++;
      }
    }

    return ret;
  }
}

