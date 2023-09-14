package futsal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;
@Data
@Entity
public abstract class Local implements Serializable{
	private static final long serialVersionUID = -54525474271361725L;
	@Id
	private String cidade;
	private String estado;
	private Date data;

}
