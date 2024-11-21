package org.example;
import Pages.CSVProcessor;
import Pages.StatisticsCalculator;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, CsvException {

        String inputFile = "E:\\sbs\\Task3\\CSVfile\\Employees.csv"; // Input CSV file
        String outputFile = "Updated_Employees.csv"; // Output CSV file
        double conversionRate = 50.0; // USD to EGP conversion rate


        CSVProcessor processor = new CSVProcessor(inputFile, outputFile, conversionRate);
        processor.processCSV();


        StatisticsCalculator stats = processor.getStatistics();
        System.out.println("Average Age: " + stats.getAverageAge());
        System.out.println("Median Salary (EGP): " + stats.getMedianSalary());
        System.out.println("Male-to-Female Ratio: " + stats.getGenderRatio());

        System.out.println("Processed data written to " + outputFile);
    }


}