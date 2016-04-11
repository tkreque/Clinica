/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;


/**
 *
 * @author reque
 */
public interface CSVParser<T>{
    
    public T parseObject(String dados);
    
}
