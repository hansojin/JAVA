abstract class Abs1 {		
  public String fname = "JH";
  public int age = 23;
  public abstract void study(); 	// abstract method 
}

// Subclass (inherit from Abs1)
class Student extends Abs1 {

  public int graduationYear = 2024;

  public void study() { 		// the body of the abstract method is provided here
    System.out.println("Studying all day all night!");
  }

}