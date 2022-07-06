import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCodeTest {
    ReadOperations readOperations = new ReadOperations();
    String fileName = "StateCode";

    @Test
    void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() {
        String filePathRead = "./src/main/resources/StateCode.csv";
        try {
            int count = readOperations.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(38, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/StateCode.csv";
        try {
            int count = readOperations.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(38, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenStateCensusCSVFile_WhenTypeIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/StateCode.csv";
        try {
            int count = readOperations.readDataCount(filePathRead, fileName);
            Assertions.assertEquals(38, count);
        } catch (StateSensorAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/StateCode.csv";
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
        String filePathRead = "./src/main/resources/StateCode.csv";
        stringName.add("SrNo");
        stringName.add("State");
        stringName.add("Name");
        stringName.add("TN");
        stringName.add("StateCode");

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
