package br.com.hibernate.customs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.hibernate.type.BigDecimalType;
import org.hibernate.type.BigIntegerType;
import org.hibernate.type.BooleanType;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class TypeInstance {

	/**
	 * 
	 * A type that maps between Java Types and org.hibernate.type.Type.
	 * 
	 * @param clazzType Java Type.
	 * @return org.hibernate.type.Type.
	 */
	public static Type type(Class<?> clazzType) {
		if (Integer.TYPE.equals(clazzType) || Integer.class.equals(clazzType)) {
			return IntegerType.INSTANCE;
		} else if (Double.TYPE.equals(clazzType) || Double.class.equals(clazzType)) {
			return DoubleType.INSTANCE;
		} else if (Boolean.TYPE.equals(clazzType) || Boolean.class.equals(clazzType)) {
			return BooleanType.INSTANCE;
		} else if (Float.TYPE.equals(clazzType) || Float.class.equals(clazzType)) {
			return FloatType.INSTANCE;
		} else if (Long.TYPE.equals(clazzType) || Long.class.equals(clazzType)) {
			return LongType.INSTANCE;
		} else if (BigDecimal.class.equals(clazzType)) {
			return BigDecimalType.INSTANCE;
		} else if (BigInteger.class.equals(clazzType)) {
			return BigIntegerType.INSTANCE;
		} else if (Date.class.equals(clazzType)) {
			return DateType.INSTANCE;
		} else if (clazzType.isEnum()) {
			return Scalar.getType(clazzType);
		}

		return null;
	}
}
