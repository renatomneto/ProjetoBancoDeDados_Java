package futsal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Titular extends Jogador {
	private static final long serialVersionUID = -8547839917302437264L;
	private boolean emQuadra = true;
}
