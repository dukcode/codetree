package org.dukcode.ps.codetree.trail02.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-a-two-way-lock/description">LINK</a>
 */
public class ChallengeATwoWayLock {

  private static final int N = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] key1;
  private static int[] key2;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    key1 = inputKey();
    key2 = inputKey();

    int[] lock = new int[N];
    Arrays.fill(lock, 1);
    lock[N - 1] = 0;

    int cnt = 0;
    do {
      next(lock);
      if (canOpen(lock, key1, key2)) {
        cnt++;
      }

    } while (hasNext(lock));

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static void next(int[] lock) {
    lock[N - 1]++;
    int carry = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (lock[i] + carry > n) {
        lock[i] = 1;
        carry = 1;
        continue;
      }

      lock[i] += carry;
      carry = 0;
    }
  }

  private static boolean canOpen(int[] lock, int[] key1, int[] key2) {
    return hasMaxIntervalUnder2(lock, key1) || hasMaxIntervalUnder2(lock, key2);
  }

  private static boolean hasMaxIntervalUnder2(int[] lock, int[] key) {
    for (int i = 0; i < N; i++) {
      if (interval(lock[i], key[i]) > 2) {
        return false;
      }
    }

    return true;
  }

  private static int interval(int a, int b) {
    if (a < b) {
      return interval(b, a);
    }

    return Math.min(a - b, b + n - a);
  }

  private static boolean hasNext(int[] lock) {
    for (int i = 0; i < N; i++) {
      if (lock[i] != n) {
        return true;
      }
    }

    return false;
  }

  private static int[] inputKey() throws IOException {
    int[] key = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      key[i] = Integer.parseInt(st.nextToken());
    }
    return key;
  }
}
