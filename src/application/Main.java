package application;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        try(BufferedReader buffRead = new BufferedReader(new FileReader("src/input/in.csv"))){
            int []mat = {1, 2, 3, 4, 1, 2, 4, 1, 2, 6, 7, 8, 10, 9, 1, 2, 10};
            List<List<Integer>> number = new ArrayList<>();
            int quantity = 1;
            int num = 0;
            
            for (int i = 0; i < mat.length; i++){
                for (int j = i; j < mat.length - 1; j++){
                    if(mat[i] == mat[j + 1]){
                        quantity++;
                        num = mat[i];
                    }
                }

                if(number.size() == 0)  number.add(new ArrayList<>(Arrays.asList(num, quantity)));
                else{ 
                    int flag = 0;
                    for (List<Integer> x : number){

                        if(x.get(0) == num) flag++;
                    }
                    if(flag == 0) {
                        number.add(new ArrayList<>(Arrays.asList(num, quantity)));
                        quantity = 1;
                    }
                }
                quantity = 1;
            }

            for(List<Integer> x : number) {
                System.out.println("Numero: " + x.get(0) + ", Quantidade: " + x.get(1));
            }
        }
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());

        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}

