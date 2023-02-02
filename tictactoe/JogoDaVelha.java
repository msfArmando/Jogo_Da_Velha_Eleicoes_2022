package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JogoDaVelha extends JFrame{

	ImageIcon iconCirculo = new ImageIcon(getClass().getResource("circulo.png"));
	ImageIcon iconX = new ImageIcon(getClass().getResource("x.png"));

	JPanel pTela = new JPanel(new GridLayout(3, 3, 10, 10));
	
	//Array com as nove janelas onde ocorrerá a verificação e as jogadas
	Bloco[] blocos = new Bloco[9];

	int rodadas = 0;
	
	//Variáveis inicializadas
	final static int JOGADOR_1 = 1;
	final int JOGADOR_2 = 2;
	
	//O valor inicial é 1, mas pode ser mudado pelo selecione
	public static int jogadorVez = JOGADOR_1;

	JLabel lInformacao = new JLabel("Jogo do  Velho Bolsonaro");

	public JogoDaVelha() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		configurarJanela();
		configurarTela();
	}

	public void configurarTela() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		getContentPane().setLayout(null);
		pTela.setBounds(10, 56, 584, 520);
		getContentPane().add(pTela);
		pTela.setBackground(new Color(0, 0, 0));
		lInformacao.setBounds(10, -58, 584, 166);
		getContentPane().add(lInformacao);
		lInformacao.setFont(new Font("Arial",Font.BOLD,35));
		lInformacao.setForeground(new Color(0, 0, 128));
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);

		for(int i=0;i<9;i++) {
			Bloco bloco = new Bloco();
			blocos[i] = bloco;
			pTela.add(bloco);
		}
	}
	
	
	public void mudarVez(){
		if(jogadorVez==1) {
			//Se a vez estiver como um, ao método ser chamado a vez é mudada para 2
			jogadorVez=2;
			lInformacao.setText("Vez de: Molusco");
			lInformacao.setForeground(Color.RED);
		} else {
			jogadorVez=1;
			lInformacao.setText("Vez de: Bonoro");
			lInformacao.setForeground(new Color(50,200,50));
		}
	}

	//Aqui ocorrem as verificações com o valor quem, que é colocado no parametro "jog"
	public boolean testarVitoria(int jog) {
		if(blocos[0].quem==jog && blocos[1].quem==jog && blocos[2].quem==jog) {
			return true;
		}
		if(blocos[3].quem==jog && blocos[4].quem==jog && blocos[5].quem==jog) {
			return true;
		}
		if(blocos[6].quem==jog && blocos[7].quem==jog && blocos[8].quem==jog) {
			return true;
		}
		if(blocos[0].quem==jog && blocos[3].quem==jog && blocos[6].quem==jog) {
			return true;
		}
		if(blocos[1].quem==jog && blocos[4].quem==jog && blocos[7].quem==jog) {
			return true;
		}
		if(blocos[2].quem==jog && blocos[5].quem==jog && blocos[8].quem==jog) {
			return true;
		}
		if(blocos[0].quem==jog && blocos[4].quem==jog && blocos[8].quem==jog) {
			return true;
		}
		if(blocos[2].quem==jog && blocos[4].quem==jog && blocos[6].quem==jog) {
			return true;
		}
		return false;
	}

	public void configurarJanela() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		new JogoDaVelha();		
	}

	public class Bloco extends JButton{
		
		
		
		int quem = 0;
		public Bloco() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
			
			File file = new File("Baudio.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			
			File fileL = new File("Picanha.wav");
			AudioInputStream audioStreamL = AudioSystem.getAudioInputStream(fileL);
			Clip clipL = AudioSystem.getClip();
			clipL.open(audioStreamL);
			
			setBackground(Color.WHITE);
			addActionListener(e->{
				//Aqui dependendo de quem for a vez, o valor do "jogadorVez" será trocado, se jogadorVez for igual a 2, o ícone será adicionado de acordo com o valor desta variável
				if(quem==0) {
					if(jogadorVez==JOGADOR_1) {
						setIcon(iconCirculo);
						if(quem==JOGADOR_2) {
							clipL.stop();
						}
						else {
							clip.start();
						}
						quem = JOGADOR_1;
					} else {
						setIcon(iconX);
						if(quem==JOGADOR_1) {
							clip.stop();
						}
						else {
							clipL.start();
						}
						quem = JOGADOR_2;
					}
					//A cada jogada que é feita o testar vitoria é executado, se for verdadeiro, ele executa o que está dentro do if e a quantidade de rodadas é somada
					if(testarVitoria(quem)) {
						JOptionPane.showMessageDialog(null,"Jogador "+((quem == 1)?"Brasil":"Vermelho")+" Venceu!");
						//System.exit(0);

						selecione frame = new selecione();
						frame.setVisible(true);
						dispose();
					}
					rodadas++;
					//Excedendo o número máximo, 9, da velha
					if(rodadas==9) {
						JOptionPane.showMessageDialog(null,"Deu velha!");
						//System.exit(0);

						selecione frame = new selecione();
						frame.setVisible(true);
						dispose();
					}
					//No final deste ciclo, a vez é mudada
					mudarVez();
				}
			});
		}
	}

}