package exercise.programmers.stack_queue;

import java.util.LinkedList;

public class printer {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        LinkedList<Document> documents = new LinkedList<>();
        int docNum = 0;
        for (int i = 0; i < priorities.length; i++) {
            documents.offer(new Document(docNum, priorities[i]));
            docNum++;
        }

        int order = 0;
        while (!documents.isEmpty()) {
            Document doc = documents.poll();
            if (hasHighestPriority(doc, documents)) {
                order++;
                if (doc.name == location) break;
            } else {
                documents.offer(doc);
            }
        }

        return order;
    }

    private static boolean hasHighestPriority(Document doc, LinkedList<Document> documents) {
        for (int i = 0; i < documents.size(); i++) {
            if (doc.priority < documents.get(i).priority) {
                return false;
            }
        }
        return true;
    }

    public static class Document {

        public int name;
        public int priority;

        public Document(int name, int priority) {
            this.name = name;
            this.priority = priority;
        }
    }
}
