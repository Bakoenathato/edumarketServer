package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class ServiceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceName;
    private double servicePrice;
    private String serviceDescription;

    @Enumerated(EnumType.STRING)
    private ServiceCategory serviceCategory;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    private byte[] serviceImage;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    protected ServiceProduct() {}

    private ServiceProduct(Builder builder) {
        this.serviceId = builder.serviceId;
        this.serviceName = builder.serviceName;
        this.servicePrice = builder.servicePrice;
        this.serviceDescription = builder.serviceDescription;
        this.serviceCategory = builder.serviceCategory;
        this.serviceImage = builder.serviceImage;
        this.user = builder.user;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public byte[] getServiceImage() {
        return serviceImage;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceProduct that = (ServiceProduct) o;
        return Double.compare(servicePrice, that.servicePrice) == 0 && Objects.equals(serviceId, that.serviceId) && Objects.equals(serviceName, that.serviceName) && Objects.equals(serviceDescription, that.serviceDescription) && serviceCategory == that.serviceCategory && Objects.deepEquals(serviceImage, that.serviceImage) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, serviceName, servicePrice, serviceDescription, serviceCategory, Arrays.hashCode(serviceImage), user);
    }

    @Override
    public String toString() {
        return "ServiceProduct{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", servicePrice=" + servicePrice +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", serviceCategory=" + serviceCategory +
                ", serviceImage=" + Arrays.toString(serviceImage) +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private long serviceId;
        private String serviceName;
        private String serviceDescription;
        private double servicePrice;
        private byte[] serviceImage;
        private ServiceCategory serviceCategory;
        private User user;

        public Builder setServiceId(long serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder setServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public Builder setServiceDescription(String serviceDescription) {
            this.serviceDescription = serviceDescription;
            return this;
        }

        public Builder setServicePrice(double servicePrice) {
            this.servicePrice = servicePrice;
            return this;
        }

        public Builder setServiceImage(byte[] serviceImage) {
            this.serviceImage = serviceImage;
            return this;
        }

        public Builder setServiceCategory(ServiceCategory serviceCategory) {
            this.serviceCategory = serviceCategory;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(ServiceProduct serviceProduct) {
            this.serviceId = serviceProduct.serviceId;
            this.serviceName = serviceProduct.serviceName;
            this.servicePrice = serviceProduct.servicePrice;
            this.serviceDescription = serviceProduct.serviceDescription;
            this.serviceCategory = serviceProduct.serviceCategory;
            this.serviceImage = serviceProduct.serviceImage;
            this.user = serviceProduct.user;
            return this;
        }

        public ServiceProduct build() {return new ServiceProduct(this);}

    }
}
