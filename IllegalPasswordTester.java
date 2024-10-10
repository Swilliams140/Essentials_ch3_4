package CustomeException.IllegalPasswordException;
public class IllegalPasswordTester {
    public static void main(String[] args) {
        int passwordLength = 8;

        java.util.Scanner input = new java.util.Scanner(System.in);

        /*
         * 1. A password must have at least eight characters.
         * 2. A password consists of only letters and digits.
         * 3. A password must contain at least two digits.
         */

        System.out.println("Create a new password: ");
        boolean valid = false;
        while (!valid) {
            int digitCount = 0; // Reset digit count for each attempt
            int letterCount = 0; // Reset letter count for each attempt

            String pw = input.nextLine();

            try {
                if (pw.length() < passwordLength) {
                    throw new IllegalPasswordException("Password must have at least " +
                            "eight characters.");
                }
                for (int i = 0; i < pw.length(); i++) {
                    char c = pw.charAt(i);
                    if (Character.isDigit(c)) {
                        digitCount++;
                    } else if (Character.isLetter(c)) {
                        letterCount++;
                    } else {
                        throw new IllegalPasswordException("Password must contain " +
                                "only letters and digits.");
                    }
                }

                if (digitCount < 2) {
                    throw new IllegalPasswordException("Password must contain at " +
                            "least two digits.");
                }
                if (letterCount < 1) { // This check is actually redundant since a password can be all digits
                    throw new IllegalPasswordException("Password must contain at least one letter.");
                }

                valid = true; // The password is valid if it reaches this point
                System.out.println("Your password is created successfully.");
                System.out.println("Password: " + pw);
            } catch (IllegalPasswordException e) {
                System.out.println(e.getMessage());
                System.out.println("Invalid password. Please try again. ");
            }
        }
        input.close();
    }
}