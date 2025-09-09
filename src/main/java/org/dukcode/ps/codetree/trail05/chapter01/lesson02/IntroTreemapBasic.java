package org.dukcode.ps.codetree.trail05.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-treemap-basic/description">LINK</a>
 */
public class IntroTreemapBasic {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Map<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    map = new TreeMap<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "add": {
          int key = Integer.parseInt(st.nextToken());
          int value = Integer.parseInt(st.nextToken());
          map.put(key, value);
          break;
        }
        case "remove": {
          int key = Integer.parseInt(st.nextToken());
          map.remove(key);
          break;
        }
        case "find": {
          int value = map.getOrDefault(Integer.parseInt(st.nextToken()), -1);
          bw.write(value != -1 ? String.valueOf(value) : "None");
          bw.newLine();
          break;
        }
        case "print_list": {
          if (map.isEmpty()) {
            bw.write("None");
            bw.newLine();
            break;
          }

          for (int key : map.keySet()) {
            bw.write(String.valueOf(map.get(key)));
            bw.write(' ');
          }
          bw.newLine();
          break;
        }
        default:
          break;
      }

    }

    br.close();
    bw.close();
  }
}
