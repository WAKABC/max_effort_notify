package com.wak.entities.jd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wuankang
 * @date 2023/11/8 23:52
 * @Description TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeDuplicate implements Serializable {
    private String txno;
    private LocalDateTime createtime;
    private static final long serialVersionUID = 1L;
}