package cburgosdev.java.Models;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "products_records")
public class ProductRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getFormatedDate() {
        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");

        return newFormat.format(date);
    }

    @Override
    public String toString() {
        return "ProductRecord{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", product=" + product +
                '}';
    }
}
