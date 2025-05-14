package org.dukcode.ps.codetree.trail02.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-code-name/description">LINK</a>
 */
public class IntroCodeName {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = 5;
    Agent[] agents = new Agent[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String codeName = st.nextToken();
      int score = Integer.parseInt(st.nextToken());

      agents[i] = new Agent(codeName, score);
    }

    Arrays.sort(agents);

    bw.write(agents[0].toString());

    br.close();
    bw.close();

  }

  private static class Agent implements Comparable<Agent> {

    private String codeName;
    private int score;

    public Agent(String codeName, int score) {
      this.codeName = codeName;
      this.score = score;
    }

    @Override
    public String toString() {
      return this.codeName + " " + this.score;
    }

    @Override
    public int compareTo(Agent o) {
      return this.score - o.score;
    }
  }
}
