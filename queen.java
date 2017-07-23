package chessUtkarsh;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class queen extends Simple{

	private static final long serialVersionUID = 1L;
	private static final String[] choice={"Queen", "Rook", "Bishop", "Knight"};
	public static void promotion(int R2, int C2) {
		if(chessBoard[C2][R2]=='Q' & C2==0){
			JFrame f=new JFrame("Promotion");
			String a=(String) JOptionPane.showInputDialog(f, "Select your choice", "Promotion", JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
			if(a.equals("Rook"))
				chessBoard[C2][R2]='R';
			else if(a.equals("Queen"))
				chessBoard[C2][R2]='Q';
			else if(a.equals("Knight"))
				chessBoard[C2][R2]='N';
			else if(a.equals("Bishop"))
				chessBoard[C2][R2]='B';
		}
		else if(chessBoard[C2][R2]=='q' & C2==7){
			JFrame f=new JFrame("Promotion");
			String a=(String) JOptionPane.showInputDialog(f, "Select your choice", "Promotion", JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
			if(a.equals("Rook"))
				chessBoard[C2][R2]='r';
			else if(a.equals("Queen"))
				chessBoard[C2][R2]='q';
			else if(a.equals("Knight"))
				chessBoard[C2][R2]='n';
			else if(a.equals("Bishop"))
				chessBoard[C2][R2]='b';
		}
	}
}
