package shafir.irena.hwjsonweathersite;

/**
 * Created by irena on 03/06/2017.
 */

public class Weather {
        private String cityName;
        private double lon;
        private double lat;
        private double temp;
        private double pressure;
        private double humidity;
        private double minTemp;
        private double maxTemp;


        public Weather(String cityName, double lon, double lat, double temp, double pressure, double humidity, double minTemp, double maxTemp) {
            this.cityName = cityName;
            this.lon = lon;
            this.lat = lat;
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
            this.minTemp = minTemp;
            this.maxTemp = maxTemp;
        }

        public String getCityName() {
            return cityName;
        }

        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }

        public double getTemp() {
            return temp;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getMinTemp() {
            return minTemp;
        }

        public double getMaxTemp() {
            return maxTemp;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "cityName='" + cityName + '\'' +
                    ", lon=" + lon +
                    ", lat=" + lat +
                    ", temp=" + temp +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", minTemp=" + minTemp +
                    ", maxTemp=" + maxTemp +
                    '}';
        }




}
