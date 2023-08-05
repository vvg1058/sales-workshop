package model;

/**
 * Represents a prduct with name,vale, stock, Iva and type.
 */
public class Product {
    private String name;
    private double value;
    private int stock;
    private boolean iva;
    private ETypeProduct ETypeProduct;
    public static final int STOCK_MIN = 10;

    /**
     * Void constructor for the Product class.
     */
    public Product() {
    }

    /**
     * Contructor for the product class.
     * 
     * @param name         The name of the product.
     * @param value        The value of the product.
     * @param stock        The available stock of the product.
     * @param iva          The Iva status of the product.
     * @param ETypeProduct The type of product of the product.
     */
    public Product(String name, double value, int stock, boolean iva, ETypeProduct ETypeProduct) {
        this.name = name;
        this.value = value;
        this.stock = stock;
        this.iva = iva;
        this.ETypeProduct = ETypeProduct;
    }

    /**
     * Getter and setters for the atributes of the class.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    public ETypeProduct getETypeProduct() {
        return ETypeProduct;
    }

    public void setETypeProduct(ETypeProduct eTypeProduct) {
        ETypeProduct = eTypeProduct;
    }

    /**
     * Returns a string representation of Product object.
     * 
     * @return A string that coints name, value,stock,iva status and type of the
     *         product.
     */

    @Override
    public String toString() {
        return "Name product " + name + ""
                + "Value " + value + ""
                + "Stock " + stock + ""
                + "iva" + iva + ""
                + "Type Product " + ETypeProduct + ""
                + "Stock min" + STOCK_MIN + "";

    }

}
