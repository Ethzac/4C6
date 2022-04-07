package ca.qc.cstj.s08bottomnavigation.core

object Constants {

    const val METEO_REFRESH_INTERVAL = 120000L
    const val API_KEY = "f8e6b810ff036eb583b1f66d186c1097"
    const val WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=${API_KEY}&units=metric"
}