package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-consecutive-number/description">LINK</a>
 */
public class ChallengeMaximumConsecutiveNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    TreeSet<Section> sections = new TreeSet<>();
    TreeMap<Integer, Integer> lengthCnt = new TreeMap<>();
    sections.add(new Section(0, n));
    lengthCnt.put(n + 1, 1);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int start = Integer.parseInt(st.nextToken());

      Section before = sections.floor(new Section(start, start));

      if (before != null && before.end >= start) {
        sections.remove(before);
        if (lengthCnt.containsKey(before.length())) {
          if (lengthCnt.get(before.length()) == 1) {
            lengthCnt.remove(before.length());
          } else {
            lengthCnt.put(before.length(), lengthCnt.get(before.length()) - 1);
          }
        }

        Section left = new Section(before.start, start - 1);
        if (left.length() >= 1) {
          sections.add(left);
          lengthCnt.put(left.length(), lengthCnt.getOrDefault(left.length(), 0) + 1);
        }

        Section right = new Section(start + 1, before.end);
        if (right.length() >= 1) {
          sections.add(right);
          lengthCnt.put(right.length(), lengthCnt.getOrDefault(right.length(), 0) + 1);
        }
      }

      if (lengthCnt.isEmpty()) {
        bw.write(String.valueOf(0));
      } else {
        bw.write(String.valueOf(lengthCnt.lastKey()));
      }
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static class Section implements Comparable<Section> {

    int start;
    int end;

    public Section(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Section o) {
      return start == o.start ? Integer.compare(o.end, end) : Integer.compare(start, o.start);
    }

    public int length() {
      return end - start + 1;
    }
  }

}
