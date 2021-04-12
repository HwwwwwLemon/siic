package com.hwwwww.siic.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Hwwwww
 * @version JDK 15
 * @date 2021/4/9 15:07
 */
@Data
@AllArgsConstructor
public class Selector implements Serializable {
    private Object label;
    private Object value;
}
