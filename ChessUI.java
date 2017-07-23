package chessUtkarsh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ChessUI extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	
	/*x and y denotes the coordinates of the mouse-click where 0,0 is the upper left corner.
	  When counter's value is 1, it means we have to select the piece and 2 means to place the selected piece.
	  playerTurn 1 means white and 2 means black.
	  R1, C1 takes the value of x & y when counter is 1, ie, while selecting the piece.
	  R2, C2 takes the value of x & y when counter is 2, ie, while placing the piece.
	  KC,KR denotes white king's position while kC, kR denotes black king's position.
	  valid1 tells us whether we have our own piece.
	  If its true then valid2 tells us whether the target position contains our own piece.
	  If it true (ie, target location does not contain our piece),
	  then valid3 validates whether the move taken is correct or not.
	  If valid2 is false then the selected piece changes. like you are player white and u selected a pawn then 
	  you clicked a white horse, then our selected piece changes from pawn to horse. 
	*/
	
	public static int x=0,y=0,counter=1,playerTurn=1,R1=0,C1=0,R2=0,C2=0,KC=7;
	private Image img;
	private static Color brown = new Color(150,76,0);
	private static Color yellow = new Color(255,217,23);
	private Image img2 = new ImageIcon("white1.png").getImage();
	private Image img3 = new ImageIcon("black1.png").getImage();
	Simple s;
	
	public static boolean valid1,valid2,valid3,reset=false;
	
	//this function is the base of our program. It is called first and it calls all the functions and booleans.
	
	@Override
    public void paint(Graphics g) 
	{
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        printBoard(g);
        
        printPieces(g);
        this.addMouseListener(this);					// adding mouse listener at every turn.
        //if (playerTurn==1 && counter%2==1)
        g.drawImage(img2, 160,500, 196, 63, this);
        //else if (playerTurn==2 && counter%2==1)
        //	g.drawImage(img3, 160,500, 196, 63, this);	*/
        if((x<=450 && x>=50)&&(y<=450 && y>=50))
        {
        	x/=50;
			x*=50;
			y/=50;
			y*=50;
			
			//Our chessBoard starts with 0,0 in the upper left corner. the above lines rounds up the
			//values in the multiple of 50. As every square has a side of 50.
			if(playerTurn%2==1)				// changes player turn
   				playerTurn=1;
   			else
   				playerTurn=2;
   			
   			if(counter%2==1)				//changes counter
   				counter=1;
   			else
   				counter=2;
   			if(playerTurn==1){
   				if(counter==1){
   					printwhite(g);
   					R1=(x-50)/50;				// this line converts the value of x & y in 50s
   	   				C1=(y-50)/50;				// to suitable no. between and including 0 to 7
   	   				System.out.println(counter+" "+"Row "+R1+" Column "+C1+" "+"player 1 counter 1");
   	   				valid1=MouseClick.isSelectedPieceWhite(R1, C1);			
   	   				if(valid1)
   	   	   				counter++;			//if piece is selected correctly then counter increases
   				}
   				else if(counter==2){
   					printblack(g);
   					R2=(x-50)/50;
   	   				C2=(y-50)/50;
   	   				System.out.println(counter+" "+"Row "+R1+" Column "+C1+" "+"player 1 counter 2");
   	   				valid2 = MouseClick.isTargetPieceWhite(R2, C2);
   	   				if(!valid2){			// changes the selected piece
   	   					R1=R2;
   	   					C1=C2;
   	   				}
   	   				if(valid2){
   	   					valid3= Simple.validateMove(R1, C1, R2, C2);			// validates the move
   	   					if(valid3){
   	   						printblack(g);
   	   						printPieces(g);
   	   						king.Check(R2,C2);			// check whether the opponent's King is checked
   	   						if(C1==1 && C2==0)
   	   							queen.promotion(R2, C2);
   	   						paint(g);							// repaints the entire structure.
   	   						counter++;
	   						playerTurn++;
   	   					}
   	   				}
   				}
   			}
   			
   			else if(playerTurn==2){				// same code for player black
   				if(counter==1){
   					printblack(g);
   					R1=(x-50)/50;
   	   				C1=(y-50)/50;
   	   				System.out.println(counter+" "+"Row "+R1+" Column "+C1+" "+"player 2 counter 1");
   	   				valid1=MouseClick.isSelectedPieceBlack(R1, C1);
   	   				if(valid1)
   	   					counter++;
   				}
   				else if(counter==2){
   					printwhite(g);
   					R2=(x-50)/50;
   	   				C2=(y-50)/50;
   	   				System.out.println(counter+" "+"Row "+R1+" Column "+C1+" "+"player 1 counter 2");
   	   				valid2 = MouseClick.isTargetPieceBlack(R2, C2);
   	   				if(!valid2){
	   					R1=R2;
	   					C1=C2;
	   				}
	   				if(valid2){
	   					valid3= Simple.validateMove(R1, C1, R2, C2);
	   					if(valid3){
	   						printwhite(g);
   	   						printPieces(g);
   	   						king.Check(R2,C2);
   	   						if(C1==6 && C2==7)
   	   							queen.promotion(R2, C2);
   	   						paint(g);
   	   						counter++;
	   						playerTurn++;
   	   					}
	   				}
   				}
   			}	
       		System.out.println();    		
       	}
        
	}
  
   
	private void printwhite(Graphics g) {
    	g.drawImage(img2, 160,500, 196, 63, this);
	}
    private void printblack(Graphics g) {
    	g.drawImage(img3, 160,500, 196, 63, this);
	}
	@Override
	public void mousePressed(MouseEvent e) {}
   
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
   
    public void mouseClicked(MouseEvent e) {
    	  x=e.getX();				//taking the values of mouse click and storing it in x & y
          y=e.getY();
          repaint();
          
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
   
    void printBoard(Graphics g)				// printing the entire 64 squares.
    {
        g.setColor(yellow);						// this is algorithm to paint 64 squares of the chessboard
        for(int i = 50; i <= 400; i+=100){
            for(int j = 50; j <= 400; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        }
        for(int i = 100; i <= 450; i+=100){
            for(int j = 100; j <= 450; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        
        }
        g.setColor(brown);
        for(int i = 100; i <= 400; i+=100){
            for(int j = 50; j <= 400; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        }
        for(int i = 50; i <= 400; i+=100){
            for(int j = 100; j <= 450; j+=100){
                g.fillRect(i, j, 50, 50);
            }
        }
    }
    
    /*
     it prints the current character 2d array on the chessBoard
     it contains all the images. it sets the size of picture to 50*50 pixels
     */
    void printPieces(Graphics g)			
    {
    	for(int i=0;i<8;i++){				
    		for(int j=0;j<8;j++)
    		{
    			if(Simple.chessBoard[i][j]<='z' && Simple.chessBoard[i][j]>='a')
    			{
    				img = new ImageIcon("b"+Simple.chessBoard[i][j]+".png").getImage();
    				g.drawImage(img, 50+(50*j),50+(50*i), 50,50, this);
    			}
    			if(Simple.chessBoard[i][j]<='Z' && Simple.chessBoard[i][j]>='A')
    			{
    				img = new ImageIcon("w"+Simple.chessBoard[i][j]+".png").getImage();
    				g.drawImage(img, 50+(50*j),50+(50*i), 50,50, this);
    			}
    				
    		}
    		
    	}
    	if(reset){				// called when there is checkmate
        	int phj=(int)JOptionPane.showConfirmDialog(null, "Do you want to play again", "New game", JOptionPane.OK_CANCEL_OPTION);
        	System.out.println(phj);				// if yes then the following commands introduces the new game 
        	if(phj==0){
        		printBoard(g);
        		playerTurn=1;
        		counter=1;
        		for(int i=0;i<8;i++){				
            		for(int j=0;j<8;j++)
            		{
            			Simple.chessBoard[i][j]=Simple.resetBoard[i][j];
            			if(Simple.chessBoard[i][j]<='z' && Simple.chessBoard[i][j]>='a')
            			{
            				img = new ImageIcon("b"+Simple.chessBoard[i][j]+".png").getImage();
            				g.drawImage(img, 50+(50*j),50+(50*i), 50,50, this);
            			}
            			if(Simple.chessBoard[i][j]<='Z' && Simple.chessBoard[i][j]>='A')
            			{
            				img = new ImageIcon("w"+Simple.chessBoard[i][j]+".png").getImage();
            				g.drawImage(img, 50+(50*j),50+(50*i), 50,50, this);
            			}
            				
            		}
            		
            	}
        		repaint();
        	//	Simple.chessBoard[i][j]=Simple.resetBoard[i][j];
        		reset=false;
        	}
        	else if(phj==2){
        		System.exit(0);
        	}
        	
        }
    	//img2 = new ImageIcon("wb.png").getImage();
       
    }
	
	public static void main(String[] args) {
		JFrame f=new JFrame("CHESS GAME");			// creates a jframe with title CHESS GAME	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChessUI ui=new ChessUI();			// creates an object ui of class ChessUI()
        f.add(ui);							// adding the object to the frame
        f.setSize(510, 590);				// size of frame
        f.setVisible(true);
        f.setLocationRelativeTo(null);		// centre of screen
        f.setResizable(false);
     //   Foo foo=new Foo();
     /*   p=new JPanel();
        p.setPreferredSize(new Dimension(200,100));
        f.add(p.BorderLayout.SOUTH);
        JLabel jl=new JLabel("White turn");
        p.add(jl);	*/
	}
}