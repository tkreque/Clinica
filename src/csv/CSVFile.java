/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import paciente.PacienteParser;

/**
 *
 * @author reque
 */
public class CSVFile<T> implements CSVParser<T>{
    private Scanner in = new Scanner(System.in);
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
                array.add(parseObject(linha));
            }
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return array;
    }        
    
    @Override
    public T parseObject(String dado){
        String[] array = dado.split(";");
        PacienteParser p = new PacienteParser();
        return (T) p.retornaPaciente(array[1],array[0],LocalDate.parse(array[2]));      
    }
}
