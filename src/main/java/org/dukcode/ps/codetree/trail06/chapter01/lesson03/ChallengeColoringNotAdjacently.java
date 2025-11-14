package org.dukcode.ps.codetree.trail06.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-coloring-not-adjacently/description">LINK</a>
 */
public class ChallengeColoringNotAdjacently {

  private static final int MN = -987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Integer>[] adj;
  private static int[] values;
  private static int k;

  private static int[][][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      adj[a].add(b);
      adj[b].add(a);
    }

    values = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = Integer.parseInt(br.readLine());
    }

    k = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[2][k + 1][n];
    for (int selected = 0; selected < 2; selected++) {
      for (int remain = 0; remain <= k; remain++) {
        Arrays.fill(cache[selected][remain], -1);
      }
    }

    return Math.max(dfs(0, -1, 0, k), dfs(0, -1, 1, k));
  }

  private static int dfs(int cur, int parent, int selected, int remain) {

    if (cache[selected][remain][cur] != -1) {
      return cache[selected][remain][cur];
    }

    List<Integer> children = new ArrayList<>();
    for (int next : adj[cur]) {
      if (next == parent) {
        continue;
      }

      children.add(next);
    }

    int toAdd = selected == 1 ? values[cur] : 0;
    int nextRemain = remain - selected;

    if (nextRemain < 0) {
      return MN;
    }

    if (children.isEmpty()) {
      return cache[selected][remain][cur] = toAdd;
    }

    int[] maxSum = new int[nextRemain + 1];
    Arrays.fill(maxSum, MN);
    maxSum[0] = 0;

    for (int child : children) {
      int[] childValues = new int[nextRemain + 1];
      for (int r = 0; r <= nextRemain; r++) {
        if (selected == 1) {
          childValues[r] = dfs(child, cur, 0, r);
        } else {
          childValues[r] = Math.max(dfs(child, cur, 0, r), dfs(child, cur, 1, r));
        }
      }

      int[] newMaxSum = new int[nextRemain + 1];
      Arrays.fill(newMaxSum, MN);

      for (int targetRemain = 0; targetRemain <= nextRemain; targetRemain++) {
        for (int childRemain = 0; childRemain <= targetRemain; childRemain++) {
          int beforeRemain = targetRemain - childRemain;

          if (maxSum[beforeRemain] < 0 || childValues[childRemain] < 0) {
            continue;
          }

          newMaxSum[targetRemain] = Math.max(
              newMaxSum[targetRemain], maxSum[beforeRemain] + childValues[childRemain]);
        }
      }

      maxSum = newMaxSum;
    }

    int ret = toAdd;
    for (int r = 0; r <= nextRemain; r++) {
      ret = Math.max(ret, maxSum[r] + toAdd);
    }

    return cache[selected][remain][cur] = ret;
  }
}

/*

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static final int MAX_K = 10;
    public static final int MAX_N = 100000;

    // 변수 선언:
    public static int n, k;
    public static ArrayList<Integer>[] edges = new ArrayList[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] a = new int[MAX_N + 1];
    public static int[][][] dp = new int[MAX_N + 1][MAX_K + 1][2];
    public static int ans;

    // 1번 노드를 시작으로 DFS를 진행하며 값을 갱신합니다.
    // dp[x][i][j] = x번 노드를 루트로 하는 서브트리에서 i개를 색칠했을 때의 최댓값
    // (j == 1일 경우 x번 노드를 색칠, j == 0일 경우 x번 노드를 색칠하지 않음)
    public static void dfs(int x) {
        // 현재 노드를 최초로 색칠하는 경우에 대한 초기조건입니다.
        dp[x][1][1] = a[x];
        // 현재 노드를 칠하지 않는 경우에 대한 초기조건입니다.
        dp[x][0][0] = 0;

        // 노드 x에 연결된 간선을 살펴보며 전부 방문해줍니다.
        for(int l = 0; l < edges[x].size(); l++) {
            int y = edges[x].get(l);

            // 이미 방문한 정점이라면 스킵해줍니다.
            if(visited[y])
                continue;

            visited[y] = true;
            dfs(y);

            // dp값들을 점화식에 따라 채워줍니다.

            // x번 노드를 색칠하는 경우이며 동시에 총 i개의 노드가 색칠되었기를 바라는 순간이라면
            // 지금까지의 자식들 가지고는 i - j개의 노드를 칠했으며 x번 노드 자체는 색칠이 되어야 하고
            // 자식 노드 y에서 정확히 j개의 노드를 칠하고 동시에 y번 노드 자체는 색칠이 되지 않아야 합니다.
            for(int i = k; i >= 1; i--)
                for(int j = 1; j <= i; j++)
                    dp[x][i][1] = Math.max(dp[x][i][1], dp[x][i - j][1] + dp[y][j][0]);

            // x번 노드를 색칠하지 않은 경우이며 동시에 총 i개의 노드가 색칠되었기를 바라는 순간이라면
            // 지금까지의 자식들 가지고는 i - j개의 노드를 칠했으며 x번 노드 자체는 색칠이 되지 않아야 하고
            // 자식 노드 y에서 정확히 j개의 노드를 칠하고 동시에 y번 노드 자체는 색칠이 되던 말던 상관이 없습니다.
            for(int i = k; i >= 0; i--)
                for(int j = 0; j <= i; j++)
                    dp[x][i][0] = Math.max(dp[x][i][0],
                                           dp[x][i - j][0] +
                                           Math.max(dp[y][j][0], dp[y][j][1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력:
        n = sc.nextInt();

        for(int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        // n - 1개의 간선 정보를 입력받습니다.
        for(int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 간선 정보를 인접리스트에 넣어줍니다.
            edges[x].add(y);
            edges[y].add(x);
        }

        // n개의 노드에 적힌 값을 입력받습니다.
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        k = sc.nextInt();

        // 1번 노드를 시작으로 DFS를 진행하며 값을 갱신합니다.
        visited[1] = true;
        dfs(1);

        // 모든 dp의 값 중 최댓값을 출력합니다.
        // 최대 i개의 노드를 색칠하는 경우를 전부 탐색합니다.
        for(int i = 1; i <= k; i++) {
            ans = Math.max(ans, dp[1][i][0]);
            ans = Math.max(ans, dp[1][i][1]);
        }

        System.out.print(ans);
    }
}
 */