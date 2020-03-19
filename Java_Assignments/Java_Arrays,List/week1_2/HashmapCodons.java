/*

Assignment 1: Codon Count
Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames.
A strand of DNA is made up of the symbols C, G, T, and A. A codon is three consecutive symbols in a strand of DNA
such as ATT or TCC. A reading frame is a way of dividing a strand of DNA into consecutive codons.
Consider the following strand of DNA = “CGTTCAAGTTCAA”.

There are three reading frames.

The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”.
Here TCA occurs twice and the others each occur once.
The second reading frame starts at position 1 (ignoring the first C character) and has the
codons: “GTT”, “CAA”, “GTT”, “CAA”. Here both GTT and CAA occur twice.
The third reading frame starts at position 2 (ignoring the first two characters CG) and has the
codons: “TTC”, “AAG”, “TTC”. Here TTC occurs twice and AAG occurs once.
A map of DNA codons to the number times each codon appears in a reading frame would be helpful in solving this problem.

Specifically, you should do the following:

Create a new class for this problem
Create a private variable to store a HashMap to map DNA codons to their count.
Write a constructor to initialize the HashMap variable.


Write a void method named buildCodonMap that has two parameters, an int named start and a String named dna.
This method will build a new map of codons mapped to their counts from the string dna with the reading frame
with the position start (a value of 0, 1, or 2).
You will call this method several times, so make sure your map is empty before building it.


Write a method named getMostCommonCodon that has no parameters.
This method returns a String, the codon in a reading frame that has the largest count.
If there are several such codons, return any one of them. This method assumes the HashMap of codons to
counts has already been built.


Write a void method named printCodonCounts that has two int parameters, start and end.
This method prints all the codons in HashMap along with their counts if their count is between start and end,inclusive.


Write a tester method that prompts the user for a file that contains a DNA strand
(could be upper or lower case letters in the file, convert them all to uppercase, since case should not matter).
Then for each of the three possible reading frames, this method builds a HashMap of codons to their number of occurrences
 in the DNA strand, prints the total number of unique codons in the reading frame, prints the most common codon and
 its count, and prints the codons and their number of occurrences for those codons whose number of occurrences
 in this reading frame are between two numbers inclusive.
For example, for the string above and here: “CGTTCAAGTTCAA,” also in smalldna.txt,
if we run our program and print the output requested above and specify to print codons and counts for those codons
whose counts are between 1 and 5 inclusive, we might get the output:

Reading frame starting with 0 results in 3 unique codons

and most common codon is TCA with count 2

Counts of codons between 1 and 5 inclusive are:

CGT 1

TCA 2

AGT 1

Reading frame starting with 1 results in 2 unique codons

and most common codon is CAA with count 2

Counts of codons between 1 and 5 inclusive are:

CAA 2

GTT 2

Reading frame starting with 2 results in 2 unique codons

and most common codon is TTC with count 2

Counts of codons between 1 and 5 inclusive are:

TTC 2

AAG 1
 */
import edu.duke.FileResource;

import java.util.HashMap;
import java.util.Map;

public class HashmapCodons {
    private HashMap<String,Integer> codonMap;
    HashmapCodons(){
        codonMap=new HashMap<>();
    }
    public void buildCodon(int start,String dna){
        codonMap.clear();
        int i=start;
        while(i<dna.length()-3){
            String codon=dna.substring(i,i+3);
            if(!codonMap.containsKey(codon)){
                codonMap.put(codon,1);
            }
            else{
                codonMap.put(codon,codonMap.get(codon)+1);
            }
            i+=3;
        }
    }
    public String getMostCommonCodon(){
        int Max=0;
        String MostCommonCodon=" ";
        for(Map.Entry mapElement : codonMap.entrySet()) {
            if ((int) mapElement.getValue() > Max) {
                Max = (int) mapElement.getValue();
                MostCommonCodon = (String) mapElement.getKey();
            }
        }
        return MostCommonCodon;
    }
    public void printCodons(int start,int end){
        for(String codon: codonMap.keySet()){
            if(codonMap.get(codon)>=start && codonMap.get(codon)<=end){
                System.out.println(codon+" : "+codonMap.get(codon));
            }
        }
    }
    public void tester(){
        FileResource fr=new FileResource();
        String strand=fr.asString().toUpperCase();
        buildCodon(2,strand);
        System.out.println(getMostCommonCodon());
        printCodons(1,5);
    }
    public static void main(String args[]){
        HashmapCodons obj=new HashmapCodons();
        obj.tester();
    }
}
