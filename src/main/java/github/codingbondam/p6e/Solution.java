package main.java.github.codingbondam.p6e;

import java.util.*;

class Solution {

    public static class User {

        String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {

            if (this.name.equals(((User)o).name)) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    public static class Content {
        String data;

        public Content(String data) {
            this.data = data;
        }

        public String getData() {
            return this.data;
        }
    }

    public static class Message {
        User user;
        Content content;

        public Message(User u, Content c) {
            this.user = u;
            this.content = c;
        }

        public User getUser() {
            return this.user;
        }

        public Content getContent() {
            return this.content;
        }
    }

    public static interface ChatScores {

        public void update(Message m);

        public double retrieve(User u);

    }

    public static class ChatScoresByWordCount implements ChatScores {

        private Map<User, Integer> scores = new HashMap<>();

        public void update(Message m) {
            // todo null handling
            Integer score = scores.get(m.getUser());
            if (score == null) {
                score = 0;
            }
            scores.put(m.getUser(), m.getContent().getData().split(" ").length + score);
        }

        public double retrieve(User u) {
            // todo handle missing user
            return scores.get(u);
        }

    }

    public static class ChattyUserFinder {

        ChatScores scores;

        public ChattyUserFinder(ChatScores scores) {
            this.scores = scores;
        }

        public List<User> chattyUsers(List<Message> messages, int topN) {

            // todo handle null inputs
            List<User> users = new ArrayList<>();
            for(Message m : messages) {
                scores.update(m);
                if (!users.contains(m.getUser())) {
                    users.add(m.getUser());
                }
            }

            PriorityQueue<User> minHeap = new PriorityQueue<>(new Comparator<User>() {

                @Override
                public int compare(User u1, User u2) {
                    if (scores.retrieve(u1) < scores.retrieve(u2)) {
                        return -1;
                    } else if (scores.retrieve(u1) > scores.retrieve(u2)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }

            });

            // todo add first k users to the priority queue
            for(int i = 0; i < topN; i++) {
                minHeap.add(users.get(i));
            }

            for(int i = topN; i < users.size(); i++) {
                User u = users.get(i);
                double score = scores.retrieve(u);
                if (score > scores.retrieve(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.add(u);
                }
            }

            List<User> rVal = new ArrayList<>();
            Iterator<User> i = minHeap.iterator();
            while (i.hasNext()) {
                rVal.add(i.next());
            }

            return rVal;
        }

    }

    public static void main(String[] args) {

        Message m1 = new Message(new User("srini"), new Content("hello world. i am practising some code"));
        Message m2 = new Message(new User("ashok"), new Content("hi"));
        Message m3 = new Message(new User("vamsi"), new Content("srini and i talk a lot man. we do little"));
        Message m4 = new Message(new User("rajiv"), new Content("genius"));
        Message m5 = new Message(new User("rajiv"), new Content("i can fool the system. see i am very chatty but you woulnd't catch it"));
        Message m6 = new Message(new User("rajiv"), new Content("bye"));

        List<Message> messages = new ArrayList<>();
        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
        messages.add(m4);
        messages.add(m5);
        messages.add(m6);

        ChatScores scores = new ChatScoresByWordCount();
        ChattyUserFinder finder = new ChattyUserFinder(scores);
        List<User> users = finder.chattyUsers(messages, 2);

        for(User u : users) {
            System.out.println(u.name);
        }

    }


}




