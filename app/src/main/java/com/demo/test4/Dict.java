package com.demo.test4;

public class Dict {
    private String id;
    private String dataType;
    private String dataTypeName;
    private String dataName;
    private String dataValue;

    public Dict(String id, String dataType, String dataTypeName, String dataName, String dataValue) {
        this.id = id;
        this.dataType = dataType;
        this.dataTypeName = dataTypeName;
        this.dataName = dataName;
        this.dataValue = dataValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataTypeName() {
        return dataTypeName;
    }

    public void setDataTypeName(String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }
}
