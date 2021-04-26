package codinginterview.arrayandstring;

public class HashTableChaining<Key, Value> {

    private static final int TABLE_SIZE = 13; // 전체 input의 개수 N의 10분의 1 수준이 적절, 즉 N = 10M, 한 개의 연결리스트당 10의 길이가 적절
    private Node[] hashTable = new Node[TABLE_SIZE];

    public static void main(String[] args) {
        Integer a = Integer.MAX_VALUE;
        Integer b = Integer.MIN_VALUE;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        HashTableChaining<Integer, Object> hashMap = new HashTableChaining<>();
        System.out.println(hashMap.hash(b));

        Integer c = Integer.MIN_VALUE + 1;
        System.out.println(hashMap.hash(c));
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % TABLE_SIZE; // hashCode는 singed 32 bit 정수 값을 리턴하므로 음수를 제외하기 위해
    }

    public Value get(Key key) {
        int index = hash(key); // hash table에서 hash값에 해당하는 인덱스

        // 연결리스트 탐색
        for (Node node = hashTable[index]; node.next != null; node = node.next) {
            if (key.equals(node.key)) return (Value) node.value;
        }
        return null;
    }

    public void push(Key key, Value value) {
        int index = hash(key);

        for (Node node = hashTable[index]; node.next != null; node = node.next) {
            // 이미 key가 존재하면 value를 갱신
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        // key가 존재하지 않으므로 연결리스트의 맨 앞에 삽입
        hashTable[index] = new Node(key, value, hashTable[index]);
    }

    public static class Node {

        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
