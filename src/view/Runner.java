package view;

import java.util.Scanner;

import model.ETypeProduct;
import model.Product;
import presenter.Presenter;

public class Runner {
    private Presenter presenter;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product soap;
        Product rice;
        Product whisky;
        Product pancake;
        Product medicine;

        soap = new Product("King Soap", 2300, 30, true, ETypeProduct.ASEO);
        rice = new Product("Rice x lb", 4600, 80, false, ETypeProduct.VIVERES);
        medicine = new Product("Paracetamol", 7500, 15, true, ETypeProduct.MEDICINAS);
        whisky = new Product("Old par ron", 180000, 18, true, ETypeProduct.LICORES);
        pancake = new Product("Pancake", 1500, 342, false, ETypeProduct.RANCHO);

        // menu

        int acum = 0;
        int optionThree;
        int option = 06;
        int stock = 0;
        int optionTwo;
        int cant = 0;
        double sales = 0;
        double cont = 0;
        int newStock = 0;
        boolean repeat = true;

        Presenter presenter = new Presenter();
        do {

            System.out.println("What product do you want buy?, enter the number option\n");
            System.out.println("1.King soap");
            System.out.println("2.Rice x lb");
            System.out.println("3.Paracetamol x6");
            System.out.println("4.Old par");
            System.out.println("5.Pancake");
            System.out.println("6.Finish shopping");
            option = sc.nextInt();

            while (option != 0) {
                Product select = new Product();
                repeat = true;
                switch (option) {

                    case 1:

                        select = soap;

                        break;
                    case 2:

                        select = rice;
                        break;
                    case 3:
                        select = medicine;
                        break;
                    case 4:
                        select = whisky;

                        break;
                    case 5:

                        select = pancake;

                        break;
                    case 6:
                        repeat = false;
                        System.out.println("Finish sale");
                        System.out.println("Total amount of the sales made: " + cont);
                        break;

                    default:
                        System.out.println("Invalid option, please try again.");
                        repeat = true;
                        break;
                }

                // enter cuantify and show the parameteres of the sale
                System.out.println("Enter the quantity you wish to buy:");
                repeat = true;
                while (option != 0) {

                    switch (option) {

                        case 1:
                            stock = soap.getStock();
                            cant = sc.nextInt();
                            sales = presenter.addSale(soap.getName(), soap.getValue(), soap.getStock(), soap.isIva(),
                                    soap.getETypeProduct(), cant);

                            System.out.println("Details of the sale: " + presenter.showSale());
                            break;
                        case 2:
                            cant = sc.nextInt();
                            stock = rice.getStock();
                            sales = presenter.addSale(rice.getName(), rice.getValue(), rice.getStock(), rice.isIva(),
                                    rice.getETypeProduct(), cant);
                            System.out.println("Details of the sale: " + presenter.showSale());
                            break;
                        case 3:
                            cant = sc.nextInt();
                            stock = medicine.getStock();
                            sales = presenter.addSale(medicine.getName(), medicine.getValue(), medicine.getStock(),
                                    medicine.isIva(),
                                    medicine.getETypeProduct(), cant);
                            System.out.println("Details of the sale: " + presenter.showSale());
                            break;

                        case 4:
                            cant = sc.nextInt();
                            stock = whisky.getStock();
                            sales = presenter.addSale(whisky.getName(), whisky.getValue(), whisky.getStock(),
                                    whisky.isIva(),
                                    whisky.getETypeProduct(), cant);
                            System.out.println("Details of the sale: " + presenter.showSale());
                            break;
                        case 5:
                            cant = sc.nextInt();
                            stock = pancake.getStock();
                            sales = presenter.addSale(pancake.getName(), pancake.getValue(), pancake.getStock(),
                                    pancake.isIva(),
                                    pancake.getETypeProduct(), cant);

                            System.out.println("Details of the sale: " + presenter.showSale());
                            break;
                        default:
                            repeat = false;

                            // confirm addSale
                    }

                    System.out.println("If you want confirm the sale enter 1 or 2 for cancel the sale");
                    repeat = true;
                    optionTwo = sc.nextInt();
                    while (option != 2) {
                        switch (optionTwo) {
                            case 1:
                                repeat = false;
                                cont = cont + sales;
                                acum = acum + 1;
                                newStock = stock - cant;
                                break;
                            case 2:
                                repeat = false;
                                System.out.println("Sale canceled");
                                break;

                            default:
                                System.out.println("Finish sale");
                                System.out.println("Total amount of the sales made: " + cont);
                                System.out.println("Average sales made: " + (cont / acum));

                        }

                        System.out.println("If you want do another sale enter 1 or 2 for finish the sale");
                        while (option != 2) {
                            repeat = true;
                            optionThree = sc.nextInt();
                            switch (optionThree) {
                                case 1:

                                    repeat = true;

                                case 2:
                                    repeat = false;
                                    System.out.println("Finish sale");
                                    System.out.println("Total amount of the sales made: " + cont);
                                    System.out.println("Average sales made: " + (cont / acum));
                                    break;
                            }
                        }
                    }
                }
            }

        } while (repeat = true);

    }
}