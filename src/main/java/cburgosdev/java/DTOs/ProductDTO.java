package cburgosdev.java.DTOs;

import cburgosdev.java.Constants.RipleyConstants;
import cburgosdev.java.Constants.StoreConstants;
import cburgosdev.java.Models.ProductDetail;
import cburgosdev.java.Models.ProductRecord;

import java.util.List;
import java.util.Objects;

public class ProductDTO {
    private Long id;
    private String name;
    private Double lastPrice;
    private Double historicalMinPrice;
    private Double discountRate;
    private Boolean isHistoricalPrice;
    private String detailHref;
    private String fullDetailHref;
    private String imgSrc;
    private String store;
    private String brand;
    private Long categoryId;
    private Long brandId;
    private Long storeId;
    private List<ProductDetail> productDetailList;
    private List<ProductRecord> productRecordList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFullDetailHref() {
        return Objects.equals(this.getStoreId(), StoreConstants.RIPLEY) ? RipleyConstants.RIPLEY_BASE_URL + getDetailHref() : getDetailHref();
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastPrice=" + lastPrice +
                ", historicalMinPrice=" + historicalMinPrice +
                ", discountRate=" + discountRate +
                ", isHistoricalPrice=" + isHistoricalPrice +
                ", detailHref='" + detailHref + '\'' +
                ", fullDetailHref='" + fullDetailHref + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", store='" + store + '\'' +
                ", brand='" + brand + '\'' +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", storeId=" + storeId +
                ", productDetailList=" + productDetailList +
                ", productRecordList=" + productRecordList +
                '}';
    }
}
