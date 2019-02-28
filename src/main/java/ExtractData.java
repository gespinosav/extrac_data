import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class extract data by diferent criteria load from text file
 *
 * @author Gendrys Espinosa Vega
 */

public class ExtractData {
    public FileReader fileReader;
    public BufferedReader bufferedReader;

    public ExtractData(String pathFile) throws FileNotFoundException {
        File fileData = new File(pathFile);
        this.fileReader = new FileReader(fileData);
            this.bufferedReader = new BufferedReader(fileReader);

    }

    /**
     * Get unordered unrepeated list of people and IDs that have been to @param city
     *
     * @param city
     * @return list peoples
     * @throws IOException
     */


    public List<People> searchPeopleByCity(String city) throws IOException {
        String line;
        Map<String, People> peopleMap = new HashMap<>();
        boolean parseFormatter1 = true;
        while ((line = bufferedReader.readLine()) != null) {
            if (Utils.isLineFormat(line)) {
                parseFormatter1 = Utils.isLineFormatF1(line);
            } else if (Utils.isDataLine(line)) {
                People people = parseData(line, parseFormatter1);
                if (people.getCity().getName().equals(city) && !peopleMap.containsKey(people.getId())) {
                    System.out.println(people.toString());
                    peopleMap.put(people.getId(), people);
                }
            }
        }
        return new ArrayList<People>(peopleMap.values());
    }

    /**
     * Get unordered unrepeated list of cities that people with @param id have been to
     *
     * @param id
     * @return list cities
     * @throws IOException
     */

    public List<String> searchCitiesByPeopleId(String id) throws IOException {
        String line;
        Map<String, String> citiesMap = new HashMap<>();
        boolean parseFormatter1 = true;
        while ((line = bufferedReader.readLine()) != null) {
            if (Utils.isLineFormat(line)) {
                parseFormatter1 = Utils.isLineFormatF1(line);
            } else if (Utils.isDataLine(line)) {
                People people = parseData(line, parseFormatter1);
                if (people.getId().equals(id) && !citiesMap.containsKey(people.getCity().getName())) {
                    System.out.println(people.getCity());
                    citiesMap.put(people.getCity().getName(), id);
                }
            }
        }
        return new ArrayList<String>(citiesMap.keySet());

    }

    /**
     * Parse data line by formmat
     *
     * @param line
     * @param parseFormatter1
     * @return People object
     */

    public People parseData(String line, boolean parseFormatter1) {
        String[] data = line.replace(Constants.PREFIX_DATA_LINE, "").trim().split(parseFormatter1 ? Constants.SEPARATOR_COMMA : Constants.SEPARATOR_SEMICOLON);
        String id = data[2].contains("-") ? data[2].replace("-", "") : data[2];
        return new People(data[0], new City(data[1]), id);
    }


}
