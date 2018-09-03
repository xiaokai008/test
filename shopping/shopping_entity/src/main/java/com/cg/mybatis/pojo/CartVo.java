package com.cg.mybatis.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartVo {
    Set<Cart> items = new HashSet<Cart>();  //商品集合
    Float sum;  //商品总计

    public Set<Cart> getItems() {
        return items;
    }

    public void setItems(Set<Cart> items) {
        this.items = items;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "CartVo{" +
                "items=" + items +
                ", sum=" + sum +
                '}';
    }
}
