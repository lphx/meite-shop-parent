package cn.phlos;

import lombok.Data;

/**
 * 微信实体类
 * @Autor lipenghong
 * @Date 22:32 2019/12/29
 **/
@Data
public class AppEntity {

    /**
     * appId
     */
    private String appId;

    /**
     * appName
     */
    private String appName;

    public AppEntity(String appId, String appName) {
        this.appId = appId;
        this.appName = appName;
    }
}
