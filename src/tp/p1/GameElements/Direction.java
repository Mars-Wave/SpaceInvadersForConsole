package tp.p1.GameElements;

public enum Direction {
	LEFT(-1), DOWN(+1), RIGHT(+1), UP(-1);
	private int value;
	
	Direction(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
