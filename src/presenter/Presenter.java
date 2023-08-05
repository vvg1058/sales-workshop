package presenter;

import model.ETypeProduct;
import model.Product;

import model.ServiceSale;

/**
 * The Presenter class acts as an intermediary between the user interface and
 * the data
 * (model) classes.
 * It handles sales and provides information to be displayed to the user.
 */

public class Presenter {
    private ServiceSale serviceSale;

    /**
     * Void constructor for the Presenter class.
     * It initializes the Presenter object with no ongoing sale.
     */
    public Presenter() {
    }

    /**
     * Adds a new sale with the given product information and quantity.
     * If the sale is successful, it returns the total sale value including
     * discounts and iva.
     * If the product's stock is insufficient or there is an error in creating the
     * sale, it returns 0.0.
     *
     * @param name         The name of the product being sold.
     * @param value        The value of the product being sold.
     * @param stock        The current stock quantity of the product.
     * @param iva          The iva status of the product true if has false
     *                     otherwise.
     * @param ETypeProduct The type of product.
     * @param cant         The quantity of the product being sold.
     * @return The total sale amount if the sale is successful, otherwise returns
     *         0.0.
     */
    public double addSale(String name, double value, int stock, boolean iva, ETypeProduct ETypeProduct, int cant) {
        try {
            /**
             * create a new sale using the serviceSale class and the product and quantity
             */
            this.serviceSale = new ServiceSale(new Product(name, value, stock, iva, ETypeProduct), cant);
            return serviceSale.getSale().getTotalSale();
        } catch (Exception e) {
            /**
             * If there is an error creating the sale, return 0.0.
             */
            return 0.0;
        }

    }

    /**
     * Returns a string representation of the sale details to be displayed.
     * The string includes the total sale value, iva value, and discount value.
     *
     * @return A formatted string with sale details if a sale was created, otherwise
     *         an empty string.
     */
    public String showSale() {

        if (serviceSale != null && serviceSale.getSale() != null) {
            /**
             * Format and return sale details if a sale was created other wise return an
             * empty string.
             */
            return String.format("The total Sale is : %s \n  iva : %s \n discount: %s \n ",
                    serviceSale.getSale().getTotalSale(), serviceSale.getSale().calcIva(),
                    serviceSale.getSale().calcDiscount());
        } else {
            return "";
        }

    }
}
