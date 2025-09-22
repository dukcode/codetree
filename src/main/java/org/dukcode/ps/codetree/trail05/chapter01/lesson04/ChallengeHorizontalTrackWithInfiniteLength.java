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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-horizontal-track-with-infinite-length/description">LINK</a>
 */
public class ChallengeHorizontalTrackWithInfiniteLength {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int t;

  private static int[] x;
  private static int[] v;

  private static TreeSet<Group> groups;
  private static TreeSet<Collision> collisions;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();
    init();
    int ans = solve();

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int solve() {
    while (!collisions.isEmpty()) {
      Collision c = collisions.first();

      if (c.time > t) {
        break;
      }

      Group groupToRemove = c.groupToRemove;
      groups.remove(groupToRemove);
      collisions.remove(c);

      Group afterGroup = groups.higher(groupToRemove);
      if (groups.lower(afterGroup) == null) {
        continue;
      }

      Group beforeGroup = groups.lower(afterGroup);
      removeEvent(beforeGroup, groupToRemove);
      addCollision(beforeGroup, afterGroup);
    }

    return groups.size();
  }

  private static void init() {
    groups = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      groups.add(new Group(x[i], v[i]));
    }

    collisions = new TreeSet<>();
    for (int i = 0; i < n - 1; i++) {
      addCollision(new Group(x[i], v[i]), new Group(x[i + 1], v[i + 1]));
    }
  }

  private static void input() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    x = new int[n];
    v = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void addCollision(Group before, Group after) {
    if (before.v <= after.v) {
      return;
    }

    collisions.add(new Collision(before, after));
  }

  private static void removeEvent(Group before, Group after) {
    if (before.v <= after.v) {
      return;
    }

    collisions.remove(new Collision(before, after));
  }

  private static class Group implements Comparable<Group> {

    int x, v;

    public Group(int x, int v) {
      this.x = x;
      this.v = v;
    }

    @Override
    public int compareTo(Group p) {
      return this.x - p.x;
    }
  }

  private static class Collision implements Comparable<Collision> {

    double time;
    Group groupToRemove;

    public Collision(Group groupToRemove, Group after) {
      this.time = calculateCollisionTime(groupToRemove, after);
      this.groupToRemove = groupToRemove;
    }

    private double calculateCollisionTime(Group before, Group after) {
      return 1.0 * (after.x - before.x) / (before.v - after.v);
    }

    @Override
    public int compareTo(Collision o) {
      if (this.time == o.time) {
        return Integer.compare(this.groupToRemove.x, o.groupToRemove.x);
      }

      return Double.compare(this.time, o.time);
    }
  }

}
