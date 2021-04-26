package codinginterview.array_and_string;

public class HashTableOpenAddressing<Key, Value> {

    private static final int TABLE_SIZE = 13;
    private Key[] keys = (Key[]) new Object[TABLE_SIZE]; // 해시 테이블
    private Value[] values = (Value[]) new Object[TABLE_SIZE]; // key에 해당하는 value를 저장하는 배열

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % TABLE_SIZE; // hashCode는 singed 32 bit 정수 값을 리턴하므로 음수를 제외하기 위해
    }

    public void put(Key key, Value value) {
        int initialPos = hash(key);
        int i = initialPos;
        int j = 1;

        do {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
            if (keys[i].equals(key)) { // 이미 key가 존재하면
                values[i] = value;
                return;
            }
            i = (initialPos + j++) % TABLE_SIZE; // 선형조사 방식
        } while (i != initialPos);
    }

    public Value get(Key key) {
        int initialPos = hash(key);
        int i = initialPos;
        int j = 1;

        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
            i = (initialPos + j++) % TABLE_SIZE;
        }
        return null;
    }
}
