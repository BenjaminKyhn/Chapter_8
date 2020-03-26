public class Exercise_8_21 {
    public static void main(String[] args) {
        String[][] citiesMatrix = {
                {"Copenhagen", "55.68", "12.57"},
                {"New York", "40.71", "74.01"},
                {"Beijing", "39.90", "116.41"},
                {"Tokyo", "35.68", "139.77"},
                {"Honolulu", "21.31", "157.86"},
                {"Rio de Janeiro", "22.91", "43.17"},
                {"Hannover", "52.38", "9.73"},
                {"Prague", "55.08", "14.44"},
                {"Lisbon", "38.72", "9.14"},
                {"Budapest", "47.50", "19.04"},
                {"Athens", "37.98", "23.73"},
                {"Saint Petersburg", "59.93", "30.36"},
        };
        System.out.printf("Shortest total distance is %s with %.2f degrees.\n", citiesMatrix[getMinIndex(getDistanceList(citiesMatrix))][0], getMin(getDistanceList(citiesMatrix)));
    }

    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static double[] getDistanceList(String[][] citiesMatrix){
        double[] distanceList = new double[citiesMatrix.length];
        for (int row = 0; row < citiesMatrix.length; row++) {
            double currentDistance = 0;
            for (int i = 0; i < citiesMatrix.length; i++) {
                currentDistance += distance(Double.parseDouble(citiesMatrix[row][1]), Double.parseDouble(citiesMatrix[row][2]),
                        Double.parseDouble(citiesMatrix[i][1]), Double.parseDouble(citiesMatrix[i][2]));
            }
            distanceList[row] = currentDistance;
        }
        return distanceList;
    }

    public static double getMin(double[] list){
        double min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min)
                min = list[i];
        }
        return min;
    }

    public static int getMinIndex(double[] list){
        double min = list[0];
        int minIndex = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min){
                min = list[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
