package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = true)
    private Product product;

    private int quantity;

    protected ProductCart() {}

    private ProductCart(Builder builder) {
        this.cartId = builder.cartId;
        this.user = builder.user;
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCart that = (ProductCart) o;
        return quantity == that.quantity && Objects.equals(cartId, that.cartId) && Objects.equals(user, that.user) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, user, product, quantity);
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }


    public static class Builder {
        private Long cartId;
        private User user;
        private Product product;
        private int quantity;

        public Builder setCartId(Long cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(ProductCart productCart) {
            this.cartId = productCart.cartId;
            this.user = productCart.user;
            this.product = productCart.product;
            this.quantity = productCart.quantity;
            return this;
        }

        public ProductCart build() {
            return new ProductCart(this);
        }
    }
}
