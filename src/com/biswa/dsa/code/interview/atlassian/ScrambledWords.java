package com.biswa.dsa.code.interview.atlassian;

/*
You are running a classroom and suspect that some of your students are passing around the answer to a multiple-choice
question disguised as a random note.
Your task is to write a function that, given a list of words and a note, finds and returns the word in the list that is
scrambled inside the note, if any exists. If none exist, it returns the result "-" as a string. There will be at most one
matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.
Example:
words = ["baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"]
abby,ref.., act
note1 = "ctay" -> "acty"
find(words, note1) => "cat" (the letters do not have to be in order)
note2 = "bcanihjsrrrferet"
find(words, note2) => "cat" (the letters do not have to be together)
note3 = "tbaykkjlga"
find(words, note3) => "-" (the letters cannot be reused)
note4 = "bbbblkkjbaby"
find(words, note4) => "baby"
note5 = "dad"
find(words, note5) => "-"
note6 = "breadmaking"
find(words, note6) => "bird"
note7 = "dadaa"
find(words, note7) => "dada"
All Test Cases:
find(words, note1) -> "cat"
find(words, note2) -> "cat"
find(words, note3) -> "-"
find(words, note4) -> "baby"
find(words, note5) -> "-"
find(words, note6) -> "bird"
find(words, note7) -> "dada"
Complexity analysis variables:
W = number of words in `words`
S = maximal length of each word or of the note
**/

import java.util.*;

public class ScrambledWords {

    public String find(final List<String> words, final String note) {
        //Step 1: get the char freq of each words in the list
        List<Map<Character, Integer>> charFreqOfWords = new ArrayList<>();
        for (String word: words) {
            charFreqOfWords.add(getFreqOfCharsInString(word));
        }

        //Step 2: get the char freq of the note
        Map<Character, Integer> freqOfCharsInNote = getFreqOfCharsInString(note);

        //Step 3: try to find if any word can be completely recreated from the scrambled note
        int ansIdx = getIndexOfWordInNote(charFreqOfWords, freqOfCharsInNote);

        if (ansIdx == -1) {
            return "_";
        } else {
            return words.get(ansIdx);
        }

    }

    public Map<Character, Integer> getFreqOfCharsInString(final String str) {
        Map<Character, Integer> freqOfChars = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (freqOfChars.containsKey(ch)) {
                freqOfChars.put(ch, freqOfChars.get(ch) + 1);
            } else {
                freqOfChars.put(ch, 1);
            }
        }

        return freqOfChars;
    }

    public int getIndexOfWordInNote(List<Map<Character, Integer>> wordCharFreqMap, Map<Character, Integer> charFreqInNote) {
        int ansIdx = -1;
        for (int i = 0; i < wordCharFreqMap.size(); i++) {
            Map<Character, Integer> charFreqInWord = wordCharFreqMap.get(i);
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : charFreqInWord.entrySet()) {
                if (charFreqInNote.containsKey(entry.getKey())) {
                    if (entry.getValue() > charFreqInNote.get(entry.getKey())) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ansIdx = i;
                break;
            }
        }

        return ansIdx;
    }

    public static void main(String[] args) {
        String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
        List<String> wordList = Arrays.asList(words);

        String note1 = "ctay"; // cat
        String note2 = "bcanihjsrrrferet"; // cat
        String note3 = "tbaykkjlga"; // _
        String note4 = "bbbblkkjbaby"; // baby
        String note5 = "dad"; // _
        String note6 = "breadmaking"; // bird
        String note7 = "dadaa"; // dada


        System.out.println(new ScrambledWords().find(wordList, note2));
    }

}
