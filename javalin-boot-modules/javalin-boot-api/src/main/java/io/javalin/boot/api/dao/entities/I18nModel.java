/**
 * Copyright (C) 2018 Hiwepy (http://hiwepy.io).
 * All Rights Reserved.
 */
package io.javalin.boot.api.dao.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 国际化Model
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("serial")
public class I18nModel implements Serializable {

    /**
     * 模块名称：通常指功能模块代码
     */
    protected String module;
    /**
     * 国际化资源文件名称
     */
    protected String resource;
    /**
     * 国际化信息集合
     */
    protected List<PairModel> i18nList;

    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        builder.append("module:").append(module).append(",");
        builder.append("resource:").append(resource).append(",");
        builder.append("[");
        for (PairModel pairModel : i18nList) {
            builder.append("key:" + pairModel.getKey() + " value:" + pairModel.getValue());
        }
        builder.append("]}");
        return builder.toString();
    }

}
