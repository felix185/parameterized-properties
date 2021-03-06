package de.riefel.parameterized;

import de.riefel.parameterized.common.logging.ILogger;
import de.riefel.parameterized.common.types.ArraySet;
import de.riefel.parameterized.football.FootballLineMapper;
import de.riefel.parameterized.football.FootballTO;
import de.riefel.parameterized.reader.IDataReader;
import de.riefel.parameterized.reader.factory.DataReaderFactory;
import de.riefel.parameterized.reader.factory.DataReaderType;
import de.riefel.parameterized.weather.WeatherLineMapper;
import de.riefel.parameterized.weather.WeatherTO;

import java.util.Collections;
import java.util.List;

/**
 * The entry class for this test application.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class App {

    private static final ILogger LOG = ILogger.getLogger(App.class);

    /**
     * The main entry method of the app.
     *
     * @param args optional command line arguments
     */
    public static void main(String... args) {
        final IDataReader csvDataReader = DataReaderFactory.getDataReader(DataReaderType.CSV_COMMA_SEPARATED);
        final String pathToFootballData = "src/main/resources/de/riefel/parameterized/football.csv";
        final ArraySet<FootballTO> footballData = csvDataReader.readData(pathToFootballData, new FootballLineMapper());
        if (footballData.isEmpty()) {
            LOG.warn("No football data could be read");
        } else {
            final FootballTO smallestGoalSpread = footballData.get(0);
            LOG.info("Team with smallest goal spread is: {}", smallestGoalSpread.getTeam());
        }
        final String pathToWeatherData = "src/main/resources/de/riefel/parameterized/weather.csv";
        final ArraySet<WeatherTO> weatherData = csvDataReader.readData(pathToWeatherData, new WeatherLineMapper());
        if (weatherData.isEmpty()) {
            LOG.warn("No weather data could be read");
        } else {
            final WeatherTO smallestTempSpread = weatherData.get(0);
            LOG.info("Day with smallest temp spread is: {}", smallestTempSpread.getDay());
        }
    }
}
