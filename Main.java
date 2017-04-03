public class Main {
  public int add(int x) {
    return x;
  }
  public int add(int x, int y) {
    return x + y;
  }
  public static void main(String[] args) {
    Main x = new Main();
    System.out.println(x.add(1, 2));
    System.out.println(x.add(1));
  }
}
