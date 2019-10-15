package com.hjx.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {
    private String deptId;
    private String deptName;
    private String dbSource;


}
