package website.haicheng.service;


import website.haicheng.enums.DbType;
import website.haicheng.service.impl.MysqlDbQuery;
import website.haicheng.service.impl.OracleDbQuery;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:36
 */
public class DbQueryFactory {
    public DbQuery getDb(DbType dbType) {
        if (dbType == null) {
            return null;
        }
        if (dbType.equals(DbType.MYSQL)) {
            return new MysqlDbQuery();
        }
        if (dbType.equals(DbType.ORACLE)) {
            return new OracleDbQuery();
        }
        return null;
    }
}
