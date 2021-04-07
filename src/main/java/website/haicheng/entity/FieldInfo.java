package website.haicheng.entity;


import website.haicheng.base.BaseModel;

import java.io.Serializable;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:25
 */
public class FieldInfo extends BaseModel implements Serializable {
    private static final long serialVersionUID = 5923460286028996599L;

    private String fieldName;
    private String type;
    private Boolean allowNull;
    private Boolean key;
    private String defaultValue;
    private String fieldComment;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAllowNull() {
        return allowNull;
    }

    public void setAllowNull(Boolean allowNull) {
        this.allowNull = allowNull;
    }

    public Boolean getKey() {
        return key;
    }

    public void setKey(Boolean key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }
}
