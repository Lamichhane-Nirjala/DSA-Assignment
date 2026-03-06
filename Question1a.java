import java.util.*;

public class Question1a {

    public static int maxPoints(int[][] points) {

        if (points.length <= 2)
            return points.length;

        int result = 0;

        for (int i = 0; i < points.length; i++) {

            HashMap<String, Integer> map = new HashMap<>();

            for (int j = i + 1; j < points.length; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int gcd = gcd(dx, dy);

                dx /= gcd;
                dy /= gcd;

                String slope = dx + "," + dy;

                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }

            int max = 0;

            for (int val : map.values()) {
                max = Math.max(max, val);
            }

            result = Math.max(result, max + 1);
        }

        return result;
    }

    // Function to compute GCD
    static int gcd(int a, int b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        int[][] customer_locations = {
                {1,1},
                {3,2},
                {5,3},
                {4,1},
                {2,3},
                {1,4}
        };

        int result = maxPoints(customer_locations);

        System.out.println("Maximum homes on the same straight line: " + result);
    }
}