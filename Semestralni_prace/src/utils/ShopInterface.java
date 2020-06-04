/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.Beer;
import app.Order;
import compare.ComparingInterface;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 *
 * @author jan.himmel
 */
public interface ShopInterface {
    /**
     * metoda posila email - objednavku
     * @param to email na ktery chceme zpravu poslat
     * @param mess zprava
     * @return
     * @throws AddressException
     * @throws MessagingException 
     */
    public boolean sendingEmail(String to, String mess) throws AddressException, MessagingException;
    /**
     * metoda nacita soubor a uklada jej do arraylistu
     * @param beerfile
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void load(String beerfile)throws FileNotFoundException, IOException ;
    /**
     * metoda vytvori objednavku a pridava ji do kosiku
     * @param name  -nazev piva co chceme pridat
     * @param nOfBottles  -pocet lahvi co chce zakaznik koupit
     */
    public void addBeerToCard(String  name, int nOfBottles);
    /**
     * metoda pridava zvolene pivo do kosiku 
     * @param num zvolene pivo
     * @param nOfBottles pocet lahvi co chce zakazik koupit
     */
    public void addBeerToCard(int num, int nOfBottles);
    
    public ArrayList<Beer> getComparedResults() throws IOException;
    
    public void sort(ComparingInterface[] array); 
    /**
     * metoda ukonci objednavku a vytvori fakturu
     * @param file
     * @param num
     * @param order1
     * @throws java.io.IOException
     */
    public void finishOrder(String file, String num, String order1) throws IOException;
    
    /**
     * metoda zkousi vyhledat nazev piva, nebo aspon shodu o zadanem stringu
     * @param a - cast stringu co obsahuje nazev piva
     * @return vraci vysledek hledani
     */
    public String find(String a);
    
    /**
     * metoda ukazuje uzivateli obsah kosiku
     * @return vraci vypsane piva 
     */
    public String showCard();
    
    public ArrayList<Beer> getBeers();
    
    /**
     * metoda tridi piva podle nazvu
     */
    public void sortByName();
    /**
     * metoda tridi piva podle ceny za lahev
     */
    public void sortByPrize();
    /**
     * metoda odstrani pivo z nabidky
     * @param away
     */
    public void remove(int away);
    /**
     * metoda nacte seznam objednavek
     */
    public void loadOrders();
     /**
     * metoda nacte konretni objednavku
     * @param order - cislo ze seznamu
     */
    public void showOrder(int order);
    /**
     * metoda prida nove pivo do seznamu
     */
    public void newBeer();
     /**
     * metoda vytvori novou objednavku
     * @return 
     */
    public void makeOrder();

    public String[] showBeers();

    //public void sortByGrade();

    public Order getOrder();

    public String ganerateOrderNum();
}
