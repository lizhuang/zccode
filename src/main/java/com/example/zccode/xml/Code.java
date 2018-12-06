package com.example.zccode.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

@XStreamAlias("Code")
@Data
public class Code {

    @XStreamAsAttribute
    private String traceCode;

    @XStreamAsAttribute
    private String packLayer;

    @XStreamAsAttribute
    private String parentCode;
}
