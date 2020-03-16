/*
Assignment 1: Most Frequent Word

You will write a program to determine the word that occurs the most often in a file.
If more than one word occurs as the most often, then return the first such word found.
You should make all words lowercase before counting them. Thus, “This” and “this” will both be counted as
the lowercase version of “this”. You should not consider punctuation, so “end” and “end,” will be considered
different words. Use the WordFrequencies program in the lesson as a starting point.

Specifically, you should do the following:

Create a new project in BlueJ and then create a new class called WordFrequencies.
Put all the following items in this class.


Create two private variables. One is called myWords and should be an ArrayList of type String to
store unique words from a file, and one is called myFreqs and should be an ArrayList of type Integer.
The kth position in myFreqs should represent the number of times the kth word in myWords occurs in the file.


Write a constructor WordFrequencies, and initialize the private variables.


Write a void method findUnique that has no parameters.
This method should first clear both myWords and myFreqs, using the .clear() method.
Then it selects a file and then iterates over every word in the file, putting the unique words found into myWords.
For each word in the kth position of myWords, it puts the count of how many times that word occurs from
the selected file into the kth position of myFreqs, as was demonstrated in the lesson.


Write a void tester method that has no parameters.
This method should call findUnique. Then print out the number of unique words, and for each unique word,
print the frequency of each word and the word, as was demonstrated in the lesson.


Write the method findIndexOfMax that has no parameters.
This method returns an int that is the index location of the largest value in myFreqs.
If there is a tie, then return the first such value.


Add code to the tester method to determine and print the word that occurs the most often in a selected file
and how many times it occurs. You should find it helpful to call findIndexOfMax.

*/
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    WordFrequencies(){
        myWords=new ArrayList<String>();
        myFreqs=new ArrayList<Integer>();
    }
    public void findUnique() {
        myFreqs.clear();
        myWords.clear();
        FileResource fr = new FileResource();
        int i = 0;
        for (String word : fr.words()) {
            String Wordlower=word.toLowerCase();
            if (!myWords.contains(Wordlower)) {
                myWords.add(Wordlower);
                myFreqs.add(1);
            } else
                myFreqs.set(myWords.indexOf(Wordlower), myFreqs.get(myWords.indexOf(Wordlower)) + 1);
        }
    }
    public void tester(){
        findUnique();
        int MaxIndex=findIndexOfMax();
        for(int i=0;i<myWords.size();i++){
            System.out.println("Word: "+ myWords.get(i) +" = "+ myFreqs.get(i));
        }
        System.out.println("Max Occuring letter is "+ myWords.get(MaxIndex) +" with a frequency of "+ myFreqs.get(MaxIndex));
    }
    public int findIndexOfMax(){
        int MaxIndex=0;
        for(int i=0;i<myFreqs.size();i++){
            if(myFreqs.get(i)>myFreqs.get(MaxIndex)){
                MaxIndex=i;
            }
        }
        return MaxIndex;
    }
    public static void main(String args[]){
        WordFrequencies wf=new WordFrequencies();
        wf.tester();
    }
}