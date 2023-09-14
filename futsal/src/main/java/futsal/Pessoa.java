package futsal;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public abstract class Pessoa implements Serializable{
	private static final long serialVersionUID = 6863246516602798624L;
	@Id
	private String nome;
	private int idade;
	
}
