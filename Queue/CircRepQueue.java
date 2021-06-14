// Circular Array replacing if size is full
class CircRepQueue {
  int[] elemArr = new int[1];
  int maxSize = 1, available = 0;
  int head = 0, tail = 0;

  CircRepQueue(int size) {
    elemArr = new int[size];
    maxSize = size;
  }

  public void add(int elem) {
    if (available == maxSize) {
      System.out.println("Queue Full");
      elemArr[tail] = elem;
      tail = (tail + 1) % maxSize;
      head = (head + 1) % maxSize;
    } else {
      elemArr[tail] = elem;
      tail = (tail + 1) % maxSize;
      available++;
    }

  }

  public int remove() {
    if (available == 0) {
      System.out.println("Queue Empty");
      return -1;
    }
    int temp = elemArr[head];
    head = (head + 1) % maxSize;
    available--;
    return temp;
  }

  public int availableElem() {
    return available;
  }

  public void printElem() {
    System.out.println("availableElem:" + available);
    System.out.println("head:" + head + "tail:" + tail);
    int count = available;
    for (int i = head; count > 0;) {
      System.out.print(elemArr[i] + " ");
      i = (i + 1) % maxSize;
      count--;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    CircRepQueue test = new CircRepQueue(10);
    System.out.println(test.remove());
    int[] testArr = new int[100];
    for (int i = 0; i < 100; i++)
      testArr[i] = i;

    for (int i = 1; i < 12; i++)
      test.add(testArr[i]);
    for (int i = 0; i < 5; i++)
      System.out.println(test.remove());

    test.printElem();
    System.out.println("removed:" + test.remove());

    for (int i = 12; i < 25; i++)
      test.add(testArr[i]);
    test.printElem();

    for (int i = 0; i < 13; i++)
      System.out.println(test.remove());
    test.printElem();

  }
}