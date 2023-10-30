package cn.dlut.conspirer.wordhub.Handlers;

/**
 * TODO: Inject ObjectMapper instead of new
 *
 * @author OuOu
 * @version 1.0
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(JsonNode.class)
@Slf4j
//@MappedJdbcTypes(value = JdbcType.LONGVARCHAR, includeNullJdbcType = true)
@Component
public class JsonNodeTypeHandler extends BaseTypeHandler<JsonNode> {
    private final ObjectMapper objectMapper = new ObjectMapper();

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
        json = json.replace("\"{","{");
        json = json.replace("}\"","}");
        json = json.replace("\\","");
        log.debug("original: {}, ", json);
        log.debug("tree: {}", objectMapper.readTree(json));
        return objectMapper.readTree(json);
    }
}

