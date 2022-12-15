package PROJETO;

import PROJETO.Tabuleiro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Menu {

	JFrame janela;
	JPanel pnlPainel;
	int x, y, n2, n3, n4;
	
	public Menu() {
	
		Font f = new Font("SansSerif",Font.BOLD, 16);
		
		janela = new JFrame("PROJETO.Menu Batalha Naval");
		janela.setResizable(false);
		janela.setBounds(300, 250, 550, 500);

		pnlPainel = new JPanel();
		pnlPainel.setLayout(null);
		pnlPainel.setBounds(0, 0, janela.getWidth(), janela.getHeight());
		janela.getContentPane().add(pnlPainel); 
		
		JLabel lblImagem, lblx, lbly, lblnome, lbl2, lbl3, lbl4;
		JTextField txtx, txty, txt2, txt3, txt4;
		JButton btnJogar, btnSair;
		
		//Caixas de Informa��es
		
		lblnome = new JLabel("FIGHTING IN THE SEAS: THE GAME");
		lblnome.setBounds(200, 70, 350, 20);
		pnlPainel.add(lblnome);
		lblnome.setFont(f);
		
		lblx = new JLabel("Digite o n�mero de linhas de seu tabuleiro:");
		lblx.setBounds(50, 200, 350, 20);
		pnlPainel.add(lblx);
		txtx = new JTextField();
		txtx.setBounds(50, 225, 100, 20);
		pnlPainel.add(txtx);
		
		lbly = new JLabel("Digite o n�mero de colunas de seu tabuleiro:");
		lbly.setBounds(50, 245, 350, 20);
		pnlPainel.add(lbly);
		txty = new JTextField();
		txty.setBounds(50, 265, 100, 20);
		pnlPainel.add(txty);
		
		lbl2 = new JLabel("Digite o n�mero de barcos 2x1:");
		lbl2.setBounds(50, 285, 350, 20);
		pnlPainel.add(lbl2);
		txt2 = new JTextField();
		txt2.setBounds(50, 305, 100, 20);
		pnlPainel.add(txt2);
		
		lbl3 = new JLabel("Digite o n�mero de barcos 3x1:");
		lbl3.setBounds(50, 325, 350, 20);
		pnlPainel.add(lbl3);
		txt3 = new JTextField();
		txt3.setBounds(50, 345, 100, 20);
		pnlPainel.add(txt3);

		
		lbl4 = new JLabel("Digite o n�mero de barcos 4x1:");
		lbl4.setBounds(50, 365, 350, 20);
		pnlPainel.add(lbl4);
		txt4 = new JTextField();
		txt4.setBounds(50, 385, 100, 20);
		pnlPainel.add(txt4);

		
		//Caixas de Informa��es
		
		//Icone
		
		ImageIcon imgFigura = new ImageIcon("logo.png");
		Image im = imgFigura.getImage();
		int a, b, c=150;
		a = imgFigura.getIconWidth();
		b = imgFigura.getIconHeight();
		Image novaimg = im.getScaledInstance((c*a)/b, c, 
					java.awt.Image.SCALE_SMOOTH);  
		imgFigura = new ImageIcon(novaimg);

		lblImagem = new JLabel(imgFigura);
		lblImagem.setBounds(30, 30,
		imgFigura.getIconWidth(),
		imgFigura.getIconHeight());
		pnlPainel.add(lblImagem);
		
		//Icone
		
		//Bot�es
		
		btnJogar = new JButton ("Jogar");
		btnJogar.setBounds(75, 410, 100, 20);
		pnlPainel.add(btnJogar);
		
		btnSair = new JButton ("Sair");
		btnSair.setBounds(200, 410, 100, 20);
		pnlPainel.add(btnSair);
			
		ActionListener alJogar, alSair;
		
		alJogar = new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				int x = Integer.parseInt(txtx.getText());
				int y = Integer.parseInt(txty.getText());
				int n4 = Integer.parseInt(txt4.getText());
				int n3 = Integer.parseInt(txt3.getText());
				int n2 = Integer.parseInt(txt2.getText());
				Tabuleiro tela = new Tabuleiro(x, y/*, n2, n3, n4*/);
				janela.setVisible(false);
				
			}
		};
		
		alSair = new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
			
				janela.setVisible(false);
				
			}
		};
		
		btnJogar.addActionListener(alJogar);
		btnSair.addActionListener(alSair);
		
		//Bot�es
		
		
		janela.setVisible(true);
	}

}
