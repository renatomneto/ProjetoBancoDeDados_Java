package futsal;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Quadra extends Local {
	private static final long serialVersionUID = 8338170598820817915L;
	private String nomeGinasio;
	private float largura;
	private float comprimento;
	private int capacidade;
}
