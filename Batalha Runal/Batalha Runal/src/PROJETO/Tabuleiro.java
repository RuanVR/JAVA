package PROJETO;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tabuleiro {

	JFrame frame;
	JPanel pnlPainel;
	ImageIcon Mar, MarX, Nada;
	Integer matriza[][];
	//private Integer matrizb[][] = new Integer[3][3];
	
	public Tabuleiro(int x, int y/*, int n2, int n3, int n4*/ )
	{
		
		int Q = 50 + (37 * x);
		
		int t1 = ((x * 37) * 2) + Q; 
		int t2 = (y * 37) + 200; 
		
		this.matriza = new Integer[x][y];
		
		//Crio e configuro Janela
		this.frame = new JFrame("PROJETO.Tabuleiro");
		this.frame.setResizable(false);
		this.frame.setBounds(100, 100, t1, t2);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Crio e configuro Painel principal
		this.pnlPainel = new JPanel();
		this.pnlPainel.setLayout(null);
		this.pnlPainel.setBounds(0, 0, this.frame.getWidth(), this.frame.getHeight());
		this.frame.getContentPane().add(this.pnlPainel); 

		//Imagens
		
		Mar = new ImageIcon("Mar.png");
	    Image image = Mar.getImage();
	    Image newimg = image.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);  
	    Mar = new ImageIcon(newimg);

	    MarX = new ImageIcon("MarX.png");
	    image = MarX.getImage();
	    newimg = image.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);  
	    MarX = new ImageIcon(newimg);
	    
	    Nada = new ImageIcon("logo.png");
	    image = Nada.getImage();
	    newimg = image.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);  
	    Nada = new ImageIcon(newimg);
	    
	    //Imagens
	    
	    MouseListener mlClickImagem = new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel temp = (JLabel) arg0.getSource();
				JLabel temp2 = (JLabel) arg0.getSource();
				temp.setSize(100, 100);
				temp2.setSize(100, 100);
				mudaImagem(temp);
				mudaImagem2(temp2);
			}
		};

		//TABULEIRO 1	

	    JLabel lblTab1, lbltab1;
	    
	    lbltab1 = new JLabel("PROJETO.Tabuleiro do Jogador 1");
		lbltab1.setBounds(20, 10, 200, 20);
		pnlPainel.add(lbltab1);
	    
	    int lin, col, qImagem, posLin = 20, posCol = 10;
	    for(lin = 0; lin < x; lin++) {
	    	Random aleatorio = new Random();
		    for(col = 0; col < y; col++) {
	
		    	matriza[lin][col] = 1;
		    	
		    	lblTab1 = new JLabel();
		    	lblTab1.setBounds(posLin, posCol, 100, 100);
		    	   
		   		    	
		   		lblTab1.setIcon(Mar);
		    	
			    lblTab1.addMouseListener(mlClickImagem);
			    this.pnlPainel.add(lblTab1);
			    posCol = posCol + 37;
			    
		    }
		    
	    	posLin = posLin + 37;
		    posCol = 10;
	    }
	    
	    //Tabuleiro1
	    
	    //QUADRO
	    
	    JLabel lblQuadro;
	    
	    int vez = 1;
	    
	    if(vez == 1){
	    	lblQuadro = new JLabel("Vez do Jogador 1");
	    	lblQuadro.setBounds(Q, 100, 200, 20);
			pnlPainel.add(lblQuadro);
	    }
	    
	    if(vez == 2){
	    	lblQuadro = new JLabel("Vez do Jogador 2");
	    	lblQuadro.setBounds(Q, 100, 200, 20);
			pnlPainel.add(lblQuadro);
	    }
	    
	    //QUADRO
	    
	    //PROJETO.Tabuleiro 2
	    
	    JLabel lblTab2, lbltab2;
	      
	    int linha, coluna, qImag, posLin2 = Q + 140, posCol2 = 10;
	    for(linha = 0; linha < x; linha++) {
	    	
		    for(coluna = 0; coluna < y; coluna++) {
		    	
		    	
		    	lblTab2 = new JLabel();
		    	lblTab2.setBounds(posLin2, posCol2, 100, 100);
		    	
		    		lblTab2.setIcon(Mar);
		    	
			    lblTab2.addMouseListener(mlClickImagem);
			    this.pnlPainel.add(lblTab2);
			    posCol2 = posCol2 + 37;
			    
		    }
		    
	    	posLin2 = posLin2 + 37;
		    posCol2 = 10;
	    }
	    
	    lbltab2 = new JLabel("PROJETO.Tabuleiro do Jogador 2");
		lbltab2.setBounds((Q + 140), 10, 200, 20);
		pnlPainel.add(lbltab2);
	    
	    //PROJETO.Tabuleiro 2
	    
		frame.setVisible(true);
	}
	
	public void mudaImagem(JLabel temp) {
		int posX, posY;
		Point ponto = temp.getLocation();
		posX = ((ponto.x - 20) / 37);
		posY = ((ponto.y - 10) / 37);
		if(matriza[posX][posY] == 1) {
			matriza[posX][posY] = 2;
		    temp.setIcon(Nada);
		}
		else {
			matriza[posX][posY] = 1;
		    temp.setIcon(Nada);
		}
	}
	
	public void mudaImagem2(JLabel temp2) {
		int posX, posY;
		Point ponto = temp2.getLocation();
		posX = ((ponto.x - 20) / 37);
		posY = ((ponto.y - 10) / 37);
		if(matriza[posX][posY] == 1) {
			matriza[posX][posY] = 2;
		    temp2.setIcon(Nada);
		}
		else {
			matriza[posX][posY] = 1;
		    temp2.setIcon(Nada);
		}
	}
	
	
}	