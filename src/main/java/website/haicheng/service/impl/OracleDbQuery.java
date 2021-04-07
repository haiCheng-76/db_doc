package website.haicheng.service.impl;



import website.haicheng.entity.DbConfig;
import website.haicheng.entity.TableInfo;
import website.haicheng.enums.DbType;
import website.haicheng.service.AbstractDbQuery;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:35
 */
public class OracleDbQuery extends AbstractDbQuery {
    @Override
    public DbType dbType() {
        return null;
    }

    @Override
    public String databaseSql() {
        return null;
    }

    @Override
    public String tablesSql() {
        return null;
    }

    @Override
    public String tableFieldsSql() {
        return null;
    }

    @Override
    public String tableName() {
        return null;
    }

    @Override
    public String engine() {
        return null;
    }

    @Override
    public String createTime() {
        return null;
    }

    @Override
    public String character() {
        return null;
    }

    @Override
    public String tableComment() {
        return null;
    }

    @Override
    public String fieldName() {
        return null;
    }

    @Override
    public String fieldType() {
        return null;
    }

    @Override
    public String isFieldNull() {
        return null;
    }

    @Override
    public String isKey() {
        return null;
    }

    @Override
    public String fieldDefault() {
        return null;
    }

    @Override
    public String comment() {
        return null;
    }

    @Override
    public List<String> listDbs(DbConfig dbConfig) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<TableInfo> getTableInfo(DbConfig dbConfig) throws SQLException, ClassNotFoundException {
        return null;
    }
}
