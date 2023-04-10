package com.example.b2b.commonmodule.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods {
    private int gid;

    private String gname;

    private String gremain;

    private String gdetails;

    private int gprice;

    private int types;

}
