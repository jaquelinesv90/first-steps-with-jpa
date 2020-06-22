package aula01;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Client {

	//estratégia de geração de chave primária e deixe que o bd gere o valor
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id= id;
	}
	
	public String getNome() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
