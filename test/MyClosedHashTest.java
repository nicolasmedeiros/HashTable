import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClosedHashTest {

    MyHash<Integer, String> hashTable;

    @Nested
    @DisplayName("cuando es un hashtable nuevo")
    class WhenNew {

        @BeforeEach
        void createNewHashTable() {
            hashTable = new MyClosedHash<>();
        }

        @Test
        @DisplayName("isEmpty() retorna true")
        void isEmpty() {
            assertTrue(hashTable.isEmpty());
        }

        @Test
        @DisplayName("con el get retorna null")
        void returnsNullOnGet() {
            assertNull( hashTable.get(1));
        }

        @Test
        @DisplayName("size retorna 0")
        void sizeIsZero() {
            assertEquals(0, hashTable.size());
        }
    }

    @Nested
    @DisplayName("agregar un elemento")
    class Add {

        @BeforeEach
        void createNewHashTable() {
            hashTable = new MyClosedHash<>();
        }

        @Test
        @DisplayName("add agrega un elemento y size retorna 1")
        void testPut() {
            hashTable.put(1, "hola");
            assertEquals(1, hashTable.size());
            assertEquals("hola", hashTable.get(1));
        }

    }


    @Nested
    @DisplayName("con colision")
    class AddWithColition {

        @BeforeEach
        void createNewHashTable() {
            hashTable = new MyClosedHash<>();
        }

        @Test
        @DisplayName("add agrega un elemento y size retorna 1")
        void testPut() {
            hashTable.put(1, "hola");
            hashTable.put(11, "mundo");
            assertEquals(2, hashTable.size());
            assertEquals("mundo", hashTable.get(11));
        }
    }
}