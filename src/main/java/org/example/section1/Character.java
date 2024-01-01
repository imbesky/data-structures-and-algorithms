// reference: https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
package org.example.section1;

import java.time.LocalDate;
import java.util.Comparator;

public class Character implements Comparable<Character>{
    private final String name;
    private final LocalDate birthDay;
    private final int age;

    public Character(String name, LocalDate birthDay){
        this.name = name;
        this.birthDay = birthDay;
        age = birthDay.getYear() - LocalDate.now().getYear();
    }

    @Override
    public int compareTo(Character c) {
        return this.age - c.age;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getAge() {
        return age;
    }
}
class NameCompare implements Comparator<Character> {
    @Override
    public int compare(Character c1, Character c2) {
        if (c1.getName().equals(c2.getName())){
            return 0;
        }
        if (c1.getName().length() > c2.getName().length()){
            return 1;
        }
        return -1;
    }
}

/* usage example

ArrayList<Character> list = new ArrayList<Character>();
// list adding codes

1. create an object of Comparator
NameCompare nameCompare = new NameCompare();

2. Call Collections.sort
Collections.sort(list, nameCompare);

3. Now the list is sorted by name(length)

 */