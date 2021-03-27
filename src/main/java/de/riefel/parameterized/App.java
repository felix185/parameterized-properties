package de.riefel.parameterized;

import de.riefel.parameterized.football.FootballLineMapper;
import de.riefel.parameterized.football.FootballTO;
import de.riefel.parameterized.reader.IDataReader;
import de.riefel.parameterized.reader.factory.DataReaderFactory;
import de.riefel.parameterized.reader.factory.DataReaderType;

import java.util.Collections;
import java.util.List;

/**
 * The entry class for this test application.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class App {

    /**
     * The main entry method of the app.
     * @param args optional command line arguments
     */
    public static void main(String...args) {
        final IDataReader csvDataReader = DataReaderFactory.getDataReader(DataReaderType.CSV_COMMA_SEPARATED);
        final String pathToFootballData = "src/main/resources/de/riefel/parameterized/football.csv";
        final List<FootballTO> footballData = csvDataReader.readData(pathToFootballData, new FootballLineMapper());
        if(footballData.isEmpty()) {
            System.out.println("No football data could be read");
        } else {
            Collections.sort(footballData);
            final FootballTO smallestGoalSpread = footballData.get(0);
            System.out.println("Team with smallest goal spread is: " + smallestGoalSpread.getTeam());
        }
    }
}
