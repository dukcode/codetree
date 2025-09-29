package org.dukcode.ps.codetree.trail05.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-reserve-hotel/description">LINK</a>
 */
public class TestReserveHotel {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Reservation[] reservations;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    reservations = new Reservation[2 * n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      reservations[2 * i] = new Reservation(s, 1);
      reservations[2 * i + 1] = new Reservation(e, -1);
    }

    Arrays.sort(reservations);

    int ans = 0;
    int overlapped = 0;
    for (Reservation r : reservations) {
      overlapped += r.diff;
      ans = Math.max(ans, overlapped);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static class Reservation implements Comparable<Reservation> {

    int day;
    int diff;

    public Reservation(int day, int diff) {
      this.day = day;
      this.diff = diff;
    }

    @Override
    public int compareTo(Reservation o) {
      if (this.day == o.day) {
        return Integer.compare(o.diff, this.diff);
      }
      return Integer.compare(this.day, o.day);
    }
  }
}
