package website.haicheng.enums;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/5 下午 03:26
 */
public enum DbType {
    /**
     * MySQL
     */
    MYSQL("mysql", "com.mysql.jdbc.Driver", "mysql"),
    /**
     * Oracle
     */
    ORACLE("oracle", "oracle.jdbc.OracleDriver", "oracle");

    private final String name;
    private final String driverClassName;
    private final String defaultDb;

    DbType(String name, String driverClassName, String defaultDb) {
        this.name = name;
        this.driverClassName = driverClassName;
        this.defaultDb = defaultDb;
    }

    public String getName() {
        return name;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getDefaultDb() {
        return defaultDb;
    }

    /**
     * 获取数据库类型
     *
     * @return
     */
    public static List<String> listName() {
        DbType[] arr = DbType.values();
        List<String> list = new ArrayList<>(arr.length);
        for (DbType dbType : arr) {
            list.add(dbType.getName());
        }
        return list;
    }

    public static String getDriverClassNameByDbName(String name) {
        if (StrUtil.isEmpty(name)) {
            return null;
        }
        DbType[] arr = DbType.values();
        for (DbType dbType : arr) {
            if (dbType.getName().equalsIgnoreCase(name)) {
                return dbType.getDriverClassName();
            }
        }
        return null;
    }

    public static DbType getDbType(String name) {
        if (StrUtil.isEmpty(name)) {
            return null;
        }
        DbType[] arr = DbType.values();
        for (DbType dbType : arr) {
            if (dbType.getName().equalsIgnoreCase(name)) {
                return dbType;
            }
        }
        return null;
    }
}
