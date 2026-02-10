public class CashierSystem {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    public double calculateTotalPrice(Products[] products) {
        double totalPrice = 0.0;
        for (Products product : products) {
            // Check the item is perishable and its expire date
            if (Perishable.class.isInstance(product)) {
                Perishable perishableProduct = (Perishable) product;
                if (perishableProduct.getExpireDate() < 7) {
                    System.out.println("Warning: " + perishableProduct.getName() + " is about to expire!");
                }
                
            }
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    public double calculateRefundAmount(Products product) {
        if (product.isRefoundable()) {
            return product.getPrice();
        } else {
            System.out.println("This product is not refundable.");
            return 0.0;
        }
    }
}
