package website.haicheng.entity;


import website.haicheng.base.BaseModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:26
 */
public class TableInfo extends BaseModel implements Serializable {
    private static final long serialVersionUID = 7908834557002415119L;

    private String tableName;
    private String engine;
    private Date createTime;
    private String tableCharset;
    private String tableComment;
    private List<FieldInfo> fieldInfos;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTableCharset() {
        return tableCharset;
    }

    public void setTableCharset(String tableCharset) {
        this.tableCharset = tableCharset;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<FieldInfo> getFieldInfos() {
        return fieldInfos;
    }

    public void setFieldInfos(List<FieldInfo> fieldInfos) {
        this.fieldInfos = fieldInfos;
    }
}
