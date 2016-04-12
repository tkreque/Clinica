/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author reque
 */
public class CSVFile<T>{
    private Scanner in = new Scanner(System.in);
    private CSVParser<T> objectParser;
    private ArrayList<T> array = new ArrayList<>();
       
    public void open(String filename){
        try{
            File file = new File(filename);
            in = new Scanner(file);
            }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }	
    
    public void close(){
        try{
            in.close();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
            
    public ArrayList<T> readObject(){
        try{
            String header = in.nextLine();
            while(in.hasNextLine()){
                String linha = in.nextLine();
                array.add(objectParser.parseObject(linha));
            }
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return array;
    }
    
    public void setParser(CSVParser parser){
       objectParser = parser;
    }

}
