import java.util.Scanner;

public class Mains {
    /**
     * 求两个数的最大公倍数  辗转相除法
     * 两个数的除数不断除这两个数的余数，当余数为0时候，取当前算式的最大公约数，最大公倍数是两个数的乘积除以最大公约数/
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x= scanner.nextInt();
        int y = scanner.nextInt();
        int t = x % y;
        int sum = x * y;
        while(t!=0){
            x = y;
            y = t;
            t = x%y;
        }
        System.out.println(sum/y);
    }
}
