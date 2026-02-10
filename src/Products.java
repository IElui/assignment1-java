public class Products {
    String name;
    double price;   
    boolean refoundable;
    public Products(String name, double price, boolean refoundable) {
        this.name = name;
        this.price = price;
        this.refoundable = refoundable;
    }   
}

class RegularProducts extends Products {
    public RegularProducts(String name, double price, boolean refoundable) {
        super(name, price, refoundable);
    }
}

class Books extends Products {

}

class Clothes extends Products {

}

class Perishable extends Products {
    int expireDate;
}