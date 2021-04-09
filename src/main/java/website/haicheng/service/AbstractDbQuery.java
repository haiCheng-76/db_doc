package website.haicheng.service;


import cn.hutool.core.util.StrUtil;
import cn.hutool.db.StatementUtil;
import website.haicheng.entity.DbConfig;
import website.haicheng.entity.FieldInfo;
import website.haicheng.entity.TableInfo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:29
 */
public abstract class AbstractDbQuery implements DbQuery {

    @Override
    public List<String> listDbs(DbConfig dbConfig) throws SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        Connection connection = getConnection(dbConfig);
        PreparedStatement preparedStatement = StatementUtil.prepareStatement(connection, databaseSql());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(resultSet.getString("db"));
        }
        connection.close();
        return list;
    }

    @Override
    public List<TableInfo> getTableInfo(DbConfig dbConfig) throws SQLException, ClassNotFoundException {
        List<TableInfo> list = new ArrayList<>();
        Connection connection = getConnection(dbConfig);
        PreparedStatement preparedStatement = StatementUtil.prepareStatement(connection, this.tablesSql());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTableName(resultSet.getString(tableName()));
            tableInfo.setEngine(resultSet.getString(engine()));
            tableInfo.setCreateTime(resultSet.getTimestamp(createTime()));
            tableInfo.setTableCharset(resultSet.getString(character()));
            tableInfo.setTableComment(resultSet.getString(tableComment()));
            list.add(tableInfo);
        }

        for (TableInfo tableInfo : list) {
            getFieldData(connection, tableInfo);
        }
        return list;
    }

    protected void getFieldData(Connection connection, TableInfo tableInfo) throws SQLException {
        PreparedStatement preparedStatement = StatementUtil.prepareStatement(connection, StrUtil.format(this.tableFieldsSql(), tableInfo.getTableName()));
        ResultSet fieldResultSet = preparedStatement.executeQuery();
        List<FieldInfo> infos = new ArrayList<>();
        while (fieldResultSet.next()) {
            FieldInfo fieldInfo = new FieldInfo();
            fieldInfo.setFieldName(fieldResultSet.getString(fieldName()));
            fieldInfo.setAllowNull(fieldResultSet.getBoolean(isFieldNull()));
            fieldInfo.setDefaultValue(StrUtil.isEmpty(fieldResultSet.getString(fieldDefault())) ? "" : fieldResultSet.getString(fieldDefault()));
            fieldInfo.setKey(StrUtil.isEmpty(fieldResultSet.getString(isKey())));
            fieldInfo.setType(fieldResultSet.getString(fieldType()));
            fieldInfo.setFieldComment(fieldResultSet.getString(comment()));
            infos.add(fieldInfo);
        }
        tableInfo.setFieldInfos(infos);
    }

    public Connection getConnection(DbConfig dbConfig) throws SQLException, ClassNotFoundException {
        Class.forName(dbConfig.getDriverEnum());
        return DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(), dbConfig.getPassword());
    }
}
