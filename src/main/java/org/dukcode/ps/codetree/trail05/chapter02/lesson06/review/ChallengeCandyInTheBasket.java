package org.dukcode.ps.codetree.trail05.chapter02.lesson06.review;

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

      candies[i] = new Candy(cnt, pos);
    }

    Arrays.sort(candies, Comparator.comparingInt(c -> c.pos));

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = 0;
    int sum = 0;
    int right = 0;
    for (int left = 0; left < n - 1; left++) {
      while (right < n && candies[right].pos - candies[left].pos <= 2 * k) { // 반영 안된 right
        sum += candies[right].cnt;
        right++;
      }

      ret = Math.max(ret, sum);

      sum -= candies[left].cnt;
    }

    return ret;
  }


  private static class Candy {

    int cnt;
    int pos;

    public Candy(int cnt, int pos) {
      this.cnt = cnt;
      this.pos = pos;
    }
  }
}
