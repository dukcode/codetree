package org.dukcode.ps.codetree.trail02.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-G-or-H-2/description">LINK</a>
 */
public class ChallengeGOrH2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Pos> positions;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());

    positions = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int pos = Integer.parseInt(st.nextToken());
      String value = st.nextToken();
      positions.add(new Pos(pos, value));
    }

    positions.sort(Comparator.comparingInt(p -> p.pos));

    int maxSize = 0;
    for (int i = 0; i < n; i++) {
      int cntG = 0;
      int cntH = 0;

      Pos fr = positions.get(i);

      for (int j = i; j < n; j++) {

        Pos to = positions.get(j);

        int size = to.pos - fr.pos;
        if (to.value.equals("G")) {
          cntG++;
        } else {
          cntH++;
        }

        if (cntG == cntH || cntG == 0 || cntH == 0) {
          maxSize = Math.max(maxSize, size);
        }
      }

    }

    bw.write(String.valueOf(maxSize));

    br.close();
    bw.close();

  }

  private static class Pos {

    int pos;
    String value;

    public Pos(int pos, String value) {
      this.pos = pos;
      this.value = value;
    }
  }
}
