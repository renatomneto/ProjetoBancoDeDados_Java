package futsal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Partida implements Serializable{
	private static final long serialVersionUID = 9170843433858800878L;
	@Id
	@GeneratedValue
	private int codigo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date termino;
	@OneToOne
	private Time timeCasa;
	@OneToOne
	private Time timeVisitante;
	@OneToOne
	private Juiz juizPrincipal;
	@OneToOne
	private Juiz juizMesa;
	@OneToOne
	private Bola bola;
	@OneToOne
	private Quadra quadra;
	@OneToOne
	private Estatistica estatistica;
	@OneToMany
	private List<TorcidaOrganizada> torcidas = new ArrayList<>();
	public Partida() {}
}
