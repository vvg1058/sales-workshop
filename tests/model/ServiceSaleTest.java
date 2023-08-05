package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Before;

public class ServiceSaleTest {

    private ServiceSale serviceSale;

    Product rice;
    Product soap;
    Sale sale1;
    Sale sale2;

    @Before
    public void setup() {
        rice = new Product("king soap", 4600, 25, false, ETypeProduct.VIVERES);
        soap = new Product("King soap", 2300, 12, true, ETypeProduct.ASEO);

    }

    @Test
    public void enoughStock() {
        try {

            serviceSale = new ServiceSale(rice, 15);
            sale1 = serviceSale.getSale();
            assertEquals("Rice", sale1.getProduct().getName());
            assertEquals(25, rice.getStock());
            assertEquals(15, sale1.getCant());
        } catch (Exception e) {

        }
    }

    @Test
    public void insufficientStock() {
        try {
            serviceSale = new ServiceSale(soap, 15);
            sale2 = serviceSale.getSale();
            fail("Expected exception");
        } catch (Exception e) {
            assertEquals("Insufficient stock for the sale", e.getMessage());
            assertEquals(12, soap.getStock());

        }
    }

    @Test
    public void invalidStockWithNegative() {
        try {
            serviceSale = new ServiceSale(rice, -4);
            sale1 = serviceSale.getSale();

        } catch (Exception e) {
            assertEquals("Invalid amount need to be positive", e.getMessage());

        }
    }

    @Test
    public void invalidStockWithZero() {
        try {
            serviceSale = new ServiceSale(soap, 0);
            sale1 = serviceSale.getSale();

        } catch (Exception e) {
            assertEquals("Invalid amount ", e.getMessage());

        }
    }

}
