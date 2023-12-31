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
        int option = 0;
        int stock = 0;
        int optionTwo;
        int cant = 0;
        double sales = 0;
        double cont = 0;
        int newStock = 0;
        boolean repeat = true;

        Presenter presenter = new Presenter();

        do {
            repeat = false;
            try {
                System.out.println("What product do you want buy?, enter the number option\n");

                System.out.println("1.King soap");
                System.out.println("2.Rice x lb");
                System.out.println("3.Paracetamol x6");
                System.out.println("4.Old par");
                System.out.println("5.Pancake");
                System.out.println("6.Finish shopping");
                option = sc.nextInt();

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
                        System.out.println("Average sales made: " + (acum != 0 ? cont / acum : 0));

                        break;

                    default:
                        System.out.println("Invalid option, please try again.");
                        repeat = true;
                        break;
                }

                // enter cuantify and show the parameteres of the sale
                if (option != 6) {
                    System.out.println("Enter the quantity you wish to buy:");
                    switch (option) {

                        case 1:
                            stock = soap.getStock();
                            cant = sc.nextInt();
                            if (cant <= stock) {
                                sales = presenter.addSale(soap.getName(), soap.getValue(), soap.getStock(),
                                        soap.isIva(), soap.getETypeProduct(), cant);

                                System.out.println("Details of the sale: " + presenter.showSale());

                                System.out.println(
                                        "If you want to confirm the sale enter 1, or enter 2 to cancel the sale");
                                optionTwo = sc.nextInt();
                                switch (optionTwo) {
                                    case 1:

                                        cont = cont + sales;
                                        acum = acum + 1;
                                        newStock = stock - cant;
                                        System.out.println("Confirmed sale");
                                        break;
                                    case 2:
                                        System.out.println("Sale canceled");
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } else {
                                System.out.println("Not enough stock. Available: " + stock);
                            }
                            break;

                        case 2:
                            cant = sc.nextInt();
                            stock = rice.getStock();
                            if (cant <= stock) {
                                sales = presenter.addSale(rice.getName(), rice.getValue(), rice.getStock(),
                                        rice.isIva(), rice.getETypeProduct(), cant);
                                System.out.println("Details of the sale: " + presenter.showSale());
                                System.out.println(
                                        "If you want to confirm the sale enter 1, or enter 2 to cancel the sale");
                                optionTwo = sc.nextInt();
                                switch (optionTwo) {
                                    case 1:
                                        System.out.println("Confirmed sale");
                                        cont = cont + sales;
                                        acum = acum + 1;
                                        newStock = stock - cant;
                                        break;
                                    case 2:
                                        System.out.println("Sale canceled");
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } else {
                                System.out.println("Not enough stock. Available:  + stock");
                                break;
                            }
                            break;
                        case 3:
                            cant = sc.nextInt();
                            stock = medicine.getStock();
                            if (cant <= stock) {
                                sales = presenter.addSale(medicine.getName(), medicine.getValue(), medicine.getStock(),
                                        medicine.isIva(), medicine.getETypeProduct(), cant);
                                System.out.println("Details of the sale: " + presenter.showSale());
                                System.out.println(
                                        "If you want to confirm the sale enter 1, or enter 2 to cancel the sale");
                                optionTwo = sc.nextInt();
                                switch (optionTwo) {
                                    case 1:
                                        System.out.println("Confirmed sale");
                                        cont = cont + sales;
                                        acum = acum + 1;
                                        newStock = stock - cant;
                                        break;
                                    case 2:
                                        System.out.println("Sale canceled");
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } else {
                                System.out.println("Not enough stock. Available: " + stock);
                                break;
                            }
                            break;

                        case 4:
                            cant = sc.nextInt();
                            stock = whisky.getStock();
                            if (cant <= stock) {
                                sales = presenter.addSale(whisky.getName(), whisky.getValue(), whisky.getStock(),
                                        whisky.isIva(), whisky.getETypeProduct(), cant);
                                System.out.println("Details of the sale: " + presenter.showSale());
                                System.out.println(
                                        "If you want to confirm the sale enter 1, or enter 2 to cancel the sale");
                                optionTwo = sc.nextInt();
                                switch (optionTwo) {
                                    case 1:
                                        System.out.println("Confirmed sale");
                                        cont = cont + sales;
                                        acum = acum + 1;
                                        newStock = stock - cant;
                                        break;
                                    case 2:
                                        System.out.println("Sale canceled");
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } else {
                                System.out.println("Not enough stock. Available: " + stock);
                                break;
                            }
                            break;
                        case 5:
                            cant = sc.nextInt();
                            stock = pancake.getStock();
                            if (cant <= stock) {
                                sales = presenter.addSale(pancake.getName(), pancake.getValue(), pancake.getStock(),
                                        pancake.isIva(), pancake.getETypeProduct(), cant);

                                System.out.println("Details of the sale: " + presenter.showSale());

                                System.out.println(
                                        "If you want to confirm the sale enter 1, or enter 2 to cancel the sale");
                                optionTwo = sc.nextInt();
                                switch (optionTwo) {
                                    case 1:
                                        System.out.println("Confirmed sale");
                                        cont = cont + sales;
                                        acum = acum + 1;
                                        newStock = stock - cant;
                                        break;
                                    case 2:
                                        System.out.println("Sale canceled");
                                    default:
                                        System.out.println("Invalid option");
                                        break;
                                }
                            } else {
                                System.out.println("Not enough stock. Available: " + stock);
                                break;
                            }
                            break;
                        case 6:
                            repeat = false;
                            System.out.println("Finish sale");
                            System.out.println("Total amount of the sales made: " + cont);
                            System.out.println("Average sales made: " + (acum != 0 ? cont / acum : 0));
                            break;
                        default:
                            System.out.println("Invalid option, please try again.");
                            repeat = true;
                            break;
                    }

                    System.out.println("If you want do another sale enter 1 or 2 for finish the sale");

                    optionThree = sc.nextInt();
                    switch (optionThree) {
                        case 1:

                            repeat = true;
                            break;

                        case 2:

                            System.out.println("Finish sale");
                            System.out.println("Total amount of the sales made: " + cont);
                            System.out.println("Average sales made: " + (cont / acum));
                            repeat = false;
                            break;
                    }

                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
                repeat = true;
            }
        } while (option != 6 || repeat);
    }
}
