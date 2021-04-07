package website.haicheng.service.impl;


import website.haicheng.enums.DbType;
import website.haicheng.service.AbstractDbQuery;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:32
 */
public class MysqlDbQuery extends AbstractDbQuery {
    @Override
    public DbType dbType() {
        return DbType.MYSQL;
    }

    @Override
    public String databaseSql() {
        return "SELECT `SCHEMA_NAME` as db FROM `information_schema`.`SCHEMATA`";
    }


    @Override
    public String tablesSql() {
        return "show table status WHERE 1=1";
    }

    @Override
    public String tableFieldsSql() {
        return "show full fields from {}";
    }

    @Override
    public String tableName() {
        return "Name";
    }

    @Override
    public String engine() {
        return "Engine";
    }

    @Override
    public String createTime() {
        return "Create_time";
    }

    @Override
    public String character() {
        return "Collation";
    }

    @Override
    public String tableComment() {
        return "Comment";
    }


    @Override
    public String fieldName() {
        return "Field";
    }

    @Override
    public String fieldType() {
        return "Type";
    }

    @Override
    public String isFieldNull() {
        return "Null";
    }

    @Override
    public String isKey() {
        return "Key";
    }

    @Override
    public String fieldDefault() {
        return "Default";
    }

    @Override
    public String comment() {
        return "Comment";
    }



}
