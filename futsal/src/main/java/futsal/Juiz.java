package futsal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Juiz extends Pessoa {
	private static final long serialVersionUID = 1520952078544728193L;
	private boolean principal = false;
	@OneToOne
	private Cartao cartaoVermelho;
	@OneToOne
	private Cartao cartaoAmarelo;

}
