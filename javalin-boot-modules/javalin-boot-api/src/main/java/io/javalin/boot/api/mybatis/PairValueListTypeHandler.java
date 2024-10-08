/**
 * Copyright (C) 2018 Hiwepy (http://hiwepy.io).
 * All Rights Reserved.
 */
package io.javalin.boot.api.mybatis;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import io.javalin.boot.api.dao.entities.PairModel;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class PairValueListTypeHandler extends BaseTypeHandler<List<PairModel>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<PairModel> list, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i, JSONObject.toJSONString(list));
    }

    @Override
    public List<PairModel> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String rtString = rs.getString(columnName);
        if (StringUtils.hasText(rtString)) {
            return JSONArray.parseArray(rtString, PairModel.class);
        }
        return null;
    }

    @Override
    public List<PairModel> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String rtString = rs.getString(columnIndex);
        if (StringUtils.hasText(rtString)) {
            return JSONArray.parseArray(rtString, PairModel.class);
        }
        return null;
    }

    @Override
    public List<PairModel> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String rtString = cs.getString(columnIndex);
        if (StringUtils.hasText(rtString)) {
            return JSONArray.parseArray(rtString, PairModel.class);
        }
        return null;
    }


}
