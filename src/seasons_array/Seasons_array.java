/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasons_array;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author estel
 */
public class Seasons_array {

    /**
     * @param args the command line arguments
     */
    
    static enum Months{
         January, Febuary, March, April, May, June, July, August, September, October, November, December
    }
    
    public static void main(String[] args) {
        int[][] temperature = new int[12][];
        temperature[0]=new int[31];
        temperature[1]=new int[28];//февр
        temperature[2]=new int[31];
        temperature[3]=new int[30];
        temperature[4]=new int[31];//май
        temperature[5]=new int[30];
        temperature[6]=new int[31];
        temperature[7]=new int[31];//август
        temperature[8]=new int[30];
        temperature[9]=new int[31];
        temperature[10]=new int[30];//ноябрь
        temperature[11]=new int[31];

        Random random = new Random();
        for (int i=0; i<2; i++){ //янв, фев
            for (int j=0; j<temperature[i].length; j++){
                temperature[i][j]=random.nextInt(5+1-(-20))+(-20);
            }
        }
        for (int i=11; i<12; i++){ //дек
            for (int j=0; j<temperature[i].length; j++){
                temperature[i][j]=random.nextInt(5+1-(-20))+(-20);
            }
        }
        for (int i=2; i<5; i++){ //весна
            for (int j=0; j<temperature[i].length; j++){
                temperature[i][j]=random.nextInt(10+1-(-5))+(-5);
            }
        }
        for (int i=5; i<8; i++){ //лето
            for (int j=0; j<temperature[i].length; j++){
                temperature[i][j]=random.nextInt(30+1-10)+10;
            }
        }
        for (int i=8; i<11; i++){ //осень
            for (int j=0; j<temperature[i].length; j++){
                temperature[i][j]=random.nextInt(10+1-(-10))+(-10);
            }
        }
        //вывод
        for (int i = 0; i<temperature.length;i++){
            System.out.println(Arrays.toString(temperature[i]));
        }
        
        //темп по дате
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате m.d: ");
        String date1 = scanner.nextLine();
        String[] date = date1.split("\\.");//разделение

        int month = Integer.parseInt(date[0])-1;//преобразование из строки в число, -1 нужен чтобы не было нулевых строк [0]
        int day = Integer.parseInt(date[1]);
        System.out.println("On "+ Months.values()[month]+" "+day+" temperature was "+temperature[month][day-1]);
        
        //average temp
        int sum=0;
        for (int i=0; i<temperature.length;i++){
            for (int j=0; j<temperature[i].length; j++){
                sum=sum+temperature[i][j];
            }
            System.out.println("In "+ Months.values()[i] +" average temperature was "+  sum/temperature[i].length);
            sum=0;
        }
        
        //minimum
        String [] minimum = new String[31];
        int min=0;
        int k=0;
        int month2=0;
        int day2=0;
        for (int i=0; i<temperature.length; i++){
            for (int j=0; j<temperature[i].length; j++){
                if (min>temperature[i][j]){
                    min = temperature[i][j];
                    month2 = i+1;
                    day2=j+1;
                    
                    Arrays.fill(minimum,k,k+1, month2+"."+day2);
                    k++;

                }

            }
        }
        
        System.out.println(Arrays.toString(minimum));

        
        
        
        
        
    }
    
}
