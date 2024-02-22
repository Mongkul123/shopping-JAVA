// DiscountRate interface
interface DiscountRate {
  double getServiceDiscountRate(String type);
  double getProductDiscountRate(String type);
}

// Sale class
class Sale {
  private Customer customer;
  private double totalPrice;

  public Sale(Customer customer, double totalPrice) {
      this.customer = customer;
      this.totalPrice = totalPrice;
  }

  public double getDiscountedPrice() {
      double discountRate = customer.getServiceDiscountRate();
      return totalPrice - (totalPrice * discountRate);
  }
}

// Customer class
class Customer implements DiscountRate {
  private String type;

  public Customer(String type) {
      this.type = type;
  }

  public double getServiceDiscountRate() {
      switch (type) {
          case "Premium":
              return 0.2; // 20% discount
          case "Gold":
              return 0.15; // 15% discount
          case "Silver":
              return 0.1; // 10% discount
          default:
              return 0.0; // 0% discount for Normal
      }
  }

  public double getProductDiscountRate() {
      switch (type) {
          case "Premium":
          case "Gold":
          case "Silver":
              return 0.1; // 10% discount
          default:
              return 0.0; // 0% discount for Normal
      }
  }

  @Override
  public double getServiceDiscountRate(String type) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getServiceDiscountRate'");
  }

  @Override
  public double getProductDiscountRate(String type) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getProductDiscountRate'");
  }
}

// Testing the classes
public class shopping {
  public static void main(String[] args) {
      Customer premiumCustomer = new Customer("Premium");
      Sale sale1 = new Sale(premiumCustomer, 100.0);
      System.out.println("Discounted Price: " + sale1.getDiscountedPrice());

      Customer normalCustomer = new Customer("Normal");
      Sale sale2 = new Sale(normalCustomer, 100.0);
      System.out.println("Discounted Price: " + sale2.getDiscountedPrice());
  }
}