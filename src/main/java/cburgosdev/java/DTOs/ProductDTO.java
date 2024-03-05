package cburgosdev.java.DTOs;

import cburgosdev.java.Constants.RipleyConstants;
import cburgosdev.java.Models.ProductDetail;
import cburgosdev.java.Models.ProductRecord;

import java.util.List;

public class ProductDTO {
    private int id;
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
    private List<ProductDetail> productDetailList;
    private List<ProductRecord> productRecordList;

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

    public String getFullDetailHref() {
        return RipleyConstants.baseUrl + getDetailHref();
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastPrice=" + lastPrice +
                ", historicalMinPrice=" + historicalMinPrice +
                ", detailHref='" + detailHref + '\'' +
                ", fullDetailHref='" + fullDetailHref + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", store='" + store + '\'' +
                ", brand='" + brand + '\'' +
                ", productDetailList=" + productDetailList +
                ", productRecordList=" + productRecordList +
                '}';
    }
}
