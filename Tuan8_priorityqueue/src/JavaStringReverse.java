import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        Integer length = A.length();
        String rev = "";
        for (int i = length - 1; i >= 0; i--){
            rev = rev + A.charAt(i);
        }
        if (A.equals(rev)){
            System.out.println("Yes");
        } else
            System.out.println("No");
    }
}

