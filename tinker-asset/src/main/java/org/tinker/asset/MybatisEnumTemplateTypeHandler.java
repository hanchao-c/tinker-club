package org.tinker.asset;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.tinker.asset.util.EnumTemplateUtil;

@MappedTypes(value = MybatisEnumTemplate.class)
public class MybatisEnumTemplateTypeHandler<T extends Enum<T> & MybatisEnumTemplate> extends BaseTypeHandler<T> {

	private Class<T> clz;
	
	public MybatisEnumTemplateTypeHandler(Class<T> clz) {
		this.clz = clz;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, parameter.getCode());
	}

	@Override
	public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String code = rs.getString(columnName);
		return EnumTemplateUtil.getByCode(code, clz);
	}

	@Override
	public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String code = rs.getString(columnIndex);
		return EnumTemplateUtil.getByCode(code, clz);
	}

	@Override
	public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String code = cs.getString(columnIndex);
		return EnumTemplateUtil.getByCode(code, clz);
	}


}
