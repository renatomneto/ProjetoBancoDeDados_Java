package futsal.form;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import futsal.Jogador;
import futsal.PosicaoEnum;
import futsal.Reserva;
import futsal.Time;
import futsal.Titular;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class JogadorInsere extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblPosicao;
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("futsalPU");
	private EntityManager em = emf.createEntityManager();
	private Titular t1;
	private Reserva r1;
	private Time time;
	private List<Jogador> jogadoresNovos = new ArrayList<Jogador>();
	private PosicaoEnum posicao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogadorInsere frame = new JogadorInsere();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JogadorInsere() {
		setTitle("Inserir Jogador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 10, 45, 13);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(56, 7, 238, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(195, 37, 55, 13);
		contentPane.add(lblNumero);
		
		JSpinner spnNumero = new JSpinner();
		spnNumero.setBounds(249, 36, 45, 20);
		contentPane.add(spnNumero);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(20, 37, 36, 13);
		contentPane.add(lblIdade);
		
		JSpinner spnIdade = new JSpinner();
		spnIdade.setBounds(56, 35, 45, 20);
		contentPane.add(spnIdade);
		
		Choice choicePosicao = new Choice();
		choicePosicao.setBounds(56, 62, 95, 18);
		contentPane.add(choicePosicao);
		choicePosicao.add("");
		choicePosicao.add(posicao.ALA.toString());
		choicePosicao.add(posicao.FIXO.toString());
		choicePosicao.add(posicao.PIVO.toString());
		choicePosicao.add(posicao.GOLEIRO.toString());
		
		lblPosicao = new JLabel("Posicao");
		lblPosicao.setBounds(10, 63, 45, 13);
		contentPane.add(lblPosicao);
		
		JRadioButton rdbtnTitular = new JRadioButton("Titular");
		rdbtnTitular.setBounds(118, 35, 71, 21);
		contentPane.add(rdbtnTitular);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(158, 67, 30, 13);
		contentPane.add(lblTime);
		
		Choice choiceTime = new Choice();
		choiceTime.setBounds(196, 62, 98, 18);
		contentPane.add(choiceTime);
		choiceTime.add("");
		choiceTime.add("Sao Paulo");
		choiceTime.add("Corinthians");
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				em.getTransaction().begin();
				
				time = em.find(Time.class, choiceTime.getSelectedItem());
//				System.out.println(choiceTime.getSelectedItem());
				if(time != null) {
					jogadoresNovos.addAll(time.getJogadores());
					
					if (rdbtnTitular.isSelected()) {
						t1=new Titular();
						t1.setNome(txtNome.getText());
						t1.setIdade((int)spnIdade.getValue());
						t1.setNumero((int)spnNumero.getValue());
						t1.setPosicao(posicao.valueOf(choicePosicao.getSelectedItem()));
						t1.setTime(time);
						
							
						jogadoresNovos.add(t1);
//						System.out.println(jogadoresNovos);
						time.setJogadores(jogadoresNovos);
						em.persist(t1);
					}else {
						r1=new Reserva();
						r1.setNome(txtNome.getText());
						r1.setIdade((int)spnIdade.getValue());
						r1.setNumero((int)spnNumero.getValue());
						r1.setPosicao(posicao.valueOf(choicePosicao.getSelectedItem()));
						r1.setTime(time);
						
//						System.out.println(choiceTime.getSelectedItem());
	
						jogadoresNovos.add(r1);
//						System.out.println(jogadoresNovos);
						time.setJogadores(jogadoresNovos);
							
						em.persist(r1);
					}
				}
				JOptionPane.showMessageDialog(null, "Jogador adicionado!");
				em.getTransaction().commit();
				dispose();
			}
		});
		btnInserir.setBounds(309, 35, 85, 21);
		contentPane.add(btnInserir);		
		
	}
}
