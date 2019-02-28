import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length == 3) {
            String filePath = args[0];
            String paramSearch = args[1].toUpperCase();
            String searchValue = args[2].toUpperCase();

            try {

                if (Utils.isParamValid(paramSearch)) {
                    ExtractData extractData = new ExtractData(filePath);

                    switch (paramSearch) {
                        case Constants.PARAM_CITY:
                            extractData.searchPeopleByCity(searchValue);
                            break;
                        case Constants.PARAM_ID:
                            extractData.searchCitiesByPeopleId(searchValue);
                            break;
                    }

                } else {
                    System.out.println("Incorrect arguments");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Amount arguments incorrect");
        }
    }
}
