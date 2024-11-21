package Pages;


    public class StatisticsCalculator {
        private final double totalAge;
        private final int ageCount;
        private final double totalSalary;
        private final int salaryCount;
        private final int maleCount;
        private final int femaleCount;

        private final String[][] processedData;
        private final int processedRowCount;

        public StatisticsCalculator(double totalAge, int ageCount, double totalSalary, int salaryCount, int maleCount, int femaleCount, String[][] processedData, int processedRowCount) {
            this.totalAge = totalAge;
            this.ageCount = ageCount;
            this.totalSalary = totalSalary;
            this.salaryCount = salaryCount;
            this.maleCount = maleCount;
            this.femaleCount = femaleCount;
            this.processedData = processedData;
            this.processedRowCount = processedRowCount;
        }

        public double getAverageAge() {
            return ageCount > 0 ? totalAge / ageCount : 0;
        }

        public double getMedianSalary() {
            return DataHelper.calculateMedian(processedData, processedRowCount);
        }

        public double getGenderRatio() {
            return femaleCount > 0 ? (double) maleCount / femaleCount : 0;
        }
    }


