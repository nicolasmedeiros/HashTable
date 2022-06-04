public class MyClosedHash<K, V> implements MyHash<K, V> {

    private static final int DEFAULT_HASH_TABLE_SIZE = 10;

    private int tableSize;
    private int currentSize;

    private ClosedHashNode[] hashTable;

    private void initVector() {
        for (int i = 0; i < tableSize; i++)
            hashTable[i] = null;
        currentSize = 0;
    }

    public MyClosedHash() {
        hashTable = new ClosedHashNode[DEFAULT_HASH_TABLE_SIZE];
        tableSize = DEFAULT_HASH_TABLE_SIZE;
        initVector();
    }

    public MyClosedHash(int hashTableSize, float loadFactor) {
        hashTable = new ClosedHashNode[hashTableSize];
        tableSize = hashTableSize;
        initVector();
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode() % tableSize;

        // FIXME: controlar que al hacer rehash el loop termine en algun momento
        while (hashTable[hash] != null && !hashTable[hash].isDeleted()) {
            hash = (hash + 1) % tableSize;
        }
        hashTable[hash] = new ClosedHashNode<>(key,value);
        currentSize++;
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode() % tableSize;
        
        // FIXME: controlar que al hacer rehash el loop termine en algun momento
        while (hashTable[hash] != null ) {
            if (hashTable[hash].getKey().equals(key) && !hashTable[hash].isDeleted()) {
                return (V) hashTable[hash].getValue();
            }
            hash = (hash + 1) % tableSize;
        }
        
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
