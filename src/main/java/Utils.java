public class Utils {
    public static boolean isParamValid(String param) {
        return (param.equals(Constants.PARAM_CITY) || param.equals(Constants.PARAM_ID)) ? true : false;
    }

    public static boolean isLineFormat(String line) {
        return (line.equals(Constants.PREFIX_FORMAT_LINE_1) || line.equals(Constants.PREFIX_FORMAT_LINE_2)) ? true : false;
    }

    public static boolean isLineFormatF1(String line) {
        return line.equals(Constants.PREFIX_FORMAT_LINE_1) ? true : false;
    }

public static boolean isLineFormatF2(String line) {
        return line.equals(Constants.PREFIX_FORMAT_LINE_2) ? true : false;
    }

    public static boolean isDataLine(String line){
        return line.startsWith(Constants.PREFIX_DATA_LINE);
    }
}
