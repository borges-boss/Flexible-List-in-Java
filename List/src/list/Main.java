/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author borge
 */
public class Main {
    
    
    private static List<String> list=new List<String>();
    
    
    public static void main(String [] args){
    
        list.add("Test01");
        list.add("Test02");
        list.addAtStart("Test00");
        list.add("Test03");
        
        System.out.println(list.get(3));
    
    }
    
    
    
    
    
}
