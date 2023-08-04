import java.util.Scanner;

abstract class Converter{

	abstract protected double convert(double src);
	abstract protected String getSrcStr();
	abstract protected String getDestStr();

	protected double ratio;

	public void run(){
		Scanner sc = new Scanner(System.in);
		System.out.println(getSrcStr() + " to " + getDestStr());
		System.out.print("Enter " + getSrcStr() + " : " );
		double val = sc.nextDouble();
		double res = convert(val);
		System.out.println("After convert : " + res + getDestStr());
		sc.close();
	}
}

public class Won2Dollar extends Converter{
	public Won2Dollar(double ratio){
		this.ratio = ratio;
	}
	@Override
	protected double convert(double src){
		return src/ratio;
	}
	@Override
	protected String getSrcStr(){
		return "won";
	}
	@Override
	protected String getDestStr(){
		return "$";
	}
	public static void main(String[] args){
		Won2Dollar wd = new Won2Dollar(1200);
		wd.run();
	}
}