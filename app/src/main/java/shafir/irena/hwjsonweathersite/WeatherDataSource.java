package shafir.irena.hwjsonweathersite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by irena on 03/06/2017.
 */

public class WeatherDataSource {

    public interface onWeatherArrivedListener {
        public void onWeatherArrived(Weather w, Exception e);
    }

    public static void getWeather(final onWeatherArrivedListener listener, final String city) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city +"&appid=07967f4c672b666e69ed56b3d2e2d773";
                    String json = StreamIO.readWebSite(url);
                    Weather w = parse(json);
                    listener.onWeatherArrived(w, null);
                } catch (JSONException | IOException e) {
                    listener.onWeatherArrived(null, e);
                }
            }
        });
        service.shutdown();
    }


    public static Weather parse(String json) throws JSONException {

        JSONObject js = new JSONObject(json);
        try {
            JSONObject weatherObject = js;

            String cityName = weatherObject.getString("name");

            JSONObject coordArray = weatherObject.getJSONObject("coord");
            double lon = Double.valueOf(coordArray.getString("lon"));
            double lat = Double.valueOf(coordArray.getString("lat"));

            JSONObject mainArray = weatherObject.getJSONObject("main");
            double temp = Double.valueOf(mainArray.getString("temp"));
            double pressure = Double.valueOf(mainArray.getString("pressure"));
            double humidity = Double.valueOf(mainArray.getString("humidity"));
            double minTemp = Double.valueOf(mainArray.getString("temp_min"));
            double maxTemp = Double.valueOf(mainArray.getString("temp_max"));

            Weather weather = new Weather(cityName, lon, lat, temp, pressure, humidity, minTemp, maxTemp);

            return weather;
        } catch (JSONException e) {
            throw e;
        }
    }










}
