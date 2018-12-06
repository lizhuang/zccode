package com.example.zccode.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@XStreamAlias("Document")
public class FactorySalesXS implements SaltXMLModel{

    public FactorySalesXS(){
        this.xmlns = "http://www.w3.org/2001/XMLSchema-instance";
        this.xsi = "工厂出库FactorySales.xsd";
        this.license = "license";
    }

    @XStreamAlias("xmlns:xsi")
    @XStreamAsAttribute
    private String xmlns;

    @XStreamAlias("xsi:noNamespaceSchemaLocation")
    @XStreamAsAttribute
    private String xsi;

    @XStreamAlias("License")
    @XStreamAsAttribute
    private String license;

    @XStreamAlias("Events")
    private  Events events;

    @Data
    public static class Events{
        @XStreamAsAttribute
        @XStreamAlias("version")
        private String version = "3.0";

        @XStreamAlias("Event")
        private Event event;
        @Data
        public  static class Event{
            @XStreamAsAttribute
            @XStreamAlias("name")
            private String name = "FactorySales";

            @XStreamAlias("Relation")
            private Relation relation;

            @Data
            public static class Relation{
                @XStreamAsAttribute
                @XStreamAlias("toCompanyCode")
                private String toCompanyCode;

                @XStreamAsAttribute
                @XStreamAlias("saleDate")
                @XStreamConverter(value=DateUtil.class)
                private Date saleDate;

                @XStreamAlias("Batch")
                private Batch batch;
            }
        }
    }

    @Data
    public static class Batch{
        @XStreamAsAttribute
        @XStreamAlias("batchCode")
        private String batchCode;

        @XStreamAsAttribute
        @XStreamAlias("productCode")
        private String productCode;

        @XStreamAsAttribute
        @XStreamAlias("packRule")
        private String packRule;

        @XStreamAsAttribute
        @XStreamAlias("Codes")
        private List<Code> codes;
        @Data
        public static class Codes{
            @XStreamAsAttribute
            @XStreamAlias("Code")
            private Code code;


        }



    }


}
