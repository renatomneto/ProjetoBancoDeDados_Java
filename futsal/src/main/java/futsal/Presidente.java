package futsal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Presidente extends Pessoa {
	private static final long serialVersionUID = -7846236580154560826L;
	@Temporal(TemporalType.DATE)
	private Date inicioMandato;
	@OneToOne
	private Time time;
	
}

