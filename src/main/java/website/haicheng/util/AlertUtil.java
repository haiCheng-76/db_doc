package website.haicheng.util;

import javafx.scene.control.Alert;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/5 下午 03:27
 */
public class AlertUtil {
    /**
     * 弹窗
     *
     * @param title 标题
     * @param msg   错误信息
     */
    public static void alertMessage(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setWidth(400);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    /**
     * 默认标题
     *
     * @param msg
     */
    public static void defaultAlertMessage(String msg) {
        alertMessage("错误", msg);
    }
}
