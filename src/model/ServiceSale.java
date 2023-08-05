package model;

/**
 * Represents a service to handle the creation of a sale based on a product and
 * quantity.
 */
public class ServiceSale {
    private Sale sale;

    /**
     * Constructs a ServiceSale object to create a sale based on the given product
     * and quantity.
     * Throws an exception if the product's stock is insufficient for the sale.
     * 
     * @param product The product for the sale.
     * @param cant    The quantity of the product being sold.
     * @throws Exception Exception If the product's stock is less than the quantity.
     */
    public ServiceSale(Product product, int cant) throws Exception {
        this.sale = new Sale(product, cant);
        if (product.getStock() < cant) {
            throw new Exception("Insufficient stock for the sale");
        }

    }

    /**
     * * Gets the sale created by the ServiceSale object.
     *
     * @return The Sale object representing the sale
     * 
     */

    public Sale getSale() {
        return sale;
    }

    /**
     * Sets the sale to the ServiceSale object.
     *
     * @param sale The Sale object representing the sale to be set.
     * 
     */
    public void setSale(Sale sale) {
        this.sale = sale;
    }

}
