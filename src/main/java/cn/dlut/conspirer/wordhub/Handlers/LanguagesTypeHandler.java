// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Handlers;

///**
// * 实现 Languages类 与 WordHub数据库 Dict表 lang_id字段 之间的自动映射
// *
// * @author OuOu
// * @version 1.0
// */
//@NoArgsConstructor
//@MappedTypes(Languages.class)
//@MappedJdbcTypes(value = JdbcType.INTEGER, includeNullJdbcType = true)
//public class LanguagesTypeHandler extends BaseTypeHandler<Languages> {
//
//    @Override
//    public void setParameter(PreparedStatement ps, int i, Languages parameter, JdbcType jdbcType) throws SQLException {
//        ps.setInt(i, parameter.getValue());
//    }
//
//    @Override
//    public Languages getResult(ResultSet rs, String columnName) throws SQLException {
//        int status = rs.getInt(columnName);
//        return Languages.values()[status];
//    }
//
//    @Override
//    public Languages getResult(ResultSet rs, int columnIndex) throws SQLException {
//        int status = rs.getInt(columnIndex);
//        return Languages.values()[status];
//    }
//
//    @Override
//    public Languages getResult(CallableStatement cs, int columnIndex) throws SQLException {
//        int status = cs.getInt(columnIndex);
//        return Languages.values()[status];
//    }
//
//    @Override
//    public void setNonNullParameter(PreparedStatement ps, int i, Languages parameter, JdbcType jdbcType) throws SQLException {
//        ps.setInt(i, parameter.getValue());
//    }
//
//    @Override
//    public Languages getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        int status = rs.getInt(columnName);
//        return Languages.values()[status];
//    }
//
//    @Override
//    public Languages getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        int status = rs.getInt(columnIndex);
//        return Languages.values()[status];
//    }
//
//    @Override
//    public Languages getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        int status = cs.getInt(columnIndex);
//        return Languages.values()[status];
//    }
//}
