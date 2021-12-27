package edu.dl.project01.domain.item;

import edu.dl.project01.domain.Category;
import edu.dl.project01.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {
    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private String type;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public void addStock(int quantity){
        this.stockQuantity+=quantity;
    }
    public void removeStock(int quantity){
        int restQuantity = this.stockQuantity - quantity;
        if(restQuantity<0){
            throw new NotEnoughStockException("예외 : 제고가 충분하지 않음");
        }
        this.stockQuantity = restQuantity;
    }
}
