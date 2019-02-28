import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExtractDataTest {
    private static String DATA_VALUE_FORMAT_F1;
    private static String DATA_VALUE_FORMAT_F2;
    private static String DATA_PARSE_F1;
    private static String DATA_PARSE_F2;
    private static ExtractData extractData;
    private static String FILE_PATH;
    public static String PREFIX_FORMAT_LINE_1;
    public static String PREFIX_FORMAT_LINE_2;
    public static String PARAM_CITY;
    public static String PARAM_ID;

    /**
     * Init all data for de test
     * @throws FileNotFoundException
     */

    @BeforeClass
    public static void initDataTest() throws FileNotFoundException {
        PREFIX_FORMAT_LINE_1 = "F1";
        PREFIX_FORMAT_LINE_2 = "F2";
        PARAM_CITY = "BARCELONA";
        PARAM_ID = "54808168L";
        DATA_VALUE_FORMAT_F1 = "D Erica Burns,BARCELONA,93654902Y";
        DATA_VALUE_FORMAT_F2 = "D Rhonda Hopkins ; BARCELONA ; 54315871-Z";
        DATA_PARSE_F1 = "Erica Burns,93654902Y";
        DATA_PARSE_F2 = "Rhonda Hopkins,54315871Z";
        FILE_PATH = "src/test/resources/datasource.txt";
        extractData = new ExtractData(FILE_PATH);

    }

    /**
     * Test for throw FileNotFoundException
     * @throws FileNotFoundException
     */

    @Test(expected = FileNotFoundException.class)
    public void testCreateExtracData() throws FileNotFoundException {
        extractData = new ExtractData("E:/data_01.txt");
    }

    /**
     * Test for extrat data by city
     * @throws IOException
     */

    @Test
    public void testSearchPeopleByCity() throws IOException {
        extractData.searchPeopleByCity(PARAM_CITY);
    }

    /**
     * Test for extrat data by id
     * @throws IOException
     */

    @Test
    public void testSearchCitiesByPeopleId() throws IOException {
        extractData.searchCitiesByPeopleId(PARAM_ID);
    }

    /**
     * Test parse date by different format
     * @throws IOException
     */

    @Test
    public void testParseData() {
        String resultParseDataF1 = extractData.parseData(DATA_VALUE_FORMAT_F1, true).toString();
        String resultParseDataF2 = extractData.parseData(DATA_VALUE_FORMAT_F2, false).toString();
        Assert.assertEquals("Parse data from format line",resultParseDataF1,DATA_PARSE_F1);
        Assert.assertEquals("Parse data from format line",resultParseDataF2,DATA_PARSE_F2);
    }

}
