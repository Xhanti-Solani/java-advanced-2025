package Chapter8.Exercises;

/**
 * @author Xhanti Solani
 * The product description must contain at least 5 characters.
 * The price must be greater than zero (cannot be zero or negative).
 * Quantity to sell cannot be more than quantity in stock
 * The price increase should be less than R10
 *
 *
 */

public class Product {
    // Attributes
    private String code;
    private String description;
    private double price;
    private int quantityInStock;

    /**
     * Instaciate the {@code Product}
     *
     * @param code Product code
     * @param description Description of the product
     * @param price Product Price
     * @param quantityInStock Quantity
     *
     */

    // Constructor
    public Product(String code, String description, double price, int quantityInStock) {
        setCode(code);
        setDescription(description);
        setPrice(price);
        setQuantityInStock(quantityInStock);
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        if (description.length() < 5) {
            throw new IllegalArgumentException("Description length should be at least 5 digits" +
                                               " but was " + description.length() + "Characters");
        }
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be greater than 0 " +
                    "and your price was " + price);
        }
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    // Methods
    public void sell(int quantityToSell) throws LowStockException {
        if (quantityToSell > 0 && quantityToSell <= quantityInStock) {
            quantityInStock -= quantityToSell;
            System.out.println(quantityToSell + " units sold. Remaining stock: " + quantityInStock);
        } else {
            throw new LowStockException("Not enough stock to complete the sale." + getDescription() +
                                        ".\n Current Quantity in stock: " + getQuantityInStock() +
                                        "\n Requested quantity to sell: " + quantityToSell);
        }
    }

    public void increasePrice(double percentage) {
        if (percentage > 0) {
            double increase = price * (percentage / 100);

            if (increase >= 10) {
                throw new HighPriceIncreaseException(
                        "The price increase on: " + getDescription() +
                                " is too high [" + increase + "]" +
                                "\n The increase should be less than 10.00"
                );
            }

            price += increase; // apply the price increase
            System.out.println("✅ Price increased by " + increase + ". New price: " + price);
        } else {
            System.out.println("❌ Invalid percentage. Price remains unchanged.");
        }
    }


    // Method to display product details
    public void display() {
        System.out.println("Code: " + getCode());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity in stock: " + getQuantityInStock());
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
