package EnumMapping;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, Integer>{

	@Override
	public Integer convertToDatabaseColumn(Rating attribute) {
		if(attribute == null) {
			return null;
		}
		
		Integer dbValue;
		switch(attribute) {
		
		}
	}

	@Override
	public Rating convertToEntityAttribute(Integer dbData) {
		// TODO Auto-generated method stub
		return null;
	}

}
