package website.haicheng.entity;

import cn.hutool.core.util.StrUtil;
import website.haicheng.base.BaseModel;
import website.haicheng.enums.DbType;

import java.io.Serializable;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/2 下午 09:29
 */
public class DbConfig extends BaseModel implements Serializable {
    private static final long serialVersionUID = 5479953882166622071L;

    public DbConfig() {
    }

    public DbConfig(String host, Integer port, String userName, String password, DbType dbType) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.driverEnum = dbType.getDriverClassName();
        this.database = dbType.getDefaultDb();
    }

    public DbConfig(String host, Integer port, String userName, String password, String driverEnum, String database) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.driverEnum = driverEnum;
        this.database = database;
    }

    private String host;
    private Integer port;
    private String userName;
    private String password;
    private String url;
    private String driverEnum;
    private String database;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        String uri = "jdbc:mysql://{}:{}/{}?characterEncoding=utf-8&useSSL=false";
        return StrUtil.format(uri, this.host, this.port, this.database);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverEnum() {
        return driverEnum;
    }

    public void setDriverEnum(String driverEnum) {
        this.driverEnum = driverEnum;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        if (StrUtil.isEmpty(this.database)) {
            this.database = "mysql";
        }
        this.database = database;
    }
}
