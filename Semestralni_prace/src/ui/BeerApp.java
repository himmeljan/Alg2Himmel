/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import app.Order;
import app.Shop;
import compare.ComparatorByName;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import utils.ShopInterface;

/**
 *
 * @author jan.himmel
 */
public class BeerApp {

    static Scanner sc = new Scanner(System.in);

    private ShopInterface shop = new Shop();

    public static void main(String[] args) throws IOException, MessagingException {
        BeerApp app = new BeerApp();

        Shop s = new Shop();
        s.load("beerfile.txt");
        app.start();
    }

    /**
     * metoda spousti program a dava uzivateli na vyber, jaky rezim chce zvolit
     *
     * @throws MessagingException
     */
    private void start() throws MessagingException {
        System.out.println("Vítejte, jste zakazník ci prodejce: z/p");
        try {
            while (true) {
                String vote = sc.next();

                if ("p".equals(vote)) {
                    heslo();
                    administrator();
                    break;
                } else if ("z".equals(vote)) {
                    costumer();
                    break;
                } else {
                    System.out.println("Neplatna varianta, zadej znovu");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("neplatna volba");
        } catch (IOException e) {
            System.out.println("neplatny soubor");
        }
    }

    /**
     * metoda spravuje zakaznicke menu
     *
     * @throws IOException
     * @throws MessagingException
     */
    private void costumer() throws IOException, MessagingException {

        System.out.println("*******Vitej v eShopu*******");

        System.out.println("Aktualni nabidka piv: ");
        String beerfile = "beerfile.txt";
        try {
            shop.load(beerfile);
            String[] beers = shop.showBeers();
            show(beers);
        } catch (FileNotFoundException e) {
            System.out.println("file nenalezen");
        }
        boolean isRunning = true;
        while (isRunning) {

            String menu1 = "Vyberte moznost"
                    + "\n 1 - seradit"
                    + "\n 2 - vybrat produkt"
                    + "\n 3 - zobrazit kosik"
                    + "\n 4 - vyndat z kosiku"
                    + "\n 5 - dokocit objednavku";
            System.out.println(menu1);
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    compare();
                    break;
                case 2:
                    choose();
                    break;
                case 3:
                    System.out.println(shop.showCard());

                    break;
                case 4:
                    takeAway();
                    break;
                case 5:
                    finish();

                    System.out.println("Goodbye");
                    isRunning = false;
                    break;
                default:
                    System.out.println("neplatna volba");
                    break;

            }
        }
    }

    /**
     * medota tridi piva podle zvolenych parametr
     *
     * @throws IOException
     */
    private void compare() throws IOException {
        String menu2 = "Jak chcete zbozi seradit?:"
                + "\n 1 - podle ceny"
                + "\n 2 - podle abecedy"
                + "\n 3 - podle stupnu"
                + "\n 4 - vyhledavani";
        System.out.println(menu2);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                shop.sortByPrize();
                String[] beers1 = shop.showBeers();
                show(beers1);
                break;
            case 2:
                shop.sortByName();
                String[] beers2 = shop.showBeers();
                show(beers2);
                break;
            case 3:
                shop.getComparedResults();
                String[] beers3 = shop.showBeers();
                show(beers3);
                break;
            case 4:
                System.out.println("Hledat: ");
                String a = sc.next();
                System.out.println(shop.find(a));

                break;
            default:
                System.out.println("neplatna volba");
                break;

        }
    }

    /**
     * metoda umoznuje uzivateli vybrat pivo z nabidky a umistit jej do kosiku
     *
     * @throws IOException
     */
    private void choose() throws IOException {

        System.out.println("Vyber si piva - zadej cislo a pocet lahvi");
        boolean choose = true;
        while (choose) {

            int beerNum = sc.nextInt();
            int nOfBottles = sc.nextInt();
            int count = shop.getBeers().size();
            if (beerNum <= count && beerNum > 0) {

                System.out.println(shop.addBeerToCard(beerNum, nOfBottles));
                System.out.println("Chcete jeste neco pridat a/n");
                choose = "a".equals(sc.next());
            } else {
                System.out.println("neplatna volba");
            }

        }

    }

    /**
     * metoda vynda zvoene pivo s kosiku
     */
    private void takeAway() {
        System.out.println("co chces vyhodit z kosiku");
        System.out.println(shop.showCard());
        try {
            int away = sc.nextInt();
            shop.remove(away);
            System.out.println(shop.showCard());
        } catch (NoSuchElementException e) {
            System.out.println("Pivo neni v seznamu");
        }

    }

    /**
     * metoda vytvori soubor z objedanvkou a da uzivateli moznost ji poslat na
     * mail pak ukonci program
     *
     * @throws MessagingException
     */
    private void finish() throws MessagingException {
        String card = shop.showCard();
        String num = shop.ganerateOrderNum();
        boolean rightAnswer = true;
        try {
            while (rightAnswer) {
                //System.out.println("binary 1 \ntext 2");
                //int choice = sc.nextInt();
                switch (2) {//choice) {
                    case 1:
                        shop.finishOrder(".dat", num, card);
                        rightAnswer = false;
                        break;
                    case 2:
                        shop.finishOrder(".txt", num, card); //vytvori soubor s objednavkou
                        System.out.println("Zadejte emaila na který chcete poslat objednavku");
                        String mail = sc.next();
                        if(checkMail(mail)){

                            if (shop.sendingEmail(mail, card)) {
                                System.out.println("email odeslan");
                            } else {
                                System.out.println("chyba");
                            }
                            rightAnswer = false;
                        }else{
                            System.out.println("spatne zadany mail");
                        }
                        
                        break;
                    default:
                        System.out.println("nelatna volba");
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println("chyba");
        }
    }
     public static boolean checkMail(String s) {
        Pattern p = Pattern.compile("\"[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\"");
        Matcher m = p.matcher(s);
        return m.find();
    }

    /**
     * administrator
     */
    private void administrator() throws IOException {
        System.out.println("*****rezim administratora*****");
        boolean isRunning = true;
        while (isRunning) {

            String menu1 = "Vyberte moznost"
                    + "\n 1 - zobrazit seznam piv"
                    + "\n 2 - zobrazit objednavky - serazene podle data splatnosti"
                    + "\n 3 - pridat nove pivo"
                    + "\n 4 - pridat litry"
                    + "\n 5 - odstrait z nabidky"
                    + "\n 6 - exit";

            System.out.println(menu1);
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    try {
                        String beerfile = "beerfile.txt";
                        shop.load(beerfile);
                        break;
                    } catch (IOException e) {
                        System.out.println("Spatny soubor");
                    }

                case 2:
                    shop.loadOrders();
                    while (true) {
                        System.out.println("Chcete zobazit objednaku? cislo:");
                        int order = sc.nextInt();
                        if (order > 0) {
                            shop.showOrder(order);
                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
                    shop.showCard();
                    System.out.println("Zadej parametry: jmeno, stupnovitost, cena, pocet lahvi");
                    String name = sc.next();
                    String style = sc.next();
                    double stupnovitot = sc.nextDouble();
                    double prize = sc.nextDouble();
                    shop.newBeer();

                    break;
                case 4:
                    takeAway();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("neplatna volba");
                    break;
            }
        }
    }

    public static boolean heslo() {
        String heslo = "heslo";
        System.out.println("zadejte heslo");
        for (int i = 0; i < 5; i++) {

            String fillHeslo = sc.next();
            if (fillHeslo.equals(heslo)) {
                return true;
            } else {
                System.out.println("Spatne heslo, zkuste to znovu");
                System.out.println("zpet? a/n");
                String s = sc.next();
                if ("a".equals(s)) {
                    return false;
                }
            }
        }
        System.out.println("prilis mnoho pokusu");
        return false;

    }

    /**
     * metoda vypisuje pole
     *
     * @param beers piva
     */
    public static void show(String[] beers) {
        if (beers == null) {
            System.out.println("nic tu neni");
        } else {
            for (String beer : beers) {
                System.out.println(beer);
            }
        }
    }

}
