package com.universirtreptile.permisssion.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 角色
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    private String rid;

    private String roleName;

    private List<Permission> permissions;
}
