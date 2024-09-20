package io.javalin.boot.autoconfigure.util;

import cn.hutool.core.io.resource.ResourceUtil;

public class AppUtil {
    public static String loadSql(String name) {
        return ResourceUtil.readUtf8Str("sql/"+name+".sql");
    }
}
