/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author jan.himmel
 */
public class Person extends Client {
    
    private String name;

    public Person(String name) {
        
        this.name = name;
       
    }

    
    @Override
    public String toString(){
       //for(int i= 0; i<name.length();i++){
       char[] ova= new char[3];
       ova[0] =name.charAt(name.length()-3);
       ova[1] =name.charAt(name.length()-2);
       ova[2]=name.charAt(name.length()-1);
       String str= new String(ova);
        
          if("ova".equals(str)){
              return  "pani "+ name;
              
          }else{
              
              return  "pan "+ name;
          }
    }
    
 /*   public static void main(String[]args){
        Person a2 = new Person("kovar");
        System.out.println(a2);
         
        
    }*/
}
