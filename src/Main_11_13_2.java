import java.util.Arrays;
import java.util.Scanner;

public class Main_11_13_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int k = arr[arr.length - 1];
            int[] res = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                res[i] = arr[i];
            }
            if(k>=arr.length||k<=0){
                return;
            }
            Arrays.sort(res);
            int j = 0;
            while (k > 0) {
                System.out.print(res[j++]+" ");
                k--;
            }

        }
    }
}
