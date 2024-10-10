package CustomeException.Binary;

public class BinaryTester {

    public static void main(String[] args) throws IllegalBinaryNumberException {

        java.util.Scanner input = new java.util.Scanner(System.in);
        boolean valid = false;
        int binToDecNumber = 0;
        while(!valid) {
            try {
                Binary b1 = new Binary();
                System.out.println("Enter binary digits");
                String binaryDigits = input.nextLine();
                b1.setBinaryString(binaryDigits);
                 binToDecNumber = b1.binaryToDecimal(b1.getBinaryString());

                valid = true;

            } catch (IllegalBinaryNumberException e) {
                System.out.println(e);
                System.out.println("Try it again. ");
            }
            finally{
                System.out.println(binToDecNumber);
            }
        }

    }

}
