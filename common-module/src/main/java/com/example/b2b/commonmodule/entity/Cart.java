package com.example.b2b.commonmodule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cart")
public class Cart {
    private int id;

    private String goodsname;

    private int number;

    private int price;

    private int goodis;

    private int uid;
}
