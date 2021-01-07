package dateTimeMapping;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/* TemporalType.DATE       para mapear uma coluna SQL DATE
 * TemporalType.TIME       para mapear uma coluna SQL TIME
 * TemporalType.TIMESTAMP  para mapear uma coluna SQL TIMESTAMP
 */
@Entity
public class DateTimeMappingJavaUtil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date utilDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar utilCalendar;
	
	public Date getUtilDate() {
		return utilDate;
	}
	
	public void setUtilDate(Date utilDate) {
		this.utilDate = utilDate;
	}
	
	public Calendar getUtilCalendar() {
		return utilCalendar;
	}
	
	public void setUtilCalendar(Calendar utilCalendar) {
		this.utilCalendar = utilCalendar;
	}
	
}
