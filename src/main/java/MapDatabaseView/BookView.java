package MapDatabaseView;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Immutable;

@Immutable
public class BookView {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Version
	@Column
	private int version;
	
	@Column
	private String title;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date publishingDate;
}
