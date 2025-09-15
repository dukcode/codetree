package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-problem-recommendation-system-1/description">LINK</a>
 */
public class ChallengeProblemRecommendationSystem1 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static TreeSet<Problem> problems;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    problems = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      int level = Integer.parseInt(st.nextToken());

      problems.add(new Problem(id, level));
    }

    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "rc": {
          int x = Integer.parseInt(st.nextToken());

          if (x == 1) {
            bw.write(String.valueOf(problems.last()));
          } else if (x == -1) {
            bw.write(String.valueOf(problems.first()));
          }

          bw.newLine();

          break;
        }
        case "ad": {
          int id = Integer.parseInt(st.nextToken());
          int level = Integer.parseInt(st.nextToken());
          problems.add(new Problem(id, level));
          break;
        }
        case "sv": {
          int id = Integer.parseInt(st.nextToken());
          int level = Integer.parseInt(st.nextToken());
          problems.remove(new Problem(id, level));
          break;
        }
        default:
          break;
      }
    }

    br.close();
    bw.close();
  }

  private static class Problem implements Comparable<Problem> {

    int id;
    int level;

    public Problem(int id, int level) {
      this.id = id;
      this.level = level;
    }

    @Override
    public int compareTo(Problem o) {
      return level == o.level ? id - o.id : level - o.level;
    }

    @Override
    public String toString() {
      return String.valueOf(id);
    }
  }
}
