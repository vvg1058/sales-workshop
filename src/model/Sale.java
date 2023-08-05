package model;

/**
 * Represents a sale of a product with the quantity sold.
 */
public class Sale {
    private int cant;
    private Product product;

    /**
     * Constructs a Sale object with the quantity and product given.
     * 
     * @param product The product being sold.
     * @param cant    The quantity of the prdouct sold.
     */
    public Sale(Product product, int cant) {
        this.product = product;
        this.cant = cant;
    }

    /**
     * 
     * Setter and getters for the attributes of the class.
     */
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCant() {

        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    /**
     * Calculate the discount of the total value of the sale.
     * 
     * @return The discount of the total value of the sale as a double.
     */
    public double calcDiscount() {
        // 5-10 5%, 11-20 10%, 21-50 15% ,>50 30%
        double totalValue = product.getValue() * cant;
        double discount = 0.0;

        if (cant >= 5 || cant <= 10) {
            discount = totalValue * 0.05;
        } else if (cant >= 11 || cant <= 20) {
            discount = totalValue * 0.1;
        } else if (cant >= 21 || cant <= 50) {
            discount = totalValue * 0.15;
        } else if (cant > 50) {
            discount = totalValue * 0.3;
        }
        return discount;
    }

    /**
     * Calculate the iva value based on the type of product and the quantity sold.
     * 
     * @return The iva value as a double.
     */
    public double calcIva() {
        double totalValue = product.getValue() * cant;
        double valIva = 0.0;
        if (product.isIva()) {
            valIva = switch (product.getETypeProduct()) {
                case ASEO -> totalValue * 0.14;
                case RANCHO -> totalValue * 0.19;
                case LICORES -> totalValue * 0.19;
                case VIVERES -> totalValue * 0.08;
                default -> 0.0;
            };

        }
        return valIva;
    }

    /**
     * Calculate the total value, taking ito account the discount and Iva.
     * 
     * @return The total value of teh sale as a double.
     */
    public double getTotalSale() {
        double totalValue = product.getValue() * cant;
        totalValue -= calcDiscount();
        totalValue += calcIva();
        return totalValue;
    }
}
