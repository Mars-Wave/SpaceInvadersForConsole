package tp.p1;

public enum Level {
	Easy(4, 2, 0.1, 3, 0.5),
	Hard(8, 2, 0.3, 2, 0.2),
	Insane(8, 4, 0.5, 1, 0.1);
	private int carrierShips;
	private int destroyerShips;
	private double firePower;
	private int speed;
	private double UFOprob;
	Level(int carrierNum, int destNum, double fPower, int lSpeed, double UFOp) {
		carrierShips = carrierNum;
		destroyerShips = destNum;
		firePower = fPower; 
		speed = lSpeed; 
		UFOprob = UFOp;
	}	

public static Level parse (String lvl) {
    Level aux = Easy;
    if(lvl.equalsIgnoreCase("Easy")){
         aux = Easy;
    }
    else if(lvl.equalsIgnoreCase("Hard")){
         aux = Hard;
    }
    else if(lvl.equalsIgnoreCase("Insane")){
         aux = Insane;
    }
    return aux;
}

public int carrierNum() {
	return carrierShips;
}

public int destroyerNum() {
	return destroyerShips;
}

public double UFOprob() {
	return UFOprob;
}
public double firePower() {
	return firePower;
}
 
public int speed() {
	return speed;
}

}