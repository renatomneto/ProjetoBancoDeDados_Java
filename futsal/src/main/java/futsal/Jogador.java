package futsal;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public abstract class Jogador extends Pessoa {
	private static final long serialVersionUID = -3713640456032248936L;
	private int numero;
	@Enumerated
	private PosicaoEnum posicao;
	private boolean expulso = false;
	@OneToOne
	protected Cartao cartoesAmarelos;
	@OneToOne
	protected Cartao cartaoVermelho;
	@ManyToOne
	private Time time;
}
