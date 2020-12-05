package ebook.lazyLoading;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Um produto tem uma categoria e uma categoria pode
 * ter muitos produtos
 */

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	@Column(length = 60)
	private String name;
	
	/*Antes de adicionar o carregamento lazy,note que a query SQL fez um 
	 * join na tabela categoria, pois um produto possui uma categoria, 
	 * mas nós não usamos informações dessa entidade em momento algum.
	 * Neste caso, as informações da categoria do produto foram carregadas
	 * ansiosamente, mas não foram usadas.
	 * 
	 * Adicionamos a estratégia de carregamento para lazy no mapeamento
	 * da associação de produto com categoria.
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Category category;

	
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
