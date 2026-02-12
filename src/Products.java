import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Products {
    private String name;
    private double price;
    private int quantity;
    private boolean refundable;

    public Products(String name, double price, int quantity, boolean refundable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.refundable = refundable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCheckoutPrice() {
        return price;
    }

    public boolean canRefund() {
        return refundable;
    }

    public String getRefundRejectedMessage() {
        return "Sorry, this item is not refoundable";
    }
}

class RegularProducts extends Products {
    public RegularProducts(String name, double price, int quantity) {
        super(name, price, quantity, true);
    }
}

class Books extends Products {
    public Books(String name, double price, int quantity) {
        super(name, price, quantity, true);
    }
}

class Clothes extends Products {
    public Clothes(String name, double price, int quantity, boolean refundable) {
        super(name, price, quantity, refundable);
    }
}

class Perishable extends Products {
    private final LocalDate productionDate;
    private final LocalDate expirationDate;

    public Perishable(String name, double price, int quantity, LocalDate productionDate, LocalDate expirationDate) {
        super(name, price, quantity, false);
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public double getCheckoutPrice() {
        LocalDate checkoutDate = LocalDate.now();
        long elapsedDays = ChronoUnit.DAYS.between(productionDate, checkoutDate);

        // isAfter means the checkoutDate > expirationDate
        // isEqual means the checkoutDate == expirationDate
        if (checkoutDate.isAfter(expirationDate) || checkoutDate.isEqual(expirationDate)) {
            return 0.0;
        }

        long totalDays = ChronoUnit.DAYS.between(productionDate, expirationDate);
        double halfLife = totalDays / 2.0;
        if (elapsedDays >= halfLife) {
            return super.getPrice() * 0.5;
        } else {
            return super.getPrice();
        }
    }

    @Override
    public boolean canRefund() {
        return false;
    }
}
