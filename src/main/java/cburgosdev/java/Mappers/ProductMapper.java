package cburgosdev.java.Mappers;

import cburgosdev.java.DTOs.ProductDTO;
import cburgosdev.java.Models.Product;
import cburgosdev.java.Models.ProductDetail;
import cburgosdev.java.Models.ProductRecord;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProductMapper {
    public static ProductDTO modelToDTO(Product product) {
        // Obtén la fecha y hora actual
        Date today = new Date();

        // Crea un objeto Calendar y establece la fecha y hora actual
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        // Resta 24 horas
        calendar.add(Calendar.HOUR_OF_DAY, -24);

        // Obtiene la nueva fecha y hora
        Date yesterday = calendar.getTime();

        List<ProductDetail> productDetailStream = product.getProductDetailList()
                .stream()
                .filter(productDetail -> productDetail.getDate().after(yesterday))
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
        productDTO.setBrand(product.getBrand() == null ? "" : product.getBrand().getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setBrandId(product.getBrand() == null ? 0 : product.getBrand().getId());
        productDTO.setProductDetailList(productDetailStream);
        productDTO.setProductRecordList(product.getProductRecordList());

        return productDTO;
    }

    public static ProductDTO modelToDTOBestDiscounts(Product product) {
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
        productDTO.setBrand(product.getBrand() == null ? "" : product.getBrand().getName());

        return productDTO;
    }
}
