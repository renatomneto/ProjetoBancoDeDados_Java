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

public class JogadorRemove extends JFrame {

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
					JogadorRemove frame = new JogadorRemove();
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
	public JogadorRemove() {
		setTitle("Remover Jogador");
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
		spnNumero.setEnabled(false);
		spnNumero.setBounds(249, 36, 45, 20);
		contentPane.add(spnNumero);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(20, 37, 36, 13);
		contentPane.add(lblIdade);
		
		JSpinner spnIdade = new JSpinner();
		spnIdade.setEnabled(false);
		spnIdade.setBounds(56, 35, 45, 20);
		contentPane.add(spnIdade);
		
		Choice choicePosicao = new Choice();
		choicePosicao.setEnabled(false);
		choicePosicao.setBounds(56, 62, 95, 18);
		contentPane.add(choicePosicao);
		choicePosicao.add("");
		choicePosicao.add(posicao.ALA.toString());
		choicePosicao.add(posicao.PIVO.toString());
		choicePosicao.add(posicao.GOLEIRO.toString());
		choicePosicao.add(posicao.FIXO.toString());
		
		lblPosicao = new JLabel("Posicao");
		lblPosicao.setBounds(10, 63, 45, 13);
		contentPane.add(lblPosicao);
		
		JRadioButton rdbtnTitular = new JRadioButton("Titular");
		rdbtnTitular.setEnabled(false);
		rdbtnTitular.setBounds(118, 35, 71, 21);
		contentPane.add(rdbtnTitular);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(158, 67, 30, 13);
		contentPane.add(lblTime);
		
		Choice choiceTime = new Choice();
		choiceTime.setEnabled(false);
		choiceTime.setBounds(196, 62, 98, 18);
		contentPane.add(choiceTime);
		choiceTime.add("");
		choiceTime.add("Sao Paulo");
		choiceTime.add("Corinthians");
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				
				time = em.find(Time.class, choiceTime.getSelectedItem());				
				
				if(time != null) {
					//identificar se o jogador é titular ou reserva para tratar cada
					//variavel da forma devida
					if (rdbtnTitular.isSelected()) {
						//inteiro que arazena o index do jogador titular na lista
						int indexOft1 = time.getJogadores().indexOf(t1);
						t1.setNome(txtNome.getText());
						t1.setIdade((int)spnIdade.getValue());
						t1.setNumero((int)spnNumero.getValue());
						t1.setPosicao(posicao.valueOf(choicePosicao.getSelectedItem()));
						
						em.getTransaction().begin();
						time.getJogadores().remove(indexOft1);
						em.merge(time);
						em.merge(t1);
						em.remove(t1);
				}else {
					//inteiro que arazena o index do jogador reserva na lista
					int indexOfr1 = time.getJogadores().indexOf(r1);
					r1.setNome(txtNome.getText());
					r1.setIdade((int)spnIdade.getValue());
					r1.setNumero((int)spnNumero.getValue());
					r1.setPosicao(posicao.valueOf(choicePosicao.getSelectedItem()));
					r1.setTime(time);
					
					em.getTransaction().begin();
					time.getJogadores().remove(indexOfr1);
					em.merge(time);
					em.merge(r1);
					em.remove(r1);
				}
				}
				em.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "Remoção Concluida");
				dispose();
			}
		});
		btnRemover.setBounds(309, 35, 98, 21);
		contentPane.add(btnRemover);		
		btnRemover.setEnabled(true);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r1 = em.find(Reserva.class, txtNome.getText());
				t1 = em.find(Titular.class, txtNome.getText());
				if (r1 != null || t1 != null)
					JOptionPane.showMessageDialog(null, "Jogador Encontrado");
				if (r1 != null) {
					txtNome.setEnabled(false);
					spnIdade.setEnabled(true);
					spnIdade.setValue(r1.getIdade());
					spnNumero.setEnabled(true);
					spnNumero.getValue();
					spnNumero.setValue(r1.getNumero());
					choicePosicao.setEnabled(true);
					choicePosicao.select(r1.getPosicao().ordinal() + 1);
					choiceTime.setEnabled(true);
					choiceTime.select(r1.getTime().getNome());
					txtNome.setText(r1.getNome());
					btnRemover.setEnabled(true);
				}else if (t1 != null) {
					txtNome.setEnabled(false);
					spnIdade.setEnabled(true);
					spnIdade.getValue();
					spnIdade.setValue(t1.getIdade());
					spnNumero.setEnabled(true);
					spnNumero.getValue();
					spnNumero.setValue(t1.getNumero());
					rdbtnTitular.setEnabled(true);
					rdbtnTitular.setSelected(true);
					choicePosicao.setEnabled(true);
					choicePosicao.select(t1.getPosicao().ordinal() + 1);
					choiceTime.setEnabled(true);
					choiceTime.select(t1.getTime().getNome());
					txtNome.setText(t1.getNome());
					btnRemover.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Jogador não existe");
				}
			}
		});
		btnBuscar.setBounds(309, 6, 98, 21);
		contentPane.add(btnBuscar);
	}
}
