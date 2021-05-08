package lab6;

public class HashTable {
    private final static int TABLE_SIZE = 128;
    Item[] table;
    HashTable() {
        table = new Item[TABLE_SIZE];
    }
    void add(Item item) {
        int x = h1(item.getKey());
        int y = h2(item.getKey());
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[x] == null ) {
                table[x] = item;
                return;
            }
            x = (x + i * y) % TABLE_SIZE;
        }
    }
    void remove(int key) {
        int x = h1(key);
        int y = h2(key);
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[x] != null) {
                if (table[x].getKey() == key) {
                    table[x] = null;
                    return;
                }
            }
            x = (x + i * y) % TABLE_SIZE;
        }
    }
    Item get(int key) {
        int x = h1(key);
        int y = h2(key);
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[x] != null) {
                if (table[x].getKey() == key) {
                    return table[x];
                }
            }
            x = (x + i * y) % TABLE_SIZE;
        }
        return null;
    }

    int h1(int key){
        return key % TABLE_SIZE;
    }
    int h2(int key){
        return (key + TABLE_SIZE / key) % TABLE_SIZE;
    }
    public static void main(String[] args) {
        HashTable f = new HashTable();
        f.add(new Item(1, 3));
        f.add(new Item(6, 4));
        System.out.println(f.get(4));
        f.remove(4);
        System.out.println(f.get(4));
    }
}

