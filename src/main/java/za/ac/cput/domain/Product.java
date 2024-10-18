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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    private byte[] productImage;

//    @OneToMany(mappedBy = "product")
//    private List<Category> categories;

    @Enumerated(EnumType.STRING)
    private Categories category;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getId() == product.getId() && Double.compare(getProductPrice(), product.getProductPrice()) == 0 && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getProductDescription(), product.getProductDescription()) && Objects.deepEquals(getProductImage(), product.getProductImage()) && getCategory() == product.getCategory() && Objects.equals(getUser(), product.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getProductDescription(), getProductPrice(), Arrays.hashCode(getProductImage()), getCategory(), getUser());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productImage=" + Arrays.toString(productImage) +
                ", category=" + category +
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
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
