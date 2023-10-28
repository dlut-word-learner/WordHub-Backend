package cn.dlut.conspirer.wordhub.Handlers;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(JsonNode.class)
//@MappedJdbcTypes(value = JdbcType.LONGVARCHAR, includeNullJdbcType = true)
@Component
public class JsonNodeTypeHandler extends BaseTypeHandler<JsonNode> implements InitializingBean {
    static JsonNodeTypeHandler j;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 魔法 注入 单例bean objectMapper;
     * 在 @Controller 中注入ObjectMapper 不需要这么麻烦，直接 @Autowired 即可 。
     * 非Controller 注入原理：spring 启动过程中 实例化JsonNodeTypeHandler 的 bean 时，会自动把 objectMapper 携带过来；
     * spring 启动完成后的bean 又会被擦除 。所以，这个要及时赋值一下引用 objectMapper
     */
    @Override
    public void afterPropertiesSet() {
        j = this; // 初始化静态实例
        j.objectMapper = this.objectMapper; //及时拷贝引用
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JsonNode jsonNode, JdbcType jdbcType) throws SQLException {
        ps.setString(i, jsonNode != null ? jsonNode.toString() : null);
    }

    @SneakyThrows
    @Override
    public JsonNode getNullableResult(ResultSet rs, String colName) {
        return read(rs.getString(colName));
    }

    @SneakyThrows
    @Override
    public JsonNode getNullableResult(ResultSet rs, int colIndex) {
        return read(rs.getString(colIndex));
    }

    @SneakyThrows
    @Override
    public JsonNode getNullableResult(CallableStatement cs, int i) {
        return read(cs.getString(i));
    }

    @SneakyThrows
    private JsonNode read(String json) {
        return json != null ? j.objectMapper.readTree(json) : null;
    }
}

