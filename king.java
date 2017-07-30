package chessUtkarsh;

import javax.swing.JOptionPane;

public class king extends Simple{

	private static final long serialVersionUID = 1L;

	public static void Check(int R2, int C2) {
		switch(chessBoard[C2][R2]){
		case 'P' : if(R2==0)
				if(chessBoard[C2-1][R2+1]=='k')
					JOptionPane.showMessageDialog(null, "Wow white pawn you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);
			else if(R2==7)
				if(chessBoard[C2-1][R2-1]=='k')	
					JOptionPane.showMessageDialog(null, "Wow white pawn you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);
			else if(chessBoard[C2-1][R2-1]=='k' | chessBoard[C2-1][R2+1]=='k')
				JOptionPane.showMessageDialog(null, "Wow white pawn you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);
			break;
				
		case 'p' : if(R2==0)
				if(chessBoard[C2-1][R2+1]=='K')
					JOptionPane.showMessageDialog(null, "Wow black pawn you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);
			else if(R2==7)
				if(chessBoard[C2-1][R2-1]=='K')	
					JOptionPane.showMessageDialog(null, "Wow black pawn you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);
			else if(chessBoard[C2-1][R2-1]=='K' | chessBoard[C2-1][R2+1]=='K')
				JOptionPane.showMessageDialog(null, "Wow black pawn you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);
			break;
				
		case 'N' : if(Math.abs(kC-C2)*Math.abs(kR-R2)==2)
			JOptionPane.showMessageDialog(null, "Wow white Knight you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);break;
		
		case 'n' : if(Math.abs(KC-C2)*Math.abs(KR-R2)==2)
			JOptionPane.showMessageDialog(null, "Wow black Knight you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);break;
		case 'R' : if(R2==kR | kC==C2){
				if(noPieceRook(R2,C2,kR,kC))
					JOptionPane.showMessageDialog(null, "Wow white Rook you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}break;
		
		case 'r' : if(R2==KR | KC==C2){
				if(noPieceRook(R2,C2,KR,KC))
					JOptionPane.showMessageDialog(null, "Wow black Rook you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}break;
			
		case 'B' : if(Math.abs(C2-kC)==Math.abs(R2-kR)){
				if(noPieceBishop(R2, C2, kR, kC))
					JOptionPane.showMessageDialog(null, "Wow white Bishop you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}break;
		case 'b' :	if(Math.abs(C2-KC)==Math.abs(R2-KR)){
				if(noPieceBishop(R2, C2, KR, KC))
					JOptionPane.showMessageDialog(null, "Wow black Bishop you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}break;
		
		case 'Q' : if(Math.abs(kC-C2)==Math.abs(kR-R2)){
				if(noPieceBishop(R2, C2 , kR, kC))
					JOptionPane.showMessageDialog(null, "Wow white Queen you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}
				else if(R2==kR | kC==C2){
					if(noPieceRook( R2,C2, kR, kC ))
						JOptionPane.showMessageDialog(null, "Wow white Queen you just checked black king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}break;
				
		case 'q' : if(Math.abs(KC-C2)==Math.abs(KR-R2)){
				if(noPieceBishop(R2, C2 , KR, KC))
					JOptionPane.showMessageDialog(null, "Wow black Queen you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}
				else if(R2==KR | KC==C2){
					if(noPieceRook( R2,C2, KR, KC ))
						JOptionPane.showMessageDialog(null, "Wow black Queen you just checked white king", "Check Warning", JOptionPane.WARNING_MESSAGE);
				}break;
		}
	}
}
