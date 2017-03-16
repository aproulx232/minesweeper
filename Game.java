import java.util.Random;

public class Game{
	Board board;
	Board display;
	private final int BOMB=9,Bomb=9,BLANK=11,blank=11,NEWTILE=0;;
	
	public Game(){
		this.board= new Board(10,10);
		placeBombs(10);
		display= new Board(10,10);
	}
	public Game(int row, int col ,int numBombs){
		this.board= new Board(row,col);
		placeBombs(numBombs);
		display= new Board(row,col);
	}
	public Game(int row,int col){
		this.board= new Board(row,col);
		placeBombs((row*col)/10);
		display= new Board(row,col);
	}
	public boolean checkIfBomb(int row,int col ){
		if(!board.isValid(row, col))return false;
		if(board.getTile(row, col)==BOMB)return true;
		return false;
	}
	public void solveBoard(){
		for(int r=0;r<board.getRow();r++){
			for(int c=0;c<board.getCol();c++){
				//System.out.println("row:"+(r)+", col:"+(c) );
				if(board.getTile(r, c)!=BOMB){
					int count=0;
					for(int rr=-1;rr<2;rr++){
						for(int cc=-1;cc<2;cc++){
							int rrr=r+rr;
							int ccc=c+cc;
							
							if(board.isValid((rrr), (ccc))){
								//System.out.println("row:"+(rrr)+", col:"+(ccc) );
								if(board.getTile(rrr, ccc)==BOMB){
									//System.out.println("bomb");
									count++;
								}
							}
						}
					}
				board.setTile(r, c, count);
				
				}
			}
		}
	}
	public boolean newTile(int row,int col){
		if(!board.isValid(row, col))return false;
		if(board.getTile(row, col)==BOMB)return false;
		if(board.getTile(row, col)==NEWTILE)blankTile(row,col);
		display.setTile(row, col, board.getTile(row, col));
		return true;
	}
	
	public boolean blankTile(int row, int col){
		for(int i=-1;i<2;i++){
			for(int k=-1;k<2;k++){
				if(board.isValid(row+i, col+k)){
					if(board.getTile(row+i, col+k)==NEWTILE){
						display.setTile(row+i, col+k, board.getTile(row+i, col+k));
						board.setTile(row+i, col+k, BLANK);
						blankTile(row+i, col+k);
					}
					display.setTile(row+i, col+k, board.getTile(row+i, col+k));
					
					
				}
			}
		}	
		return true;
	}
	public boolean placeBombs(int numBombs){
		Random seed= new Random();
		for(int i=0;i<numBombs;i++){
			int row=seed.nextInt(board.getRow());
			int col=seed.nextInt(board.getCol());
			if(board.getTile(row, col)!=Bomb)
				board.setTile(row, col, Bomb);
			else i--;
		}
		return true;
		
	}
	public boolean guessRand(int num){
		Random seed= new Random();
		for(int i=0;i<num;i++){
			int row=seed.nextInt(board.getRow());
			int col=seed.nextInt(board.getCol());
			if(display.getTile(row, col)==NEWTILE)
				if(!newTile(row,col))return false;
			else i--;
			
		}
		return true;
		
	}
	public String toString(){
		String s = "";
		for(int n=0;n<display.getRow();n++){
			for(int k=0;k<display.getCol();k++){
				if(display.getTile(n, k)==BLANK){
					s+="  ";
				}
				else if(display.getTile(n, k)==NEWTILE){
					s+="* ";
				}
				else if(display.getTile(n, k)==Bomb){
					 s+="B ";
				}
				else 
					s += display.getTile(n, k) + " ";
			}
			s +="\n";
		}
	return s;
		
	}
	
}
