import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void insertionSort1(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int pos = arr.get(i);
            int j;
            for (j = i - 1; j >= 0 && arr.get(j) > pos; j--) {
                arr.set(j + 1, arr.get(j));
                System.out.println(display(arr));

            }
            arr.set(j + 1, pos);
        }
        System.out.println(display(arr));
    }

    private static String display(List<Integer> newArr) {
        int[] newArr1 = newArr.stream().mapToInt(i -> i).toArray();
        return Arrays.stream(newArr1)
                .mapToObj(j -> String.valueOf(j))
                .collect(Collectors.joining(" "));
    }

}

public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
