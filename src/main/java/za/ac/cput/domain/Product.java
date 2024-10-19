package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productName;
    private String productDescription;
    private double productPrice;
    private int quantity;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    private byte[] productImage;

    @Enumerated(EnumType.STRING)
    private Categories category;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    protected Product() {}

    private Product(Builder builder) {
        this.id = builder.id;
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
        this.productPrice = builder.productPrice;
        this.productImage = builder.productImage;
        this.category = builder.category;
        this.user = builder.user;
        this.quantity = builder.quantity;
        this.condition = builder.condition;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public Categories getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public int getQuantity() {
        return quantity;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(productPrice, product.productPrice) == 0 && quantity == product.quantity && Objects.equals(productName, product.productName) && Objects.equals(productDescription, product.productDescription) && Objects.deepEquals(productImage, product.productImage) && category == product.category && condition == product.condition && Objects.equals(user, product.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productDescription, productPrice, quantity, Arrays.hashCode(productImage), category, condition, user);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", productImage=" + Arrays.toString(productImage) +
                ", category=" + category +
                ", condition=" + condition +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private long id;
        private String productName;
        private String productDescription;
        private double productPrice;
        private byte[] productImage;
        private Categories category;
        private User user;
        private int quantity;
        private Condition condition;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder setProductImage(byte[] productImage) {
            this.productImage = productImage;
            return this;
        }

        public Builder setCategory(Categories category) {
            this.category = category;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setCondition(Condition condition) {
            this.condition = condition;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Product product) {
            this.id = product.id;
            this.productName = product.productName;
            this.productDescription = product.productDescription;
            this.productPrice = product.productPrice;
            this.productImage = product.productImage;
            this.category = product.category;
            this.user = product.user;
            this.quantity = product.quantity;
            this.condition = product.condition;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
