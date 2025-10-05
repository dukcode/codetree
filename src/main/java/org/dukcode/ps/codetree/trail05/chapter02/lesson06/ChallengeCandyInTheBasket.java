package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-candy-in-the-basket/description">LINK</a>
 */
public class ChallengeCandyInTheBasket {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static Candy[] candies;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    candies = new Candy[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      int pos = Integer.parseInt(st.nextToken());

      candies[i] = new Candy(pos, cnt);
    }

    Arrays.sort(candies, Comparator.comparingInt(c -> c.pos));

    int maxCnt = 0;
    int cnt = 0;
    int j = 0;
    for (int i = 0; i < n - 1; i++) {
      while (j < n && candies[j].pos - candies[i].pos <= 2 * k) {
        cnt += candies[j].cnt;
        j++;
      }

      maxCnt = Math.max(maxCnt, cnt);

      cnt -= candies[i].cnt;
    }

    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();
  }

  private static class Candy {

    int pos;
    int cnt;

    public Candy(int pos, int cnt) {
      this.pos = pos;
      this.cnt = cnt;
    }
  }
}
