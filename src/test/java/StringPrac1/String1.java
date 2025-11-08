package StringPrac1;

import java.util.HashMap;

public class String1 {

    public static void main(String[] args) {
        // String literal
        String str1 = "Hello World";
        System.out.println(str1);

        // String object
        String str2 = new String("Hello World");
        System.out.println(str2);

        // String with escape characters
        String str3 = "Hello \"World\"";
        System.out.println(str3);

        // String with single quotes
        String str4 = "Hello 'World'";
        System.out.println(str4);

        // String with special characters
        String str5 = "Hello @#$%^&*()_+";
        System.out.println(str5);

        // String with concatenation
        String str6 = "Hello" + " " + "World";
        System.out.println(str6);

        // String with character array
        char[] ch = {'H', 'E', 'L', 'L', 'O', ' ', 'T', 'O', ' ', 'M', 'E'};
        String st = new String(ch); // new string joins the characters properly
        // Arrays.toString(ch) doesn't work properly in joining the chars
        System.out.println(st);
        // replace space with %20
        String st2 = st.replace(" ", "%20");
        System.out.println(st2);

        // how to replace the words in a string
        String st3 = " This is 2025 and it is good year";
        // without for loop - \b is regular expression for boundary
        String replacedString = st3.replaceAll("\\bis\\b", "was");
        System.out.println(replacedString);

        // Count the number of occurrence of letter 'a' in my name String
        String name = "sravani mankala";
        char[] ch1 = name.toCharArray();
        System.out.println(ch1);
        int count = 0;
        for (char chr : ch1) {
            if (chr == 'a') {
                count++;
            }
        }
        System.out.println("the count of a " + count);

        // Fetch each letter frequency i\hu1n the string name
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char c : name.toCharArray()) {
            if (c != ' ') // ignoring spaces
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            // getOrDefault returns the value for the key if it exists, otherwise returns the default value (0 in this case)
        }
        System.out.println(map1);

        // Reverse the string nameRev = inavars
        String namerev = new StringBuilder(name).reverse().toString();
        //reverse() method of StringBuilder reverses the string, toString() converts it back to String, stringbuilder is mutable, whereas string is immutable
        System.out.println(namerev);

        //reverse the string without using StringBuilder
        String namerev1="";
        char ch2;
        for (int i = 0; i<name.length(); i++)
        {
            ch2 = name.charAt(i);
            namerev1=namerev+ch2;
        }
        System.out.println("reverse string using or loop " +namerev1);
    }
}