package tictactoe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class selecione extends JFrame {

	protected static int jogadorVez;
	private JPanel contentPane;
	private JTextField txtSelecionaOu;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selecione frame = new selecione();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criando o selecionador do jogo da velha simples.
	 */
	public selecione() {
		setTitle("Selecionar o Jogador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Player Imbrochável");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lab\\Downloads\\Novo Projeto (4).png"));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Variável da classe jogo da veia inicializadas com o valor 1 
				JogoDaVelha.jogadorVez = 1;
				JogoDaVelha frame = null;
				try {
					//É criado um objeto do jframe/classe "JogoDaVelha"
					frame = new JogoDaVelha();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//A visibilidade da classe JogoDaVelha é setada como verdadeira
				frame.setVisible(true);
				//libera os recursos do sistema operacional relacionados a janela
				dispose();
			}
			
		});
		btnNewButton.setBounds(27, 74, 195, 176);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Jogador Nine Fingers");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\lab\\Downloads\\Novo Projeto (3).png"));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogoDaVelha.jogadorVez = 2;
				JogoDaVelha frame = null;
				try {
					frame = new JogoDaVelha();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(281, 74, 195, 176);
		contentPane.add(btnNewButton_1);
		
		txtSelecionaOu = new JTextField();
		txtSelecionaOu.setEditable(false);
		txtSelecionaOu.setForeground(new Color(0, 0, 255));
		txtSelecionaOu.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		txtSelecionaOu.setBackground(new Color(128, 255, 0));
		txtSelecionaOu.setText("Seleciona 22 ou 13 para jogar:");
		txtSelecionaOu.setBounds(76, 24, 360, 45);
		contentPane.add(txtSelecionaOu);
		txtSelecionaOu.setColumns(10);
	}
}
