package website.haicheng.service;


import website.haicheng.entity.DbConfig;
import website.haicheng.entity.TableInfo;
import website.haicheng.enums.DbType;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:25
 */
public interface DbQuery {
    /**
     * 数据库类型
     *
     * @return
     */
    DbType dbType();

    /**
     * 查询所有的数据库
     *
     * @return
     */
    String databaseSql();


    /**
     * 表信息查询 SQL
     */
    String tablesSql();


    /**
     * 表字段信息查询 SQL
     */
    String tableFieldsSql();


    /**
     * 表名称
     */
    String tableName();

    /**
     * 存储引擎名称
     *
     * @return
     */
    String engine();


    /**
     * 创建时间
     */
    String createTime();

    /**
     * 字符集
     *
     * @return
     */
    String character();

    /**
     * 表注释
     *
     * @return
     */
    String tableComment();

    /**
     * 字段名称
     *
     * @return
     */
    String fieldName();

    /**
     * 字段类型
     *
     * @return
     */
    String fieldType();

    /**
     * 是否允许空
     *
     * @return
     */
    String isFieldNull();

    /**
     * 是否是主键
     *
     * @return
     */
    String isKey();

    /**
     * 默认值
     *
     * @return
     */
    String fieldDefault();

    /**
     * 字段注释
     *
     * @return
     */
    String comment();

    /**
     * 查询所有的数据库
     *
     * @param dbConfig 用户名和密码等
     * @return
     */
    List<String> listDbs(DbConfig dbConfig) throws SQLException, ClassNotFoundException;

    /**
     * 获取表信息和字段信息
     *
     * @param dbConfig 用户名和密码等
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<TableInfo> getTableInfo(DbConfig dbConfig) throws SQLException, ClassNotFoundException;
}
