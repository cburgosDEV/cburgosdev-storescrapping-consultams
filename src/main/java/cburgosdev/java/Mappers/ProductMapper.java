package cburgosdev.java.Mappers;

import cburgosdev.java.DTOs.ProductDTO;
import cburgosdev.java.Models.Product;
import cburgosdev.java.Models.ProductDetail;
import cburgosdev.java.Models.ProductRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ProductMapper {
    public static ProductDTO modelToDTO(Product product) {
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");

        List<ProductDetail> productDetailStream = product.getProductDetailList()
                .stream()
                .filter(productDetail -> newFormat.format(productDetail.getDate()).equals(newFormat.format(new Date())))
                .toList();

        if(!productDetailStream.isEmpty()) {
            ProductDetail lastProductDetail = productDetailStream.get(productDetailStream.size() - 1);

            ProductRecord lastProductFromDetail = new ProductRecord();
            lastProductFromDetail.setPrice(lastProductDetail.getPriceWithCard() == null ? lastProductDetail.getPrice() : Math.min(lastProductDetail.getPrice(), lastProductDetail.getPriceWithCard()));
            lastProductFromDetail.setDate(lastProductDetail.getDate());

            product.getProductRecordList().add(lastProductFromDetail);
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setLastPrice(product.getLastPrice());
        productDTO.setHistoricalMinPrice(product.getHistoricalMinPrice());
        productDTO.setDiscountRate(product.getDiscountRate());
        productDTO.setIsHistoricalPrice(product.getIsHistoricalPrice());
        productDTO.setDetailHref(product.getDetailHref());
        productDTO.setImgSrc(product.getImgSrc());
        productDTO.setStore(product.getStore().getName());
        productDTO.setBrand(product.getBrand().getName());
        productDTO.setProductDetailList(productDetailStream);
        productDTO.setProductRecordList(product.getProductRecordList());

        return productDTO;
    }
}
