package application;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("src/input/in.csv"))){

            List<Integer> mat = new ArrayList<>();

            for(String line = br.readLine(); line != null; line = br.readLine()){
                String []k = line.split(",");
                for(int i = 0; i < k.length; i++){
                    mat.add(Integer.parseInt(k[i]));
                }
            }

            List<List<Integer>> number = new ArrayList<>();
            int quantity = 1;
            int num = 0;
            
            for (int i = 0; i < mat.size(); i++){
                for (int j = i; j < mat.size() - 1; j++){
                    if(mat.get(i) == mat.get(j + 1)){
                        quantity++;
                        num = mat.get(i);
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
            System.out.println(ex);
        }
        catch (IOException ex){
            System.out.println(ex);

        }
        catch(RuntimeException e){
            System.out.println(e);
        }
    }
}

