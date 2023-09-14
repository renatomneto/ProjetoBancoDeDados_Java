package futsal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 Renato Masteguim Neto - 2020001250
*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("futsalPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		/*
		 * Insert Time 1 
		*/
		Time t1 = new Time();
		Titular j1 = new Titular();
		Reserva j2 = new Reserva();
		Treinador tr1 = new Treinador();
		Presidente pr1 = new Presidente();
		TorcidaOrganizada dragoes = new TorcidaOrganizada();
		List<Jogador> jogadores = new ArrayList<Jogador>();
		List<TorcidaOrganizada> torcidas1 = new ArrayList<TorcidaOrganizada>();
		
		dragoes.setNome("Dragoes da Real");
		dragoes.setIntegrantes(10000);
		dragoes.setTime(t1);
		torcidas1.add(dragoes);
		
		t1.setNome("Sao Paulo");
		t1.setGols(3);
		t1.setOrganizadas(torcidas1);
		t1.setJogadores(jogadores);
		
		j1.setNome("Greuto de Carvalho");
		j1.setIdade(33);
		j1.setNumero(18);
		j1.setPosicao(PosicaoEnum.GOLEIRO);
		j1.setTime(t1);
		jogadores.add(j1);
		
		j2.setNome("Indio");
		j2.setCorColete("Vermelho");
		j2.setIdade(47);
		j2.setNumero(13);
		j2.setPosicao(PosicaoEnum.FIXO);
		j2.setTime(t1);
		jogadores.add(j2);

		tr1.setNome("Conrado Pereira");
		tr1.setIdade(60);
		tr1.setTime(t1);
		tr1.setContratacao(new Date("01/12/2022"));
		
		pr1.setNome("Julio Casares");
		pr1.setIdade(63);
		pr1.setTime(t1);
		pr1.setInicioMandato(new Date("01/01/2021"));
		/*
		 * Fim Insert Time 1 
		*/
		
//		=========================================================
		
		/*
		 * Insert Partida
		*/
		Time t2 = new Time();
		Juiz juiz1 = new Juiz();
		Cartao cartaoAmarelo = new Cartao();
		Cartao cartaoVermelho = new Cartao();
		Estatistica e = new Estatistica();
		Quadra q = new Quadra();
		Bola b = new Bola();
		Partida p = new Partida();
		
		t2.setNome("Corinthians");
		t2.setGols(0);
		
		juiz1.setNome("Tales Ferreira Goulart");
		juiz1.setIdade(50);
		juiz1.setPrincipal(true);
		juiz1.setCartaoAmarelo(cartaoAmarelo);
		juiz1.setCartaoVermelho(cartaoVermelho);		
		
		e.setChutes(20);
		e.setEscanteios(7);
		e.setFaltas(8);
		
		q.setCapacidade(20000);
		q.setCidade("Itajuba");
		q.setEstado("MG");
		q.setComprimento(22);
		q.setLargura(16);
		q.setNomeGinasio("Tigrao");
		
		b.setMarca("Adidas");
	
		p.setBola(b);
		p.setEstatistica(e);
		p.setInicio(new Date());
		p.setTermino(new Date());
		p.setQuadra(q);
		p.setTimeCasa(t1);
		p.setTimeVisitante(t2);
		p.setJuizPrincipal(juiz1);
		p.setJuizMesa(null);
		p.setTorcidas(torcidas1);
		
		em.persist(pr1);
		em.persist(tr1);
		em.persist(j1);
		em.persist(j2);
		em.persist(t1);
		em.persist(t2);
		em.persist(dragoes);
		em.persist(juiz1);
		em.persist(cartaoAmarelo);
		em.persist(cartaoVermelho);
		em.persist(e);
		em.persist(q);
		em.persist(b);
		em.persist(p);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
