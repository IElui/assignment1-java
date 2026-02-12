import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CashierSystem {
    public static void main(String[] args) {
        CashierSystem cashierSystem = new CashierSystem();

        List<Products> Customer1 = new ArrayList<>();
        Customer1.add(new RegularProducts("Tin of cola", 8.0, 2));
        Customer1.add(new Books("The Little Prince", 100.0, 1));
        Customer1.add(new Clothes("Pair of socks", 30.0, 1, false));
        Customer1.add(new Perishable("Fresh milk", 24.0, 1, LocalDate.of(2026, 2, 5), LocalDate.of(2026, 2, 13)));

        double totalAmount = cashierSystem.calculateTotalAmount(Customer1);
        System.out.println("Total amount: " + totalAmount + " hkd");

        double refundAmount = cashierSystem.calculateRefundAmount(Customer1);
        System.out.println("Refund amount: " + refundAmount + " hkd");
    }

    public double calculateTotalAmount(List<Products> orderItems) {
        double totalAmount = 0.0;
        for (Products product : orderItems) {
            totalAmount += product.getCheckoutPrice() * product.getQuantity();
        }
        return totalAmount;
    }

    public double calculateRefundAmount(List<Products> orderItems) {
        double refundAmount = 0.0;

        for (Products product : orderItems) {
            if (product.canRefund()) {
                refundAmount += product.getCheckoutPrice() * product.getQuantity();
            } else {
                System.out.println(product.getRefundRejectedMessage());
            }
        }

        return refundAmount;
    }
}
