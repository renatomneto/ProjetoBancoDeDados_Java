package futsal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Reserva extends Jogador {
	private static final long serialVersionUID = -7901421003063095156L;
	private String corColete;
}
