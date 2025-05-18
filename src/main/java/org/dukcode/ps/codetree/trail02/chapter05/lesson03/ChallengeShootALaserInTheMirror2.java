package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-shoot-a-laser-in-the-mirror-2/description">LINK</a>
 */
public class ChallengeShootALaserInTheMirror2 {

  private static final Map<String, int[]> DELTA = new HashMap<String, int[]>() {{
    put("U", new int[]{-1, 0});
    put("D", new int[]{1, 0});
    put("L", new int[]{0, -1});
    put("R", new int[]{0, 1});
  }};

  private static final Map<String, String> CW = new HashMap<String, String>() {{
    put("U", "R");
    put("D", "L");
    put("L", "U");
    put("R", "D");
  }};


  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      String line = br.readLine();
      for (int x = 0; x < n; x++) {
        int mirror = line.charAt(x) == '/' ? 0 : 1;
        board[y][x] = mirror;
      }
    }

    int start = Integer.parseInt(br.readLine()) - 1;
    int[] startPos = getStartPosition(start);
    int y = startPos[0];
    int x = startPos[1];
    String dir = getDir(start);

    int cnt = 0;
    while (y >= 0 && x >= 0 && y < n && x < n) {
      cnt++;
      int mirror = board[y][x];
      dir = getReflectedDir(dir, mirror);
      y += DELTA.get(dir)[0];
      x += DELTA.get(dir)[1];
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static String getReflectedDir(String dir, int mirror) {
      /*
      0 : / -> RU, LD
      1 : \ -> RD, LU
       */
    if (mirror == 0) {
      switch (dir) {
        case "R":
          return "U";
        case "L":
          return "D";
        case "U":
          return "R";
        default:
          return "L";
      }
    }

    switch (dir) {
      case "R":
        return "D";
      case "L":
        return "U";
      case "U":
        return "L";
      default:
        return "R";
    }
  }

  private static String getDir(int start) {
    int q = start / n;
    switch (q) {
      case 0:
        return "D";
      case 1:
        return "L";
      case 2:
        return "U";
      case 3:
        return "R";
      default:
        return "";
    }
  }

  private static int[] getStartPosition(int start) {
    int y = 0;
    int x = 0;
    String sDir = "R";
    for (int i = 0; i < start; ++i) {
      int ny = y + DELTA.get(sDir)[0];
      int nx = x + DELTA.get(sDir)[1];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        sDir = CW.get(sDir);
        continue;
      }

      y += DELTA.get(sDir)[0];
      x += DELTA.get(sDir)[1];
    }

    return new int[]{y, x};
  }
}


/*
import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 1000;

    public static int n;
    public static char[][] arr = new char[MAX_N][MAX_N];

    public static int startNum;
    public static int x, y, moveDir;

    // 주어진 숫자에 따라
    // 시작 위치와 방향을 구합니다.
    public static void initialize(int num) {
        if(num <= n) {
            x = 0; y = num - 1; moveDir = 0;
        }
        else if(num <= 2 * n) {
            x = num - n - 1; y = n - 1; moveDir = 1;
        }
        else if(num <= 3 * n) {
            x = n - 1; y = n - (num - 2 * n); moveDir = 2;
        }
        else {
            x = n - (num - 3 * n); y = 0; moveDir = 3;
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // (x, y)에서 시작하여 nextDir 방향으로
    // 이동한 이후의 위치를 구합니다.
    public static void move(int nextDir) {
        int[] dx = new int[]{1,  0, -1, 0};
        int[] dy = new int[]{0, -1,  0, 1};

        x += dx[nextDir];
        y += dy[nextDir];
        moveDir = nextDir;
    }

    public static int simulate() {
        int moveNum = 0;
        while(inRange(x, y)) {
            // 0 <-> 1 / 2 <-> 3
            if(arr[x][y] == '/')
                move(moveDir ^ 1);
            // 0 <-> 3 / 1 <-> 2
            else
                move(3 - moveDir);

            moveNum += 1;
        }

        return moveNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String input = sc.next();
            for(int j = 0; j < n; j++)
                arr[i][j] = input.charAt(j);
        }

        startNum = sc.nextInt();

        // 시작 위치와 방향을 구합니다.
        initialize(startNum);
        // (x, y)에서 moveDir 방향으로 시작하여
        // 시뮬레이션을 진행합니다.
        int moveNum = simulate();

        System.out.print(moveNum);
    }
}
 */