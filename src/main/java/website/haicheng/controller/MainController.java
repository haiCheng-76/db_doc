package website.haicheng.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import website.haicheng.entity.DbConfig;
import website.haicheng.entity.TableInfo;
import website.haicheng.enums.DbType;
import website.haicheng.service.DbQuery;
import website.haicheng.service.DbQueryFactory;
import website.haicheng.util.AlertUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/5 下午 03:25
 */
public class MainController {
    @FXML
    private TextField host;

    @FXML
    private TextField port;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private ComboBox<String> typeList;

    @FXML
    private ComboBox<String> dbList;


    /**
     * 加载数据库类型信息
     */
    @FXML
    public void initialize() {
        typeList.getItems().addAll(DbType.listName());
    }

    /**
     * 点击提交按钮数据
     *
     * @param event
     */
    public void buttonClick(ActionEvent event) {
        String str = paramCheck();
        if (StrUtil.isNotBlank(str)) {
            AlertUtil.defaultAlertMessage(str);
            return;
        }
        String db = dbList.getValue();
        if (StrUtil.isEmpty(db)) {
            AlertUtil.defaultAlertMessage("请选择数据库");
        }
        // 导出文件
        DbConfig config = new DbConfig(host.getText(), Integer.valueOf(port.getText()), username.getText(), password.getText(), DbType.getDriverClassNameByDbName(typeList.getValue()), db);
        DbQueryFactory factory = new DbQueryFactory();
        DbQuery query = factory.getDb(DbType.getDbType(typeList.getValue()));
        List<TableInfo> list = null;
        try {
            list = query.getTableInfo(config);
        } catch (SQLException | ClassNotFoundException e) {
            AlertUtil.defaultAlertMessage(e.getMessage());
            e.printStackTrace();
        }
        outputFile(list, db);
    }

    /**
     * 加载数据库列表
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    public void getDb(MouseEvent event) {
        String message = paramCheck();
        if (StrUtil.isNotBlank(message)) {
            AlertUtil.defaultAlertMessage(message);
            return;
        }
        dbList.getItems().clear();

        DbConfig config = new DbConfig(host.getText(), Integer.valueOf(port.getText()), username.getText(), password.getText(), Objects.requireNonNull(DbType.getDbType(typeList.getValue())));
        DbQueryFactory factory = new DbQueryFactory();
        DbQuery query = factory.getDb(DbType.getDbType(typeList.getValue()));
        try {
            List<String> dbs = query.listDbs(config);
            dbList.getItems().addAll(dbs);
        } catch (SQLException | ClassNotFoundException e) {
            AlertUtil.defaultAlertMessage(e.getMessage());
            e.printStackTrace();
        }
    }

    private void outputFile(List<TableInfo> infoList, String dbName) {
        TemplateEngine templateEngine = TemplateUtil.createEngine();
        TemplateConfig config = new TemplateConfig(StandardCharsets.UTF_8, "/", TemplateConfig.ResourceMode.CLASSPATH);
        templateEngine.init(config);
        Template template = templateEngine.getTemplate("template/temp.ftl");
        Map<String, List<TableInfo>> map = new HashMap<>();
        map.put("data", infoList);
        template.render(map, new File("C:\\Users\\58289\\OneDrive\\桌面\\" + dbName + ".doc"));
        System.out.println("success");
    }

    /**
     * 参数检查
     *
     * @return
     */
    private String paramCheck() {

        if (Objects.isNull(typeList.getValue())) {
            return "数据库类型不可为空";
        }
        if (StrUtil.isEmpty(host.getText())) {
            return "主机不可为空";
        }


        if (StrUtil.isEmpty(port.getText())) {
            return "端口不可为空";
        }

        if (StrUtil.isEmpty(username.getText())) {
            return "用户名不可为空";
        }

        if (StrUtil.isEmpty(password.getText())) {
            return "密码不可为空";
        }
        return null;
    }
}
