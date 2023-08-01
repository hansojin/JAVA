class Abs2 {
  public static void main(String[] args) {
    
    Student myObj = new Student(); 
    // create an object of the Student class 
    // (which inherits attributes and methods from Abs1)
    
    System.out.println("Name: " + myObj.fname);
    System.out.println("Age: " + myObj.age);
    System.out.println("Graduation Year: " + myObj.graduationYear);
    
    myObj.study(); 	
    // call abstract method
  }
}
