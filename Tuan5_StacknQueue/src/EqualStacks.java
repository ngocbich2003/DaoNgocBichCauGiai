import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;





class Result {
    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        sumStack(s1, h1);
        sumStack(s2, h2);
        sumStack(s3, h3);

        while (true) {

            int sum1 = s1.peek();
            int sum2 = s2.peek();
            int sum3 = s3.peek();

            if(s1.size() == 0 || s2.size() == 0 || s3.size() == 0) {
                return 0;
            }

            if( (sum1 == sum2) && (sum1 == sum3)) {
                return sum1;
            }

            Integer minimum = Math.min(sum1, Math.min(sum2, sum3));

            while(sum1 > minimum) {

                s1.pop();
                sum1 -= h1.remove(0);
            }

            if(s1.isEmpty()) {
                return 0;
            }

            while(sum2 > minimum) {

                s2.pop();
                sum2 -= h2.remove(0);
            }

            if(s2.isEmpty()) {
                return 0;
            }

            while(sum3 > minimum) {

                s3.pop();
                sum3 -= h3.remove(0);
            }

            if(s3.isEmpty()) {
                return 0;
            }
        }

    }

    public static void sumStack(Stack<Integer> s, List<Integer> list) {

        int sum = 0;

        for (int i = list.size() - 1; i >= 0 ; i--) {

            Integer currentElement = list.get(i);
            sum += currentElement;
            s.push(sum);
        }
    }
}


public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
