import java.util.Scanner;
public class fibonacci{
    public static void main(String[] args) {
        fibo();
    }

    public static void fibo() {
        int n,a=0,b=1,k,stop;
        Scanner scn = new Scanner(System.in);;
        n = scn.nextInt();
        stop = scn.nextInt();

        for(int i =1; i<=n; i++){
            if(a>=stop) break;
            System.out.println(a);

            k=a+b;
            a=b;
            b=k;
        }
    }
}