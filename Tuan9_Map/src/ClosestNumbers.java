import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Collections.sort(arr);
        int min =Integer.MAX_VALUE;
        for(int i=1;i<arr.size() ;i++){
            if((arr.get(i)-arr.get(i-1))<min){
                min=arr.get(i)-arr.get(i-1);
            }
        }
        for(int i=1;i<arr.size() ;i++){
            if((arr.get(i)-arr.get(i-1))==min){
                ans.add(arr.get(i-1));
                ans.add(arr.get(i));
            }
        }
        return ans;
    }

}

public class ClosestNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
