package arrays;

import java.util.*;

/*
There are persons standing in a queue, each person has height and count.
The count is the no of people standing in front of him.
The order of people is corrupted and we need to generate the original order.

For ex: Given the wrong order - [a[7,0], b[4,4], c[7,1], d[5,0], e[6,1], f[5,2]],
generate the correct order of the people as : [d[5,0], a[7,0], f[5,2], e[6,1], b[4,4], c[7,1]]


 */

class Person {
    String s;
    int ht;
    int c;

    Person(String s, int ht, int c){
        this.s = s;
        this.ht = ht;
        this.c = c;
    }

    public String toString(){
        return s + "[" + ht + "," + c +  "]";
    }

}


public class OriginalOrderProblem {

    // Eg. [a[7,0], b[4,4], c[7,1], d[5,0], e[6,1], f[5,2]]

    void insertIntoOriginal(List<Person> original, List<Person> list){
        for(Person person : list){
            int cnt = 0;
            int i=0;
            for(; i<original.size(); i++){
                Person currPerson = original.get(i);
                if(person.c == currPerson.c){
                    if(person.ht <= currPerson.ht){
                        break;
                    }else{
                        continue;
                    }
                }
                if(cnt == person.c){
                    break;
                }
                if(currPerson.ht >= person.ht){
                    cnt++;
                }
            }
            original.add(i, person);
        }
    }

    List<Person> getOrder(List<Person> persons){
        List<Person> original = new ArrayList<>();
        Map<Integer, List<Person>> map = new HashMap<>();
        Set<Integer> counts = new TreeSet<>(); // 0,1,2,4
        for(Person person : persons){
            List<Person> list = map.get(person.c);
            if(list == null){
                list = new ArrayList<>();
                map.put(person.c, list);
            }
            list.add(person);
            counts.add(person.c);
        }

        Iterator<Integer> itr = counts.iterator();
        while(itr.hasNext()){
            Integer count = itr.next();
            List<Person> list = map.get(count);
            insertIntoOriginal(original, list);
        }

        return original;
    }

    public static void main(String[] args){
        // Eg. [a[7,0], b[4,4], c[7,1], d[5,0], e[6,1], f[5,2]]

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a", 7, 0));
        persons.add(new Person("b", 4, 4));
        persons.add(new Person("c", 7, 1));
        persons.add(new Person("d", 5, 0));
        persons.add(new Person("e", 6, 1));
        persons.add(new Person("f", 5, 2));

        System.out.println("Current Order - " + persons);

        OriginalOrderProblem obj = new OriginalOrderProblem();
        List<Person> original = obj.getOrder(persons);
        System.out.println("Original Order - " + original);

    }

}
