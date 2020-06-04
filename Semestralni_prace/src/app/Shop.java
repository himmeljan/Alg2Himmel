/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import compare.ComparatorByName;
import compare.ComparatorByPrize;

import compare.ComparingInterface;
//import java.net.PasswordAuthentication;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Properties;
//import sun.rmi.transport.Transport;
import utils.BinaryWriter;
import utils.ShopInterface;
import utils.TextWriter;
import utils.Writer;

import javax.mail.Session;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
/**
 *
 * @author jan.himmel
*/
public class Shop implements ShopInterface {
    private ArrayList<Beer> beers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private Order order;


    public Shop() {
       this.order  = new Order();
    }

    @Override
    public void load(String beerfile) throws FileNotFoundException, IOException {
        //nacitani scanner
        File beerFile = new File(beerfile);
        try (Scanner sc = new Scanner(beerFile)) {
            
            while (sc.hasNext()) {
                int number = sc.nextInt();
                String name = sc.next();
             //   String style = sc.next();
                double grade = sc.nextDouble();
                double prizePerBottle = sc.nextDouble();
                int nOfBottles = sc.nextInt();
                
                Beer b = new Beer(name,grade, prizePerBottle, nOfBottles);
                
                beers.add(b);
               
            }
        }    
    }
   

    @Override
    public String find(String a) { 
        String answer;
        for (int i = 0; i < beers.size(); i++) {
             if(beers.get(i).getName() == null ? a == null : beers.get(i).getName().equals(a)){
                 return answer = beers.get(i).toString() + beers.get(i).getnOfBottles();
             }
          }
         return answer = "Nic se nenaslo";
        }

    @Override
    public void addBeerToCard(String name, int nOfBottles) {
        
        
        for (int i = 0; i < beers.size(); i++) {
             if(beers.get(i).getName() == null ? name == null : beers.get(i).getName().equals(name)){
                 //pouzivam objednavku, posledni v seznamu
                order.addToCard(beers.get(i), nOfBottles);
             }
             
        }
        
    }
    
    @Override
    public void addBeerToCard(int num, int nOfBottles){
        order.addToCard(beers.get(num-1), nOfBottles);
    }
    
    @Override
    public String ganerateOrderNum(){
       LocalDateTime time=  order.getTimeInOrder();
       
        int year = time.getYear();
        year= year%100;
        int mounth = time.getMonthValue();
        int day =  time.getDayOfMonth();
        int hour = time.getHour();        
        int minute = time.getMinute();
        int second = time.getSecond();        
        
        String nummer = Integer.toString(year) + Integer.toString(mounth) +Integer.toString(day) +
                Integer.toString(hour) +Integer.toString(minute)  + Integer.toString(second);
        
        return nummer;
    }

    
    @Override
    public void finishOrder(String end, String num, String order1) throws IOException {
        if(!order.getCard().isEmpty()){
            orders.add(order);
        }
        Writer w;
        if(end.endsWith(".txt")){
            w = new TextWriter();
        }else if(end.endsWith(".dat")){
           w = new BinaryWriter();
        }else{
            throw new IllegalArgumentException("nepodporovana koncovka souboru");
        }
        w.getOrder(order1,num);
        
    }
/*
    public static void main(String[]args){
        Shop s = new Shop();
        System.out.println(s.ganerateOrderNum());
    }
*/
    @Override
    public void sortByName() {
        Collections.sort(beers, new ComparatorByName());
    }
    /*
    @Override
    public void sortByGrade() {
        Collections.sort(beers);

    }*/
    /**
     * Sorting method (bubble sort concretly)
     *
     * @param array - array of objects
     */
    @Override
    public void sort(ComparingInterface[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].isBigger(array[j])) {
                    ComparingInterface temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
    /**
     * metoda pouziva metodu sort, arraylist transportuje na pole a pak zpatky 
     * @return setrideny arraylist
     * @throws IOException 
     */
    @Override
    public ArrayList<Beer> getComparedResults() throws IOException {
        
        Beer[] res = new Beer[beers.size()];
        for (int i = 0; i < beers.size(); i++) {
            res[i] = beers.get(i);
        }
        sort(res);
        beers = new ArrayList<Beer>();
        for (Beer i : res) {
            beers.add(i);
        }
        
        return beers;
    }
    @Override
    public void sortByPrize() {
        Collections.sort(beers, new ComparatorByPrize());
    }
  

    @Override
    public ArrayList<Beer> getBeers() {
        return beers;
    }

 
    
    @Override
    public void remove(int away) {
        order.remove(away);

    }

    //*
    @Override
    public void loadOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    //*
    @Override
    public void showOrder(int order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newBeer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] showBeers() {
        String []a = new String[beers.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] =Integer.toString(i+1) + ". " + beers.get(i).toString() +beers.get(i).getnOfBottles() +" lahvi";
        }
        
      return a;
    }
    @Override
    public String showCard() {
        if(!order.getCard().isEmpty()){
            String prize = "Cena objednavky je "+order.countPrize();
            String a = order.toString() + prize;
        
            return a;
        }
      return null;  
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public void makeOrder() {
        Order o = new Order();
        orders.add(o);

    }
    
    @Override
    public boolean sendingEmail(String to, String mess) throws AddressException, MessagingException {
        try {
            String from = "m.konis197@gmail.com";

            Properties prop = System.getProperties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");

            Session ses = Session.getDefaultInstance(prop,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("martinkonakTUL@gmail.com", "konak122");
                    }
            });
            
            MimeMessage msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            msg.setSubject("Recipe");
            msg.setText(mess);
            Transport.send(msg);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}



