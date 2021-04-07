package website.haicheng.base;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;

/**
 * @description:
 * @author: 582895699@qq.com
 * @time: 2021/4/5 下午 03:24
 */
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = -1349647579312363147L;

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
