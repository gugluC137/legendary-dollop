package com.biswa.dsa.uncategorised;

public class TextEditor {
    StringBuilder string;
    int cursor;

    public TextEditor() {
        string = new StringBuilder();
        cursor = -1;
    }

    public void addText(String text) {
        string.insert(cursor+1, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int i = 0;
        while (cursor >= 0 && i < k) {
            string.deleteCharAt(cursor);
            i++;
            if (cursor != 0) cursor--;
            else break;
        }
        return i;
    }

    public String cursorLeft(int k) {
        if (cursor - k < 0) {
            cursor = 0;
        } else {
            cursor -= k;
        }
        return getLast10Chars();
    }

    public String cursorRight(int k) {
        if (cursor + k >= string.length()) {
            cursor = string.length() - 1;
        } else {
            cursor += k;
        }
        return getLast10Chars();
    }

    private String getLast10Chars() {
        int start = Math.max(cursor - 10, -1);
        return string.substring(start+1, cursor+1);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // The current text is "|". (The '|' character represents the cursor)
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("--------------------------------------");

        textEditor.addText("leetcode"); // The current text is "leetcode|".
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("--------------------------------------");

        int d = textEditor.deleteText(4); // return 4
        // The current text is "leet|".
        // 4 characters were deleted.
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("deleted: " + d + " chars");
        System.out.println("--------------------------------------");

        textEditor.addText("practice"); // The current text is "leetpractice|".
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("--------------------------------------");

        String leftText = textEditor.cursorRight(3); // return "etpractice"
        // The current text is "leetpractice|".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "etpractice" is the last 10 characters to the left of the cursor.
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("leftText: " + leftText);
        System.out.println("--------------------------------------");

        leftText = textEditor.cursorLeft(8); // return "leet"
        // The current text is "leet|practice".
        // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("leftText: " + leftText);
        System.out.println("--------------------------------------");

        d = textEditor.deleteText(10); // return 4
        // The current text is "|practice".
        // Only 4 characters were deleted.
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("deleted: " + d + " chars");
        System.out.println("--------------------------------------");

        leftText = textEditor.cursorLeft(2); // return ""
        // The current text is "|practice".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "" is the last min(10, 0) = 0 characters to the left of the cursor.
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("leftText: " + leftText);
        System.out.println("--------------------------------------");

        leftText = textEditor.cursorRight(6); // return "practi"
        // The current text is "practi|ce".
        // "practi" is the last min(10, 6) = 6 characters to the left of the cursor.
        System.out.println(textEditor.string);
        System.out.println(textEditor.cursor);
        System.out.println("leftText: " + leftText);
    }
}
