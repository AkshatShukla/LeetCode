import java.util.*;

public class Test {
    public static List<String> Solution(List<String> pixels) {
        List<String> result = new ArrayList<>();
        if (pixels.isEmpty()) {
            result.add("Ambiguous");
            return result;
        }

        for (String pixel : pixels) {
            if (pixel.length() != 24) {
                result.add("Ambiguous");
                return result;
            } else {
                String redComponent = pixel.substring(0, 8);
                String greenComponent = pixel.substring(8, 16);
                String blueComponent = pixel.substring(16, 24);
                int R = Integer.valueOf(redComponent, 2);
                int G = Integer.valueOf(greenComponent, 2);
                int B = Integer.valueOf(blueComponent, 2);

                double distanceBlack = distanceFromBlack(R, G, B);
                double distanceWhite = distanceFromWhite(R, G, B);
                double distanceRed = distanceFromRed(R, G, B);
                double distanceGreen = distanceFromGreen(R, G, B);
                double distanceBlue = distanceFromBlue(R, G, B);

                Set<Double> setOfValues = new HashSet<>();
                setOfValues.add(distanceBlack);
                setOfValues.add(distanceWhite);
                setOfValues.add(distanceRed);
                setOfValues.add(distanceGreen);
                setOfValues.add(distanceBlue);
                if (setOfValues.size() != 5) {
                    // duplicate values
                    result.add("Ambiguous");
                } else {
                    double mininumDistance = Collections.min(setOfValues);
                    if (mininumDistance == distanceBlack) {
                        result.add("Black");
                    } else if (mininumDistance == distanceWhite) {
                        result.add("White");
                    } else if (mininumDistance == distanceRed) {
                        result.add("Red");
                    } else if (mininumDistance == distanceGreen) {
                        result.add("Green");
                    } else {
                        result.add("Blue");
                    }
                }
                setOfValues.clear();
            }
        }

        return result;
    }

    private static double distanceFromBlack(int R, int G, int B) {
        double a = Math.pow(R, 2);
        double b = Math.pow(G, 2);
        double c = Math.pow(B, 2);
        return Math.sqrt(a + b + c);
    }

    private static double distanceFromWhite(int R, int G, int B) {
        double a = Math.pow(R - 255, 2);
        double b = Math.pow(G - 255, 2);
        double c = Math.pow(B - 255, 2);
        return Math.sqrt(a + b + c);
    }

    private static double distanceFromRed(int R, int G, int B) {
        double a = Math.pow(R - 255, 2);
        double b = Math.pow(G, 2);
        double c = Math.pow(B, 2);
        return Math.sqrt(a + b + c);
    }

    private static double distanceFromGreen(int R, int G, int B) {
        double a = Math.pow(R, 2);
        double b = Math.pow(G - 255, 2);
        double c = Math.pow(B, 2);
        return Math.sqrt(a + b + c);
    }

    private static double distanceFromBlue(int R, int G, int B) {
        double a = Math.pow(R, 2);
        double b = Math.pow(G, 2);
        double c = Math.pow(B - 255, 2);
        return Math.sqrt(a + b + c);
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("101111010110011011100100");
        strings.add("110000010101011111101111");
        strings.add("100110101100111111101101");
        strings.add("010111011010010110000011");
        strings.add("000000001111111111111111");
        strings.add("");
        System.out.println(Solution(strings));
    }
}
