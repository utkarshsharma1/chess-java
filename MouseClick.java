package chessUtkarsh;

public class MouseClick extends Simple{
	private static final long serialVersionUID = 1L;

	public static boolean isSelectedPieceWhite(int r12, int c12) {
    	R1=r12; C1=c12;
		if(chessBoard[C1][R1]>='A' & chessBoard[C1][R1]<='Z'){
			System.out.println("Good work dear white");
			return true;}
		else {
			System.out.println("This is not your piece dear white, click again");
			return false;}
	}

	public static boolean isSelectedPieceBlack(int r12, int c12) {
		R1=r12; C1=c12;
		if(chessBoard[C1][R1]>='a' & chessBoard[C1][R1]<='z'){
			System.out.println("Good work dear black");
			return true;}
		else {
			System.out.println("This is not your piece dear black, click again");
			return false;}
	}

	public static boolean isTargetPieceWhite(int r22, int c22) {
		R2=r22; C2=c22;
		if(chessBoard[C2][R2]>='A' & chessBoard[C2][R2]<='Z'){
			System.out.println("You changed your selected piece dear white ");
			return false;
		}
		else
			return true;
	}

	public static boolean isTargetPieceBlack(int r22, int c22) {
		R2=r22; C2=c22;
		if(chessBoard[C2][R2]>='a' & chessBoard[C2][R2]<='z'){
			System.out.println("You changed your selected piece dear black");
			return false;
		}
		else
			return true;
	}	
}