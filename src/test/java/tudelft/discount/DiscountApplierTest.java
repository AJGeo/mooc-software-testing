package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {
    private ProductDao dao;

    @BeforeEach
    public void initialize() {
        this.dao = Mockito.mock(ProductDao.class);
    }

    @Test
    public void discountApplierTest() {
        Product compABC = new Product("ABC Business", 100, "BUSINESS");
        Product homeMe = new Product("Mr Doo", 100, "HOME");
        Product govHol = new Product("Holland", 100, "GOVERNMENT");

        List<Product> results = Arrays.asList(compABC, homeMe, govHol);
        Mockito.when(dao.all()).thenReturn(results);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(110, compABC.getPrice());
        Assertions.assertEquals(90, homeMe.getPrice());
        Assertions.assertEquals(100, govHol.getPrice());
    }
}
