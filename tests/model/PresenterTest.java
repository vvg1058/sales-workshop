package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import presenter.Presenter;

public class PresenterTest {
    static Presenter presenter;

    @Before
    public void setUp() {
        presenter = new Presenter();
    }

    @Test
    public void testAddSale() {
        assertEquals(0.0, presenter.addSale("rice", 4600, 25, false, ETypeProduct.VIVERES, 10), 0.1);
    }

    @Test
    public void testShowSale() {
        presenter.addSale("rice", 4600, 25, false, ETypeProduct.VIVERES, 10);
        assertEquals(String.format("The total Sale is : %s \n  iva : %s \n discount: \n ", 43700.0, 0.0, 2300.0),
                presenter.showSale());
    }

}
