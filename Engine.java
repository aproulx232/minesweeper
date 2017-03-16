
public class Engine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game g= new Game(20,20);
		//g.board.setTile(1, 1, 9);
		//g.board.setTile(row, col, pieceValue)
		//g.placeBombs(10);
		g.solveBoard();
		//g.newTile(5, 5);
		if(!g.guessRand(5)){
			System.out.println("BOOM");
		}
		//System.out.println(g.board.toString());
		System.out.println(g.toString());
		

	}

}
