package com.example.zccode.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@XStreamAlias("Document")
public class BatchActiveSC implements SaltXMLModel{

    public BatchActiveSC(){
        this.xmlns = "http://www.w3.org/2001/XMLSchema-instance";
        this.xsi = "批次激活XML Schema-3.0.xsd";
        this.license = "License";
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
    private Events events;

    @Data
    public static class Events{
        @XStreamAsAttribute
        @XStreamAlias("version")
        private String version;

        @XStreamAlias("Event")
        private Event event;
        @Data
        public static class Event{
            @XStreamAsAttribute
            @XStreamAlias("name")
            private String name;

            @XStreamAlias("Relation")
            private Relation relation;

            @Data
            public static class Relation{
                @XStreamAsAttribute
                @XStreamAlias("productCode")
                private String productCode;

                @XStreamAsAttribute
                @XStreamAlias("packRule")
                private String packRule;

                @XStreamAsAttribute
                @XStreamAlias("packSpec")
                private String packSpec;


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
        @XStreamAlias("productDate")
        @XStreamConverter(value=DateUtil.class)
        private Date productDate;

        @XStreamAsAttribute
        @XStreamAlias("validityDate")
        @XStreamConverter(value=DateUtil.class)
        private Date validityDate;

        @XStreamAsAttribute
        @XStreamAlias("productionBase")
        private String productionBase;

        @XStreamAsAttribute
        @XStreamAlias("workShop")
        private String workShop;

        @XStreamAsAttribute
        @XStreamAlias("productLine")
        private String productLine;

        @XStreamAsAttribute
        @XStreamAlias("manager")
        private String manager;

        @XStreamAsAttribute
        @XStreamAlias("checkUser")
        private String checkUser;

        @XStreamAsAttribute
        @XStreamAlias("checkReport")
        private String checkReport;

        @XStreamAsAttribute
        @XStreamAlias("Codes")
        private List<Code> codes ;

        @Data
        public static class Codes{
            @XStreamAsAttribute
            @XStreamAlias("Code")
            private Code code;


        }



    }
}
