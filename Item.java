package lab6;

public class Item {
   private int value, key;

   public int getValue() {
      return value;
   }

   public int getKey() {
      return key;
   }

   public Item(int value, int key) {
      this.value = value;
      this.key = key;
   }

   @Override
   public String toString() {
      return "Item:" +
              "value=" + value +
              ", key=" + key;
   }
}
