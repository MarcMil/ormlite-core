package com.j256.ormlite.field.types;

import java.sql.SQLException;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

/**
 * Type that persists a Integer object.
 * 
 * @author graywatson
 */
public class IntegerObjectType extends BaseDataType {

	private static final IntegerObjectType singleTon = new IntegerObjectType();

	public static IntegerObjectType getSingleton() {
		return singleTon;
	}

	private IntegerObjectType() {
		super(SqlType.INTEGER, new Class<?>[] { Integer.class });
	}

	protected IntegerObjectType(SqlType sqlType, Class<?>[] classes) {
		super(sqlType, classes);
	}

	@Override
	public Object parseDefaultString(FieldType fieldType, String defaultStr) {
		return Integer.parseInt(defaultStr);
	}

	@Override
	public Object resultToJava(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
		return (Integer) results.getInt(columnPos);
	}

	@Override
	public Object javaToSqlArg(FieldType fieldType, Object javaObject) throws SQLException {
		// noop pass-thru
		return javaObject;
	}

	@Override
	public boolean isValidForType(Class<?> fieldClass) {
		// by default this is a noop
		return true;
	}

	@Override
	public Object convertIdNumber(Number number) {
		return (Integer) number.intValue();
	}

	@Override
	public boolean isEscapedValue() {
		return false;
	}

	@Override
	public boolean isValidGeneratedType() {
		return true;
	}
}
