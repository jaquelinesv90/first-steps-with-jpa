package liveLessons.lesson03.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Configuration {
	
		@Id
		private Integer id;
		
		// anotação mapsId: quer dizer que a minha chave estrangeira é também 
		//minha chave primária
		@MapsId
		@OneToOne
		private User user;
		
		private boolean getNotification;
		
		private boolean logOutAutomatically;
		
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public boolean isGetNotification() {
			return getNotification;
		}

		public void setGetNotification(boolean getNotification) {
			this.getNotification = getNotification;
		}

		public boolean isLogOutAutomatically() {
			return logOutAutomatically;
		}

		public void setLogOutAutomatically(boolean logOutAutomatically) {
			this.logOutAutomatically = logOutAutomatically;
		}
		
		
}
