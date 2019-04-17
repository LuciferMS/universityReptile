package com.universirtreptile.permisssion.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 * 这里不需要记录用户个人信息，只需要权限信息即可
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String uid;

}
