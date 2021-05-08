package hibernateTips.enumMapping.attributeConverter.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import hibernateTips.enumMapping.attributeConverter.enums.Vehicle;


/*Um conversor de atributos nos permite implementar métodos para converter o
 * valor de um atributo de entidade em sua representação de banco de dados e 
 * vice-versa.Ao implementar nosso mapeamento, podemos escolher uma representação
 * compacta do banco de dados e garantir que a alteração do enum de qualquer forma
 * não interrompa o mapeamento existente.Portanto,adicionamos o shortName, que 
 * será usado como a representação do banco de dados, como uma propriedade adicional 
 * ao Enum.Também precisamos de um método para obter a propriedade shortName e obter
 * o enum para um determinado shortName.
 * O conversor é o que vai armazenar o Enum no banco de dados.
 * O vehicleConverter mapeia o valor enum para  shortName para armazená-lo no banco
 * de dados.Declarando-o com @Converter(autoApply= true), dizemos ao provedor JPA para 
 * usá-lo para mapear todos os enums do Veículo.Portanto, nãoprecisamos especificar o 
 * conversor para cada atributo de entidade do tipo Veículo.
 * 
 */

@Converter(autoApply = true)
public class VehicleConverter implements AttributeConverter<Vehicle, String>{

	@Override
	public String convertToDatabaseColumn(Vehicle vehicle) {
		return vehicle.getShortName();
	}

	// the entity you want to convert
	@Override
	public Vehicle convertToEntityAttribute(String dbData) {
		return Vehicle.fromShortName(dbData);
	}

}
