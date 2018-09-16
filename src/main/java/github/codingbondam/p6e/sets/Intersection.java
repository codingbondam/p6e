package main.java.github.codingbondam.p6e.sets;
/*
public class Intersection {

    /*
 given two sets of strings, find the set of strings present in both

['ram', 'srini', 'ashok', 'sagar']
['ram', 'krishna', 'sagar']
['krishna', 'ram']

output = ['ram']



1. create a *hashmap with word -> count from all sets
2. output words with count same as number of sets


sets(1) ['ram', 'krishna', 'sagar']
sets(2) ['krishna', 'ram']
s(0) 'ram'
s(1) 'srini'
s(2) 'ashok'
s(3) 'sagar'
output ['ram']



O(nk)
where n is the number of sets and k is the number of elements in the set


    public class Main {

        public static Set<String> intersection(List<Set<String>> sets) {
            //todo handle null cases on input
            Set<String> set1 = sets.get(0);
            Set<String> output = new HashSet<>(set1);
            for (String s : set1) {
                for (int i = 1; i < sets.size(); i++) {
                    Set<String> set2 = sets.get(i);
                    if (!set2.contains(s)) {
                        output.remove(s);
                        break;
                    }
                }
            }
            return output;
        }


        public static void main(String[] args) {
        /*

        ['ram', 'srini', 'ashok', 'sagar']
['ram', 'krishna', 'sagar']
['krishna', 'ram']

            Set<String> s1 = new HashSet<String>();
            s1.add("ram");
            s1.add("srini");
            s1.add("ashok");
            s1.add("sagar");

            Set<String> s2 = new HashSet<String>();
            s2.add("ram");
            s2.add("krishna");
            s2.add("sagar");

            Set<String> s3 = new HashSet<String>();
            s3.add("krishna");
            s3.add("ram");

            List<Set<String>> input = new ArrayList<>();
            input.add(s1);
            input.add(s2);
            input.add(s3);

            System.out.println(intersection(input));








        }
    }
}
*/
