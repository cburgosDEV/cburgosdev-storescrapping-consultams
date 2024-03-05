package cburgosdev.java.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double lastPrice;
    private Double historicalMinPrice;
    private Double discountRate;
    private Boolean isHistoricalPrice;
    private String detailHref;
    private String imgSrc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Store store;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductDetail> productDetailList = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductRecord> productRecordList = new ArrayList<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getHistoricalMinPrice() {
        return historicalMinPrice;
    }

    public void setHistoricalMinPrice(Double historicalMinPrice) {
        this.historicalMinPrice = historicalMinPrice;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Boolean getIsHistoricalPrice() {
        return isHistoricalPrice;
    }

    public void setIsHistoricalPrice(Boolean isHistoricalPrice) {
        this.isHistoricalPrice = isHistoricalPrice;
    }

    public String getDetailHref() {
        return detailHref;
    }

    public void setDetailHref(String detailHref) {
        this.detailHref = detailHref;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductDetail> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<ProductDetail> productDetailList) {
        this.productDetailList = productDetailList;
    }

    public List<ProductRecord> getProductRecordList() {
        return productRecordList;
    }

    public void setProductRecordList(List<ProductRecord> productRecordList) {
        this.productRecordList = productRecordList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastPrice=" + lastPrice +
                ", historicalMinPrice=" + historicalMinPrice +
                ", detailHref='" + detailHref + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", store=" + store +
                ", brand=" + brand +
                ", productDetailList=" + productDetailList +
                ", productRecordList=" + productRecordList +
                '}';
    }
}