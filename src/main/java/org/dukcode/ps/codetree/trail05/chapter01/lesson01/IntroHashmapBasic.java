package org.dukcode.ps.codetree.trail05.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-hashmap-basic/description">LINK</a>
 */
public class IntroHashmapBasic {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Map<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    map = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "add":
          map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
          break;
        case "remove":
          map.remove(Integer.parseInt(st.nextToken()));
          break;
        case "find":
          int key = Integer.parseInt(st.nextToken());
          if (map.containsKey(key)) {
            bw.write(String.valueOf(map.get(key)));
            bw.newLine();
          } else {
            bw.write("None");
            bw.newLine();
          }
      }
    }

    br.close();
    bw.close();

  }
}
