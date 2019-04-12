package com.reptilesysem.system.core.dto;

import com.commen.jpa.support.DataQueryObjectSort;
import lombok.Data;

import java.io.Serializable;

@Data
public class RuleDto
        implements Serializable {
    private String id;
    private String mid;
    private String htmlId;
}
