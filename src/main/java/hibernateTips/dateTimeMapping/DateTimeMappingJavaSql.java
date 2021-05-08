package hibernateTips.dateTimeMapping;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* java.sql.Date é mapeado para SQL DATE
 * java.sql.TIME é mapeado para SQL TIME
 * java.sql.TIMESTAMP é mapeado para SQL TIMESTAMP
 */

@Entity
public class DateTimeMappingJavaSql {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private java.sql.Date sqlDate;
	
	private Time sqlTime;
	
	private Timestamp sqlTimestamp;
	
	

	public java.sql.Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(java.sql.Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public Time getSqlTime() {
		return sqlTime;
	}

	public void setSqlTime(Time sqlTime) {
		this.sqlTime = sqlTime;
	}

	public Timestamp getSqlTimestamp() {
		return sqlTimestamp;
	}

	public void setSqlTimestamp(Timestamp sqlTimestamp) {
		this.sqlTimestamp = sqlTimestamp;
	}
}
