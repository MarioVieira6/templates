package br.com.hibernate.customs;

import java.util.Properties;

import org.hibernate.internal.TypeLocatorImpl;
import org.hibernate.type.EnumType;
import org.hibernate.type.Type;
import org.hibernate.type.TypeResolver;

public class Scalar {

	/**
	 * Converter String in Enum. AddScalar.
	 */
	public static Type getType(Class<?> enumClass) {
		Properties paramStepTypeEnum = new Properties();
		paramStepTypeEnum.put("enumClass", enumClass.getName().toString());
		paramStepTypeEnum.put("type", "12"); // Type 12 String.
		TypeLocatorImpl typeLocator = new TypeLocatorImpl(new TypeResolver());
		return typeLocator.custom(EnumType.class, paramStepTypeEnum);
	}

}
