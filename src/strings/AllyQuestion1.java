package strings;

import java.util.*;
/*

Document - updating in real time - paragraph -
find most frequently used word

// word cound Map: word->count
PriorityQueue<WordCount>
fuw = "word1", fuw_count = 1

w1, w2, w3, w4


 */

class Document{

    String paragraphs;

    Document(String text){
        this.paragraphs = text;
    }

    void setParagraph(String text){
        this.paragraphs = text;
    }

    void updateDoc(String paragraph){
        this.paragraphs += paragraph;
    }

}

class WordCount implements Comparable<WordCount>{
    String word;
    int count;

    WordCount(String word, int count){
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordCount wc){
        return  wc.count - this.count;
    }

}



public class AllyQuestion1 {

    final static String SEPARATOR = " ";
    Document doc;
    Map<String, WordCount> words = new HashMap();
    PriorityQueue<WordCount> pq = new PriorityQueue<>();

    AllyQuestion1(String contents){
        doc = new Document(contents);
        updatePq(contents);
    }

    private void updatePq(String paragraph){
        String[] newWords = paragraph.split(SEPARATOR);
        for(String word : newWords){
            word = word.toLowerCase();
            WordCount wc = words.get(word);
            if(wc == null){
                wc = new WordCount(word, 0);
                words.put(word, wc);
            }
            wc.count++;
            pq.remove(wc);
            pq.add(wc);
        }
    }

    void updateDocument(String paragraph){
        doc.updateDoc(paragraph);
        updatePq(paragraph);
    }

    String fetchFUW(){
        WordCount wc = pq.peek();
        return wc.word;
    }

    public static void main(String[] args){
        String contents = "Hello, how are you how are you doing";
        AllyQuestion1 aq = new AllyQuestion1(contents);
        System.out.println(aq.fetchFUW());
        aq.updateDocument("Are you in India");
        System.out.println(aq.fetchFUW());
        aq.updateDocument("Are you in USA");
        System.out.println(aq.fetchFUW());
    }

}
