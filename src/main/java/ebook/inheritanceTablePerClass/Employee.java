package ebook.inheritanceTablePerClass;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/* @DiscriminatorValue para definir o valor discriminador de cada tipo
 * só pode ser utilizado em classes concretas(classes da qual podemos 
 * criar instancia, usando a palavra chave new)
 * 
 * Adicionado a anotação @PrimaryKeyJoinColumn para informar o nome
 * da coluna que faz referencia a tablea pai, ou seja o identificador
 * Person.Se o nome dessa coluna for igual ao nome da coluna da tabela 
 * pai, essa anotação não precisa ser utilizada.
 * 
 */

//@Entity
@DiscriminatorValue("F")
public class Employee extends Person{
	
	@Column(nullable = true)
	private BigDecimal salary;
	
	@Column(length = 60, nullable = true)
	private String role;
	
	

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
