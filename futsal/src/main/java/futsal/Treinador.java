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
public class Treinador extends Pessoa {
	private static final long serialVersionUID = -8327725416503732407L;
	@Temporal(TemporalType.DATE)
	private Date contratacao;
	@OneToOne
	private Time time;
	
}
