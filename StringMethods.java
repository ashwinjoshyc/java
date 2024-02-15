public class StringMethods {
    public static void main(String[] args) {
        String text = "We realizes that while our workers were thriving, the surrounding villages were still suffering. "
                + "It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a "
                + "motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking "
                + "their lives for lack of an alternative” The alternative mentioned here is the Tata Nano, which soon "
                + "after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were "
                + "the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision "
                + "to come up with a car like Tata Nano.";

        // String charAt() method
        char firstChar = text.charAt(0);
        System.out.println("First character: " + firstChar);

        // String compareTo() method
        String anotherString = "Java Programming";
        int compareToResult = text.compareTo(anotherString);
        System.out.println("Compare To Result: " + compareToResult);

        // String concat() method
        String concatString = text.concat(" Concatenated String.");
        System.out.println("Concatenated String: " + concatString);

        // String contains() method
        boolean containsResult = text.contains("Tata Nano");
        System.out.println("Contains 'Tata Nano': " + containsResult);

        // String endsWith() method
        boolean endsWithResult = text.endsWith("Nano.");
        System.out.println("Ends with 'Nano.': " + endsWithResult);

        // String equals() method
        boolean equalsResult = text.equals(anotherString);
        System.out.println("Equals to 'Java Programming': " + equalsResult);

        // String equalsIgnoreCase() method
        boolean equalsIgnoreCaseResult = text.equalsIgnoreCase(anotherString);
        System.out.println("Equals Ignore Case 'Java Programming': " + equalsIgnoreCaseResult);

        // String format() method
        String formattedString = String.format("Formatted String: %s, %d", "Hello", 123);
        System.out.println(formattedString);

        // String getBytes() method
        byte[] byteArr = text.getBytes();
        System.out.println("String as bytes: " + new String(byteArr));

        // String getChars() method
        char[] charArr = new char[50];
        text.getChars(0, 50, charArr, 0);
        System.out.println("Characters from index 0 to 50: " + new String(charArr));

        // String indexOf() method
        int indexOfNano = text.indexOf("Tata Nano");
        System.out.println("Index of 'Tata Nano': " + indexOfNano);

        // String intern() method
        String internedString = text.intern();
        System.out.println("Interned String: " + internedString);

        // String isEmpty() method
        boolean isEmptyResult = text.isEmpty();
        System.out.println("Is String empty: " + isEmptyResult);

        // String join() method
        String[] words = text.split("\\s");
        String joinedString = String.join("-", words);
        System.out.println("Joined String: " + joinedString);

        // String lastIndexOf() method
        int lastIndexOfNano = text.lastIndexOf("Tata Nano");
        System.out.println("Last Index of 'Tata Nano': " + lastIndexOfNano);

        // String length() method
        int length = text.length();
        System.out.println("Length of the String: " + length);

        // String replace() method
        String replacedString = text.replace("Tata Nano", "affordable car");
        System.out.println("Replaced String: " + replacedString);

        // String replaceAll() method
        String regexReplacedString = text.replaceAll("[a-zA-Z]", "*");
        System.out.println("String with letters replaced by '*': " + regexReplacedString);

        // String split() method
        String[] splitWords = text.split("\\s");
        System.out.println("Words after splitting: ");
        for (String word : splitWords) {
            System.out.println(word);
        }

        // String startsWith() method
        boolean startsWithResult = text.startsWith("We");
        System.out.println("Starts with 'We': " + startsWithResult);

        // String substring() method
        String substring = text.substring(0, 50);
        System.out.println("Substring from index 0 to 50: " + substring);

        // String toCharArray() method
        char[] charArray = text.toCharArray();
        System.out.println("String as character array: " + new String(charArray));

        // String toLowerCase() method
        String lowerCaseString = text.toLowerCase();
        System.out.println("Lowercase String: " + lowerCaseString);

        // String toUpperCase() method
        String upperCaseString = text.toUpperCase();
        System.out.println("Uppercase String: " + upperCaseString);

        // String trim() method
        String trimmedString = text.trim();
        System.out.println("Trimmed String: " + trimmedString);

        // String valueOf() method
        int number = 12345;
        String stringValue = String.valueOf(number);
        System.out.println("String value of the number: " + stringValue);
    }
}
