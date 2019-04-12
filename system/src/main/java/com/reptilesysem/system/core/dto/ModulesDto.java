package com.reptilesysem.system.core.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ModulesDto implements Serializable{
    private String mid;
    private String modulesName;
    private String htmlId;
}
