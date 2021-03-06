package liveLessons.lesson02.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//classe criada para na hora da consulta retornar apenas alguns campos do usuario
// não precisa de um construtor padrão, como nas demais entidades

public class UserDto {
	
	//estratégia de geração de chave primária e deixe que o bd gere o valor
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Integer id;
			
			private String name;
			
		
			public UserDto(Integer id,String name) {
				this.id = id;
				this.name = name;
			}
			
			

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
}
