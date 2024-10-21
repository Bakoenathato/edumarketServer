package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "cartId", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private ProductCart productCart;

    private LocalDate orderDate;

    private double orderTotal;

    protected Orders() {}

    private Orders(Builder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;
        this.productCart = builder.productCart;
        this.orderDate = builder.orderDate;
        this.orderTotal = builder.orderTotal;
    }

    public Long getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public ProductCart getProductCart() {
        return productCart;
    }


    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Double.compare(orderTotal, orders.orderTotal) == 0 && Objects.equals(orderId, orders.orderId) && Objects.equals(user, orders.user) && Objects.equals(productCart, orders.productCart) && Objects.equals(orderDate, orders.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, user, productCart, orderDate, orderTotal);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", productCart=" + productCart +
                ", orderDate=" + orderDate +
                ", orderTotal=" + orderTotal +
                '}';
    }

    public static class Builder {
        private Long orderId;
        private User user;
        private ProductCart productCart;
        private LocalDate orderDate;
        private double orderTotal;


        public Builder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setProductCart(ProductCart productCart) {
            this.productCart = productCart;
            return this;
        }


        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setOrderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }

        public Builder copy(Orders orders) {
            this.orderId = orders.orderId;
            this.user = orders.user;
            this.productCart = orders.productCart;
            this.orderDate = orders.orderDate;
            this.orderTotal = orders.orderTotal;
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }

    }

}
