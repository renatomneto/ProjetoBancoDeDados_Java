package futsal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cartao implements Serializable{
	private static final long serialVersionUID = 163942260606077774L;
	@Id
	@GeneratedValue
	private int codigo;
	private int quantidade = 0;
	public Cartao() {}
}
