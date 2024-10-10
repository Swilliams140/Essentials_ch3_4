package CustomeException.Circle;

public class TestCircleWithCustomException {
    public static void main(String[] args) {

        //use try-catch or throws exception with main method
        try {
           CircleWithCustomException c1 =  new CircleWithCustomException(5);
            System.out.println(c1.findArea());
            CircleWithCustomException c2 = new CircleWithCustomException(-1);
            System.out.println(c2.findArea());
            CircleWithCustomException c3 = new CircleWithCustomException(0);
            System.out.println(c3.findArea());


        }
        catch (InvalidRadiusException ex) {
            System.out.println(ex);

        }

        System.out.println("Number of objects created: " +
                CircleWithCustomException.getNumberOfObjects());

    }
}

class CircleWithCustomException {
    /** The radius of the circle */
    private double radius;

    /** The number of the objects created */
    private static int numberOfObjects = 0;

    /** Construct a circle with radius 1 */
    public CircleWithCustomException() throws InvalidRadiusException {
        this(1.0);  //because this(1.0) is from the constructor by taking an argument and
        //it is invoking setRadius(newRadius), so it needs to declare exception

    }


    /** Construct a circle with a specified radius */
    public CircleWithCustomException(double newRadius)
            throws InvalidRadiusException {
        setRadius(newRadius);
        numberOfObjects++;
    }

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double newRadius) throws InvalidRadiusException {
        if (newRadius >= 0)
            radius =  newRadius;
        else
            throw new InvalidRadiusException(newRadius);
    }

    /** Return numberOfObjects */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /** Return the area of this circle */
    public double findArea() {
        return radius * radius * 3.14159;
    }
}
