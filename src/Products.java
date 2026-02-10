public class Products {
    String name;
    double price;   
    boolean refoundable;
    public Products(String name, double price, boolean refoundable) {
        this.name = name;
        this.price = price;
        this.refoundable = refoundable;
    }  
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean isRefoundable() {
        return refoundable;
    }
    public void refoundableStatus() {
    }
}

class RegularProducts extends Products {
    public RegularProducts(String name, double price, boolean refoundable) {
        super(name, price, refoundable);
    }
}

class Books extends Products {
    public Books(String name, double price, boolean refoundable) {
        super(name, price, refoundable);
    }
}

class Clothes extends Products {
    public Clothes(String name, double price, boolean refoundable) {
        super(name, price, refoundable);
    }
}

class Perishable extends Products {
    String expireDate;
    public Perishable(String name, double price, boolean refoundable, String expireDate) {
        super(name, price, refoundable);
        this.expireDate = expireDate;
    }
    public String getExpireDate() {
        return expireDate;
    }
}