package CustomeException.Circle;

//To create a custom unchecked exception, we need to extend the java.lang.RuntimeException class:
//import java.lang.Exception;   this is not necessary
//Exception class is under java.lang.*
public class InvalidRadiusException extends Exception{
    private double radius;

    //constructor an exception

    public InvalidRadiusException(double radius)
    {
        super("\nThis is InvalidRadius Exception");//you can just write super();
        // then this message will not be seen. and only CustomException
        // .InvalidRadiusException will be printed out.
        this.radius = radius;
    }

//    public InvalidRadiusException(){
//        super("Invalid Radius Exception");
//    }

    public double getRadius() {
        return radius;
    }
}
