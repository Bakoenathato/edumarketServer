package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = true)
    private Product product;

    protected Wishlist() {}

    private Wishlist(Builder builder) {
        this.wishlistId = builder.wishlistId;
        this.user = builder.user;
        this.product = builder.product;
    }

    public Long getWishlistId() {
        return wishlistId;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return Objects.equals(wishlistId, wishlist.wishlistId) && Objects.equals(user, wishlist.user) && Objects.equals(product, wishlist.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishlistId, user, product);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlistId=" + wishlistId +
                ", user=" + user +
                ", product=" + product +
                '}';
    }

    public static class Builder {
        private Long wishlistId;
        private User user;
        private Product product;

        public Builder setWishlistId(Long wishlistId) {
            this.wishlistId = wishlistId;
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

        public Builder copy(Wishlist wishlist) {
            this.wishlistId = wishlist.wishlistId;
            this.user = wishlist.user;
            this.product = wishlist.product;
            return this;
        }

        public Wishlist build() {
            return new Wishlist(this);
        }
    }

}
