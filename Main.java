import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String inputFile = "scraped_data.csv";      // input CSV file
        String outputFile = "cleaned_data.csv";     // cleaned output file

        try {
            Reader reader = Files.newBufferedReader(Paths.get(inputFile));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            List<String> headers = new ArrayList<>(csvParser.getHeaderMap().keySet());
            List<CSVRecord> cleanedRecords = new ArrayList<>();
            for (CSVRecord record : csvParser) {
                boolean hasEmpty = false;
                for (String header : headers) {
                    String value = record.get(header).trim();
                    if (value.isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (!hasEmpty) {
                    cleanedRecords.add(record);
                }
            }

            csvParser.close();

            System.out.println("Rows before cleaning: " + (cleanedRecords.size() + (int) (csvParser.getRecordNumber() - cleanedRecords.size())));
            System.out.println("Rows after cleaning: " + cleanedRecords.size());

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers.toArray(new String[0])));

            for (CSVRecord record : cleanedRecords) {
                List<String> row = new ArrayList<>();
                for (String header : headers) {
                    row.add(record.get(header));
                }
                csvPrinter.printRecord(row);
            }

            csvPrinter.flush();
            csvPrinter.close();
            System.out.println("Cleaned CSV saved to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


