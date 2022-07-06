import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CensusAnalyserTest {
    ReadOperations readOperations = new ReadOperations();
    String fileName = "IndianStateCensusDate";

    @Test
    void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() {
        String filePathRead = "./src/main/resources/IndianStateCensusData.csv";
        try {
            int count = readOperations.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(29, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/IndianStateCensusData.csv";
        try {
            int count = readOperations.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(29, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenStateCensusCSVFile_WhenTypeIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/IndianStateCensusData.csv";
        try {
            int count = readOperations.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(29, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/IndianStateCensusData.csv";
        String delimiter = ".";
        try {
            if (delimiter.equals(","))
                Assertions.assertTrue(readOperations.readDelimiter(filePathRead, delimiter));
            else
                Assertions.assertFalse(readOperations.readDelimiter(filePathRead, delimiter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThrowException() {
        List<String> stringName = new ArrayList<>();
        String filePathRead = "./src/main/resources/IndianStateCensusData.csv";
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("Density");

        try {
            boolean flag = readOperations.readHeader(filePathRead, stringName);
            if (flag)
                Assertions.assertTrue(flag);
            else
                Assertions.assertFalse(flag);
        } catch (IOException | StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }
}
