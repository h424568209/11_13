import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int x = scanner.nextInt();
        int count = 0 ;
        boolean cake = true;
        for(int i = 0 ; i < y ; i++){
            for(int j = 0 ; j < x ; j++){
                if(i*i+j*j<4){
                   count++;
               }

               if(i*i+j*j<4){
                   count++;
               }
               else{
                   if(i*i+j*j == 4){
                       continue;
                   }
                   int m = 0 ;
                   int n = 0 ;
                   for( m = 0 ; m <= i ;m++){
                       for( n = 0 ; n <= j ; n++){
                           if((i-m)*(i-m)+(j-n)*(j-n) == 4){
                               cake = false;
                           }
                       }
                   }
                   if(cake){
                       count++;
                   }
               }
            }
        }
        System.out.println(count);
    }
}
