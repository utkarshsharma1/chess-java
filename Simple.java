package chessUtkarsh;

import javax.swing.JOptionPane;

public class Simple extends ChessUI{
	private static final long serialVersionUID = 1L;
	
	/* 
	 	a,b,c,d stores the values of R1, C1, R2, C2. it makes a copy of it, thus originals are passed 
	 	over to next class. whiteRook1/2, blackRook1/2 , whiteKing , blackKing are used only for castling.
	 	Its value is set as 1. if it increases by one then it means they have taken a move and castling fails.
	 	KR, KC denotes rows and columns of wite king whereas kR, kC denotes of black king.
	 	chessBoard is a character 2d array on which all the characters (pieces) are changed.
	 */
	private static boolean isMoveValid ;
	private static int a,b,c,d,whiteRook1=1,blackRook1=1,whiteKing=1,blackKing=1,whiteRook2=1,blackRook2=1;
	public static int R1,C1,R2,C2,KR=3,kC=0,KC=7,kR=3;
    public static char[][] chessBoard={
            {'r','n','b','k','q','b','n','r'},
            {'p','p','p','p','p','p','p','p'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-','-'},
            {'P','P','P','P','P','P','P','P'},
            {'R','N','B','K','Q','B','N','R'}};
    public static char[][] resetBoard={
        {'r','n','b','k','q','b','n','r'},
        {'p','p','p','p','p','p','p','p'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'-','-','-','-','-','-','-','-'},
        {'P','P','P','P','P','P','P','P'},
        {'R','N','B','K','Q','B','N','R'}};
    
    private static void showBoard()
    {	
    	 for(int i=0;i<8;i++)
    	 {
    		 for(int j=0;j<8;j++)
    		 {
    			 System.out.print(chessBoard[i][j]);
    			 System.out.print(' ');
    		 }
    		 System.out.println();
    	 }
    }

    private static boolean blackPiece(int target_col, int target_row)
    {
     	if(chessBoard[target_row][target_col]<='z' & chessBoard[target_row][target_col]>='a')
     		return true;
     	else
     		return false;
    }
    
    private static boolean whitePiece(int target_col, int target_row)
    {
     	if(chessBoard[target_row][target_col]<='Z' & chessBoard[target_row][target_col]>='A')
     		return true;
     	else
     		return false;
    }

    private static boolean noPiece(int target_col,int target_row)
    {
    	if(chessBoard[target_row][target_col]=='-')
    		return true;
    	else
    		return false;
    }

    public static boolean noPieceRook(int R1, int C1, int R2, int C2)
    {
    	if(R1==R2){
    		if(C1<C2){
    			for(int i=C1+1;i<C2;i++){
    				if(chessBoard[i][R1]!='-')
    					return false;
    			}
    		}
    		else{
    			for(int i=C1-1;i>C2;i--){
    				if(chessBoard[i][R1]!='-')
    					return false;
    			}
    		}
    	}
    	else{
    		if(R1<R2){
    			for(int i=R1+1;i<R2;i++){
    				if(chessBoard[C1][i]!='-')
    					return false;
    			}
    		}
    		else{
    			for(int i=R1-1;i>R2;i--){
    				if(chessBoard[C1][i]!='-')
    					return false;
    			}
    		}
    	}
    	return true;
    }

    public static boolean noPieceBishop(int R1,int C1, int R2, int C2)
    {
    	
		 if(C1-C2>0){
	        if(R1-R2>0){
	        	for(int i=1;i<Math.abs(R1-R2);i++){
	        		if(chessBoard[C1-i][R1-i]!='-')
	            	   return false;
	                }
	            }
	        if(R1-R2<0){
	        	for(int i=1;i<Math.abs(R1-R2);i++){
	        		if(chessBoard[C1-i][R1+i]!='-')
	                	return false;
	                }
	           }
		 }
		 else if(C1-C2<0){
			if(R1-R2<0){
		       	for(int i=1;i<Math.abs(R1-R2);i++){
		       		if(chessBoard[C1+i][R1+i]!='-')
		           	   return false;
		            }
		        }
		     if(R1-R2>0){
		       	for(int i=1;i<Math.abs(R1-R2);i++){
		     		if(chessBoard[C1+i][R1-i]!='-')
		               	return false;
		            }
		     	}
		 	}
		return true;
    }
  
    public static boolean validateMove(int p, int q, int r, int s)
    {	
   	 	R1 = p;
		C1 = q;
		R2 = r;
		C2 = s;
		a = R1; b = C1; c = R2; d = C2;
		isMoveValid =validate(chessBoard[C1][R1],R1,C1,R2,C2);
		if(isMoveValid)
		{
			
			if(chessBoard[d][c]=='K'){
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						chessBoard[i][j]='-';
					}
				}
				JOptionPane.showMessageDialog(null, "Congrats Black !!!", "Check Warning", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Congrats Black won the game !!!");
				//JOptionPane.showConfirmDialog(null, "Do you want to play again", "New game", JOptionPane.OK_CANCEL_OPTION);
				reset=true;
			}
			else if(chessBoard[d][c]=='k'){
				for(int i=0;i<8;i++){
					for(int j=0;j<8;j++){
						chessBoard[i][j]='-';
					}
				}
				JOptionPane.showMessageDialog(null, "Congrats white !!!", "Check Warning", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Congrats White  won the game !!!");
				reset=true;
			}
			else if(chessBoard[b][a]=='P' & d==0){
				chessBoard[d][c]='Q';
				chessBoard[b][a] = '-';
				showBoard();
			}
			else if(chessBoard[b][a]=='p' & d==7){
				chessBoard[d][c]='q';
				chessBoard[b][a] = '-';
				showBoard();
			}
			else if(chessBoard[d][c]=='K'){
				KR=c;KC=d;
			}
			else if(chessBoard[d][c]=='k'){
				kR=c;kC=d;
			}
			else if(a==3 & b==7 & c==1 & d==7 & whiteKing==1 & whiteRook1==1){
				chessBoard[d][c]='K';
				chessBoard[7][0]='-';
				chessBoard[b][a]='-';
				chessBoard[7][2]='R';
				showBoard();
			}
			else if(a==3 & b==0 & c==1 & d==0 & blackKing==1 & blackRook1==1){
				chessBoard[d][c]='k';
				chessBoard[0][0]='-';
				chessBoard[b][a]='-';
				chessBoard[0][2]='r';
				showBoard();
			}
			else if(a==3 & b==7 & c==5 & d==7 & whiteKing==1 & whiteRook2==1){
   				chessBoard[d][c]='K';
   				chessBoard[7][7]='-';
      			chessBoard[b][a]='-';
       			chessBoard[7][4]='R';
       			showBoard();
   			}
        	else if(a==3 & b==0 & c==5 & d==0 & blackKing==1 & blackRook2==1){
        		chessBoard[d][c]='k';
       			chessBoard[0][0]='-';
   				chessBoard[b][a]='-';
   				chessBoard[0][4]='r';
   				showBoard();
   			}
			else{
				if(chessBoard[b][a]=='K'){
					KC=d;KR=c;
				}
				else if(chessBoard[b][a]=='k'){
					kC=d;kR=c;
				}
				chessBoard[d][c] = chessBoard[b][a];
				chessBoard[b][a] = '-';
				showBoard();
			}
			System.out.println("White king position is "+KR +" "+KC+" and black king position is "+kR+" "+kC);
		}
		else
			System.out.println("Invalid Move");
		return isMoveValid ;
    }
   
    private static boolean validate(char e, int R1, int C1, int R2, int C2) {
		switch(e){
		case 'P' : if(C1==6){
			if( (C1-C2==2 |  C1-C2==1 ) & R1-R2==0 & noPiece(R2,C2))
				return true;
			else if(blackPiece(R2, C2)){
				if(C1-C2==1 & Math.abs(R2-R1)==1)
					return true;
				}
			}
			else if(C1-C2==1 & noPiece(R2,C2) & R1-R2==0 & noPiece(R2,C2))
				return true;
			else if(blackPiece(R2, C2)){
				if(C1-C2==1 & Math.abs(R2-R1)==1)
					return true;
			}
			break;
			
		case 'p' : if(C1==1){
			if( (C1-C2==-2 |  C1-C2==-1 ) & R1-R2==0 & noPiece(R2,C2))
				return true;
			else if(whitePiece(R2, C2)){
				if(C1-C2==-1 & Math.abs(R2-R1)==1)
					return true;
				}
			}
			else if(C1-C2==-1 & noPiece(R2,C2) & R1-R2==0 & noPiece(R2,C2))
				return true;
			else if(whitePiece(R2, C2)){
				if(C1-C2==-1 & Math.abs(R2-R1)==1)
					return true;
				}
			break;
			
		case 'N' : case 'n' : if(Math.abs(R2-R1)*Math.abs(C2-C1)==2)
			return true;
		 	break;
		
		case 'B' : case 'b' : if(Math.abs(C1-C2)==Math.abs(R1-R2)){
				if(noPieceBishop(R1, C1, R2, C2))
					return true;
			}
    		break;
    		
		case 'R' : case 'r' : if(R2==R1 | C1==C2){
				if(noPieceRook(R1, C1, R2,C2)){
					if(R1==0 & C1==7)
						whiteRook1++;
					
					else if(R1==0 & C1==0)
						blackRook1++;
					
					if(R1==7 & C1==7)
						whiteRook2++;
					
					else if(R1==7 & C1==0)
						blackRook2++;
					
					return true;
				}
			}
			break;
		
		case 'Q' : case 'q' : if(Math.abs(C1-C2)==Math.abs(R1-R2)){
				if(noPieceBishop(R1, C1, R2, C2))
					return true;
			}
			else if(R2==R1 | C1==C2){
				if(noPieceRook(R1, C1, R2,C2))
					return true;
			}
		
		case 'K' : case 'k' : if(Math.abs(C2-C1)*Math.abs(R1-R2)==1 | Math.abs(C2-C1)==1 & R1==R2 | Math.abs(R1-R2)==1 & C1==C2){
				if(R1==3 & C1==7){
					whiteKing++;
					return true;
				}
				else if(R1==3 & C1==0){
					blackKing++;
					return true;
				}
				return true;
			}
			else if(R1==3 & C1==7 & R2==1 & C2==7 & whiteKing==1 & whiteRook1==1 & noPiece(R2, C2) & chessBoard[7][2]=='-')
				return true;
			else if(R1==3 & C1==0 & R2==1 & C2==0 & blackKing==1 & blackRook1==1 & noPiece(R2, C2) & chessBoard[0][2]=='-')
				return true;
			else if(R1==3 & C1==7 & R2==5 & C2==7 & whiteKing==1 & whiteRook2==1 & noPiece(R2, C2) & chessBoard[7][4]=='-' & chessBoard[7][6]=='-')
				return true;
			else if(R1==3 & C1==0 & R2==5 & C2==0 & blackKing==1 & blackRook2==1 & noPiece(R2, C2) & chessBoard[0][4]=='-' & chessBoard[0][6]=='-')
				return true;
		}
		return false;
	}

}
