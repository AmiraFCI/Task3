package Pages;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    public class CSVProcessor {
        private final String inputFile;
        private final String outputFile;
        private final double conversionRate;

        private double totalAge = 0;
        private int ageCount = 0;
        private double totalSalary = 0;
        private int salaryCount = 0;
        private int maleCount = 0;
        private int femaleCount = 0;

        private String[][] processedData;
        private int processedRowCount = 0;

        public CSVProcessor(String inputFile, String outputFile, double conversionRate) {
            this.inputFile = inputFile;
            this.outputFile = outputFile;
            this.conversionRate = conversionRate;
        }

        public void processCSV() throws IOException, CsvException {
            // Read input CSV
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            String[][] data = reader.readAll().toArray(new String[0][]);
            reader.close();

            int rowCount = data.length;
            int columnCount = data[0].length;

            processedData = new String[rowCount][columnCount + 1];
            processedData[0] = new String[]{data[0][0], "Age", "Gender", "EGP Salary"};

            processedRowCount = 1;

            for (int i = 1; i < rowCount; i++) {
                if (DataHelper.isDuplicate(data[i], processedData, processedRowCount)) {
                    continue;
                }

                int age = (int) Math.floor(Double.parseDouble(data[i][1]));
                totalAge += age;
                ageCount++;

                double usdSalary = Double.parseDouble(data[i][3]);
                double egpSalary = usdSalary * conversionRate;
                totalSalary += egpSalary;
                salaryCount++;

                String gender = data[i][2];
                if ("Male".equalsIgnoreCase(gender)) {
                    maleCount++;
                } else if ("Female".equalsIgnoreCase(gender)) {
                    femaleCount++;
                }

                processedData[processedRowCount++] = new String[]{
                        data[i][0],
                        String.valueOf(age),
                        gender,
                        String.format("%.2f", egpSalary)
                };
            }

            CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
            for (int i = 0; i < processedRowCount; i++) {
                writer.writeNext(processedData[i]);
            }
            writer.close();
        }

        public StatisticsCalculator getStatistics() {
            return new StatisticsCalculator(totalAge, ageCount, totalSalary, salaryCount, maleCount, femaleCount, processedData, processedRowCount);
        }
    }

