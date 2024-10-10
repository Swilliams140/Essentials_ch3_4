package CustomeException.IllegalPasswordException;
public class IllegalPasswordTesterImproved {
    public static void main(String[] args) {
        final int passwordLength = 8;

        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.println("Create a new password: ");
        String pw = input.nextLine();

        try {
            validateLength(pw, passwordLength);
            validateContent(pw);
            validateDigitCount(pw);
            // If all validations pass, password is considered valid
            System.out.println("Your password is created successfully.");
            System.out.println("Password: " + pw);
        } catch (IllegalPasswordException e) {
            // Catch block for all custom exceptions
            System.out.println(e.getMessage());
            System.out.println("Invalid password. Please try again. ");
        } finally {
            input.close();
        }
    }

    private static void validateLength(String pw, int requiredLength) throws IllegalPasswordException {
        if (pw.length() < requiredLength) {
            throw new IllegalPasswordException("Password must have at least " + requiredLength + " characters.");
        }
    }

    private static void validateContent(String pw) throws IllegalPasswordException {
        for (char c : pw.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                throw new IllegalPasswordException("Password must contain only letters and digits.");
            }
        }
    }

    private static void validateDigitCount(String pw) throws IllegalPasswordException {
        long digitCount = pw.chars().filter(Character::isDigit).count();
        if (digitCount < 2) {
            throw new IllegalPasswordException("Password must contain at least two digits.");
        }
    }
}