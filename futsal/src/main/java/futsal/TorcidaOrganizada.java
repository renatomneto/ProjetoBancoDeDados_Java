package futsal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class TorcidaOrganizada implements Serializable{
	private static final long serialVersionUID = -4955573778422655506L;
	@Id
	private String nome;
	private int integrantes;
	@ManyToOne
	private Time time;
}
