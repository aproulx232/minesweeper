
public class Board {
	private int[][] board;
	private int row;
	private int col;
	/*
	 * getters for row and col
	 */
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	/*
	 * Constructors for Board:
	 * Creates a Board from int value of the rows and cols, a int value for a square Board and a int double array.
	 * 
	 */
	public Board(int row,int col){
		this.board= new int[row][col];
		this.row=row;
		this.col=col;
	}
	
	public Board(int rowAndCol){
		this.board= new int[rowAndCol][rowAndCol];
		this.row=rowAndCol;
		this.col=rowAndCol;
		
	}
	public Board(int[][] board){
		this.board= new int[board[0].length][board.length];
		this.row=board[0].length;
		this.col=board.length;

	}
	/*toString which prints each array of the double array on a separate line so that a board is formed in the console. 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
			String s = "";
			for(int n=0;n<row;n++){
				for(int k=0;k<col;k++){
// to print plank spaces					
//					if(board[n][k]==0){
//						s+=" ";
//					}
//					else 
						s += board[n][k] + " ";
				}
				s +="\n";
			}
		return s;
		
	}
	/*
	 * Purpose: set the tile to a specified int value at a index location
	 * When the tile is =-1. it is not valid
	 * receives: the int row and int col as the index location and int pieceValue as the value of the pieces to set.
	 * Returns: the value at the index location before setting the pieceValue
	 */
	public int setTile(int row,int col, int pieceValue){
		int tile= getTile(row,col);
		if(tile!=-1){
			this.board[row][col]=pieceValue;
			return tile;
		}
		else return-1;
	}
	/*
	 * Purpose: get the value at a index location.
	 * Runs the tile true the isValid(int,int) method. if the tile is not valid, returns the error value of -1. 
	 * 
	 * Receives:  the int row and int col as the index location
	 * returns: the value at the location 
	 */
	public int getTile( int row,int col){
		if(isValid(row,col)){
			int tile= board[row][col];
			return tile;
		}
		else{
		//System.out.println("Not a valid point! ("+row+","+col+")");
		return -1;
		}

	}
	/*
	 * Purpose: check that the intended value is on the Board double array
	 * receives: int row and int col, which is the index location to check 
	 * returns: a boolean true if valid
	 */
	public boolean isValid(int row, int col){		
		if(row<this.row&& row>=0&&col<this.col&&col>=0)
			return true;
		else return false;
	}
	/*
	 * purpose: clears the value of the Board
	 */
	public void clear(){
		for(int i= 0;i<row;i++){
			for(int g=0;g<col;g++){
				board[i][g]=0;
			}
		}
	}
	/*
	 * purpose: checks if the indx location has a value other than 0
	 * Receives: int row and int col as the index location
	 * returns a boolean true if there is a non 0 int in the location
	 */
	public boolean isOccupied(int row,int col){
		int tile= getTile(row,col);
		if(tile ==0)
			return false;
		else return true;
	}
	/*
	 * purpose: remove the tile value and sets the index valu to 0
	 * receives int row and int col as the index location
	 * returns : a int of the tile which was at the index location
	 */
	public int remove(int row, int col){
		int tile= getTile(row, col);
		board[row][col]=0;
		return tile;
	}
//	//Test of Board class
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
		Board board2 =new Board(9);
		System.out.println(""+board2.toString());
		System.out.println("Get Tile "+board2.getTile(3,2));
		System.out.println("Set Tile "+board2.setTile(3,2,6));
		System.out.println(""+board2.toString());
		System.out.println("Is Occupied "+board2.isOccupied(3,2));
		System.out.println("Get Tile "+board2.getTile(3,2));
		board2.clear();
		System.out.println(""+board2.toString());
		System.out.println("Is Occupied "+board2.isOccupied(3,2));
		System.out.println("Is Valid "+board2.isValid(6,10));
		System.out.println("Is Valid "+board2.isValid(1,2));
	}
}
