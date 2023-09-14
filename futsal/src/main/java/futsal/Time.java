package futsal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Time implements Serializable{ 
	private static final long serialVersionUID = 7113289795852972458L;
	@Id
	private String nome;
	private int gols = 0;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	@OneToOne
	private Treinador treinador;
	@OneToOne
	private Presidente presidente;
	@OneToMany
	private List<TorcidaOrganizada> organizadas = new ArrayList<>();
}

