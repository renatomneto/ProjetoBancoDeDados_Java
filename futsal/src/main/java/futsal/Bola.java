package futsal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Bola implements Serializable{
	private static final long serialVersionUID = -5766395642678336570L;
	@Id
	@GeneratedValue
	private int codigo;
	private String marca;
	private String cores;


}
