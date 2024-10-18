package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    protected Category() {}

    private Category(Builder builder) {
        this.id = builder.id;
        this.categoryName = builder.categoryName;
        this.products = builder.products;
    }

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getId() == category.getId() && Objects.equals(getCategoryName(), category.getCategoryName()) && Objects.equals(getProducts(), category.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryName(), getProducts());
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", products=" + products +
                '}';
    }

    public static class Builder {
        private long id;
        private String categoryName;
        private Set<Product> products = new HashSet<>();

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Builder setProducts(Set<Product> products) {
            this.products = products;
            return this;
        }

        public Builder copy(Category category) {
            this.id = category.id;
            this.categoryName = category.categoryName;
            this.products = category.products;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
