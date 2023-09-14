package futsal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Estatistica implements Serializable{
	private static final long serialVersionUID = 2778818220661717817L;
	@Id
	@GeneratedValue
	private int codigo;
	private int chutes;
	private int faltas;
	private int escanteios;
}
