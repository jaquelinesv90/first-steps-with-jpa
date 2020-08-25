package ebook;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

//todas as anotações padronizadas pela JPA ficam 
// dentro do pacote javax.persistence.


// anotação entity diz que a classe é uma entidade JPA
// que representa uma tabela de banco de dados
@Entity
@Table(name = "tab_vehicle")
public class Vehicle {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;*/
	
	@EmbeddedId
	private IdVehicle code;
	
	// a definição de precisão nos atributos são importantes se
	// você estiver gerando as tabelas com recurso de schema generation do JPA,
	// mas não é recomendado o uso em produção.
	// Caso o schema do seu banco seja gerado externamente, por algumas ferramenta 
	// de gerenciamento de migrações(ex. Flyway),ou até mesmo manualmente, você não
	// precisa especificar todos os detalhes fisícos das colunas.
	@Column( length = 60, nullable = false)
	private String manufacturer;
	
	@Column( length = 60, nullable = false)
	private String model;
	
	@Column( name= "year_manufacture", nullable = false)
	private Integer yearManufacture;//fabricação
	
	@Column( name= "model_year", nullable = false)
	private Integer modelYear;
	
	@Column( length = 60, nullable = false)
	private BigDecimal value;
	
	
	public IdVehicle getCode() {
		return code;
	}
	public void setCode(IdVehicle code) {
		this.code = code;
	}
	/*
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}*/
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getYearManufacture() {
		return yearManufacture;
	}
	public void setYearManufacture(Integer yearManufacture) {
		this.yearManufacture = yearManufacture;
	}
	public Integer getModelYear() {
		return modelYear;
	}
	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	//evitar elementos duplicados
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}	
}