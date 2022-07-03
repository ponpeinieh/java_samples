package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author oracle
 */
public class VariousMethodReferences {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("orange", "apple", "pear", "banana", "kiwi");
        fruits.stream().map(f -> VariousMethodReferences.capitalize(f)).forEach(f -> System.out.println(f));
        //fruits.stream().map(VariousMethodReferences::capitalize).forEach(f -> System.out.println(f));
        StringComparator comp = new StringComparator();
        fruits.stream().sorted((f1, f2) -> comp.compare(f1, f2)).forEach(f -> System.out.println(f));
        //fruits.stream().sorted(comp::compare).forEach(f -> System.out.println(f));
        
        // A method reference referencing an instance method having one argument actually has two arguments - the first argument is implicit - the instance on which the method is executed.
        //fruits.stream().sorted(String::compareTo).forEach(f -> System.out.println(f)); 
        //
        fruits.stream().map(f -> new Fruit(f)).forEach(f -> System.out.println(f));
        //fruits.stream().map(Fruit::new).forEach(f -> System.out.println(f));
    }

    public static String capitalize(final String str) {
        final int strLen = str.length();
        if (strLen == 0) {
            return str;
        }

        final int firstCodepoint = str.codePointAt(0);
        final int newCodePoint = Character.toTitleCase(firstCodepoint);
        if (firstCodepoint == newCodePoint) {
            // already capitalized
            return str;
        }

        final int[] newCodePoints = new int[strLen]; // cannot be longer than the char array
        int outOffset = 0;
        newCodePoints[outOffset++] = newCodePoint; // copy the first codepoint
        for (int inOffset = Character.charCount(firstCodepoint); inOffset < strLen;) {
            final int codepoint = str.codePointAt(inOffset);
            newCodePoints[outOffset++] = codepoint; // copy the remaining ones
            inOffset += Character.charCount(codepoint);
        }
        return new String(newCodePoints, 0, outOffset);
    }

    public static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }

    public static class Fruit {

        public String name;

        public Fruit(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " begins with a letter " + name.charAt(0);
        }
    }
}
