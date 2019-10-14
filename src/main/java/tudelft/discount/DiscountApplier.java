package tudelft.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class DiscountApplier {

    private ProductDao dao;

    public DiscountApplier(ProductDao dao) {
        this.dao = dao;
    }

    public void setNewPrices() {
        for (Product product : dao.all()) {
            if (product.getCategory().equals("BUSINESS")) {
                product.setPrice(roundNumber(product.getPrice() * 1.1));
            }
            if (product.getCategory().equals("HOME")) {
                product.setPrice(roundNumber(product.getPrice() * 0.9));
            }
        }
    }

    private double roundNumber(double value) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
