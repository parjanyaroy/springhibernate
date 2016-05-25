/*package com.mastertheboss.domain;

import javax.persistence.AttributeConverter;

@Converter
public class CurrencyConverter implements AttributeConverter<Double,Double> {

	public Double convertToDatabaseColumn(Double arg0) {
		double dollars = (double)arg0/60;
		System.out.println("convertToDatabaseColumn invoked");
		return dollars;
	}

	public Double convertToEntityAttribute(Double arg0) {
		double rupees = (double) arg0*60;
		System.out.println("convertToEntityAttribute invoked");
		return rupees;
	}
	

}
*/