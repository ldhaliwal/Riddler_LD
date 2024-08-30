import java.util.Arrays;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: YOUR NAME HERE
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        // Ceasar shift
        // key is +17 (or -9)
        StringBuilder decrypted = new StringBuilder();
        int shift = 17;

        // TODO: Complete the decryptOne() function.
        for (int i = 0; i < encrypted.length(); i++) {
            char character = encrypted.charAt(i);

            // Checks if the character is an uppercase letter and if it is shifts it accordingly
            if (Character.isUpperCase(character)) {
                char decryptedChar = (char)(((character - 'A' - shift + 26) % 26) + 'A');
                decrypted.append(decryptedChar);
            }

            // Checks if character is a lowercase letter and if it is shifts it accordingly
            else if (Character.isLowerCase(character)) {
                char decryptedChar = (char)(((character - 'a' - shift + 26) % 26) + 'a');
                decrypted.append(decryptedChar);
            }

            // Leaves the character alone if its not a letter
            else {
                decrypted.append(character);
            }
        }
        System.out.println(decrypted.toString());
        return decrypted.toString();
    }

    public String decryptTwo(String encrypted) {
        // TODO: Complete the decryptTwo() function.

        StringBuilder decrypted = new StringBuilder();

        // Splits up the encrypted string at each of the spaces to get the individual ASCII numbers
        String[] asciiCharacters = encrypted.split(" ");

        for (String asciiChar : asciiCharacters) {
            // Changes the string ASCII number to an integer
            int asciiValue = Integer.parseInt(asciiChar);
            // Changes the ASCII number to its letter character
            char character = (char) asciiValue;
            // Adds the character to the final decrypted string
            decrypted.append(character);
        }
        System.out.println(decrypted.toString());
        return decrypted.toString();
    }

    public String decryptThree(String encrypted) {
        StringBuilder decrypted = new StringBuilder();

        // TODO: Complete the decryptThree() function.
        // ASCII Binary
        // split digits into an array
        // new array thing every 8 digits
        int arraySize = (int) Math.ceil(encrypted.length() / 8.0);
        String[] binaryBits = new String[arraySize];

        for (int i = 0; i < binaryBits.length; i++) {
            int start = i * 8;
            int end = Math.min(start + 8, encrypted.length());
            binaryBits[i] = encrypted.substring(start, end);
        }

        //for each thing in the array,
            //translate from binary to regular numbers
        int[] numerical = new int[binaryBits.length];

        for (int i = 0; i < binaryBits.length; i++) {
            numerical[i] = Integer.parseInt(binaryBits[i], 2);
        }

        // for each number in the array
            //change into its letter value
            // add it to the final string

        for (int asciiValue : numerical) {
           char character = (char) asciiValue;
           decrypted.append(character);
        }

        System.out.println(decrypted.toString());
        return decrypted.toString();
    }

    public String decryptFour(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        int shift = 9984;

        for (int i = 0; i < encrypted.length(); i++) {
            char character = encrypted.charAt(i);

            char decryptedChar = (char)(((character + shift) % 26) + 'A');
            decrypted.append(decryptedChar);
        }

        System.out.println(decrypted.toString());
        return decrypted.toString();
    }
}
