import java.util.*;
import java.math.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Ordenacao03{

     public static void countingSort(int arr[]){
        //int n = arr.length;

        int maior = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maior) {
                maior = arr[i];
            }
        }

        int[] count = new int[maior];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] -1] ++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        // O array de saída que terá os valores ordenados
        int[] back = new int[arr.length];

        for (int i = 0; i < back.length; i++) {
            back[count[arr[i] -1] -1] = arr[i];
            count[arr[i] -1]--;
        }

        // Copia o array de saída(back[]) para o array inicial(arr[])
        for (int i = 0; i < back.length; i++) {
            arr[i] = back[i];
        }

        //printa o array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

    public static void bucketSort(int[] arr) {
          int maxvalor = arr[0];
        for(int j = 1 ; j < arr.length;j++){
           if(arr[j]> maxvalor)
           maxvalor = arr[j];
        }

          int [] balde = new int[maxvalor+1];


          for (int i=0; i < balde.length; i++)
             balde[i]=0;


          for (int i=0; i < arr.length; i++)
             balde[arr[i]]++;


          int outPos=0;
          for (int i=0; i < balde.length; i++) {
             for (int j=0; j<balde[i]; j++) {
                arr[outPos++]=i;
             }
          }

          for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    /* HadixSort*/
    public static int maxValue(int arr[], int n){
            int max = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i] > max)
                    max = arr[i];
            return max;
    }

    public static void countSort(int arr[], int n, int exp){
            int output[] = new int[n];
            int i;
            int count[] = new int[10];
            Arrays.fill(count,0);

            for (i = 0; i < n; i++)
                count[ (arr[i]/exp)%10 ]++;


            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

            for (i = n - 1; i >= 0; i--){
                output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
                count[ (arr[i]/exp)%10 ]--;
            }

            for (i = 0; i < n; i++)
                arr[i] = output[i];
            }


    public static void radixSort(int arr[], int n){
            int max = maxValue(arr, n);

            for (int exp = 1; max/exp > 0; exp *= 10)
                countSort(arr, n, exp);

            for (int i=0; i<n; i++)
                System.out.println(arr[i]);
    }



     public static void main(String[] args){

            String k = args[0];
            Scanner scan = new Scanner(System.in);

            String linha = scan.nextLine();

            int n = Integer.parseInt(linha);
            int x = 0;

            int vetor[] = new int[n];
            for(int i = 0; i < n; i++){
                linha = scan.nextLine();
                x = Integer.parseInt(linha);
                vetor[i] = x;
            }


            switch(k){
                case "1":
                        countingSort(vetor);
                        break;
                case "2":
                        bucketSort(vetor);
                        break;
                case "3":
                        radixSort(vetor, n);
                        break;
                default:
                        System.out.println("Digito inválido");
            }

        }
}

