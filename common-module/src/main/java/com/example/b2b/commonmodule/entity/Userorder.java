package com.example.b2b.commonmodule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userorder")
public class Userorder {

    private int gid;

    private String goodsname;

    private int number;


    private int price;


    private String time;

    private int uid;


}
