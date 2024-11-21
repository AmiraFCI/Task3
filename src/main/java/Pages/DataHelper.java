package Pages;

public class DataHelper {
    public static boolean isDuplicate(String[] row, String[][] processedData, int rowCount) {
        for (int i = 1; i < rowCount; i++) {
            if (isRowEqual(row, processedData[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowEqual(String[] row1, String[] row2) {
        if (row1.length != row2.length) return false;
        for (int i = 0; i < row1.length; i++) {
            if (!row1[i].equals(row2[i])) {
                return false;
            }
        }
        return true;
    }

    public static double calculateMedian(String[][] data, int rowCount) {
        double[] salaries = new double[rowCount - 1];
        for (int i = 1; i < rowCount; i++) {
            salaries[i - 1] = Double.parseDouble(data[i][3]);
        }

        // Sort salaries
        java.util.Arrays.sort(salaries);

        int length = salaries.length;
        if (length % 2 == 0) {
            return (salaries[length / 2 - 1] + salaries[length / 2]) / 2.0;
        } else {
            return salaries[length / 2];
        }
    }
}
