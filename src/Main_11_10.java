import java.util.Arrays;
import java.util.Scanner;

//求数组中出现次数超过数组长度一半的数
//将输入的字符串转为int型的数组
//将数组进行排序进行求解
public class Main_11_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String []strs = str.split(" ");
            int []arr = new int[strs.length];
            for(int i = 0 ; i <arr.length ; i++){
                arr[i] = Integer.valueOf(strs[i]);
            }
            Arrays.sort(arr);
            int mid = arr.length/2;
            if(arr[mid] == arr[mid+1]){
                System.out.println(arr[mid]);
            }else{
                System.out.println(arr[mid-1]);
            }
//            int num = arr[0];
//            int count = 0 ;
//            for(int j = 1; j <arr.length; j++){
//                if(arr[j] == num){
//                    count++;
//                }else if(count>0){
//                    count--;
//                }else{
//                    num = arr[j];
//                }
//            }
//            System.out.println(num);
        }
    }
}
