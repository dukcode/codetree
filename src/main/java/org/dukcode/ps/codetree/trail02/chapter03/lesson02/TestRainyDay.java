package org.dukcode.ps.codetree.trail02.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-rainy-day/description">LINK</a>
 */
public class TestRainyDay {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Forecast ans = null;
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      String date = st.nextToken();
      String dayOfWeek = st.nextToken();
      String weather = st.nextToken();

      Forecast forecast = new Forecast(date, dayOfWeek, weather);
      if (forecast.isRainy() && forecast.isBefore(ans)) {
        ans = forecast;
      }
    }

    assert ans != null;

    bw.write(ans.toString());

    br.close();
    bw.close();

  }

  private static class Forecast {

    private String date;
    private String dayOfWeek;
    private String weather;

    public Forecast(String date, String dayOfWeek, String weather) {
      this.date = date;
      this.dayOfWeek = dayOfWeek;
      this.weather = weather;
    }

    public boolean isRainy() {
      return this.weather.equals("Rain");
    }

    public boolean isBefore(Forecast forecast) {
      if (forecast == null) {
        return true;
      }
      return this.date.compareTo(forecast.date) < 0;
    }

    @Override
    public String toString() {
      return date + " " + dayOfWeek + " " + weather;
    }

  }
}
