import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CensusAnalyser {
    public static void main(String[] args) throws IOException, StateSensorAnalyserException {
        String filePathRead = ".src/main/resources/IndianStateCensusData.csv";
        String fileName = "IndianStateCensusData";
        String delimiter = ",";
        List<String> stringName = new ArrayList<>();
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("DensityPerSqKm");

        ReadOperations readOperations = new ReadOperations();
        int count = readOperations.readDataCount(filePathRead, fileName);
        System.out.println(count);

        readOperations.readDelimiter(filePathRead, delimiter);
        readOperations.readHeader(filePathRead, stringName);
    }
}
