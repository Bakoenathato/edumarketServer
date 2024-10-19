package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private String residence;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    //private Set<Service> services = new HashSet<>();>

    protected User() {

    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
        this.phone = builder.phone;
        this.role = builder.role;
        this.products = builder.products;
        this.residence = builder.residence;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getResidence() {
        return residence;
    }

    public Role getRole() {
        return role;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(residence, user.residence) && role == user.role && Objects.equals(products, user.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, password, email, phone, residence, role, products);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", residence='" + residence + '\'' +
                ", role=" + role +
                ", products=" + products +
                '}';
    }

    public static class Builder {
        private long userId;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private String phone;
        private Role role;
        private String residence;
        private Set<Product> products = new HashSet<>();

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setResidence(String residence) {
            this.residence = residence;
            return this;
        }

        public Builder setProducts(Set<Product> products) {
            this.products = products;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.password = user.password;
            this.email = user.email;
            this.phone = user.phone;
            this.role = user.role;
            this.residence = user.residence;
            this.products = user.products;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
