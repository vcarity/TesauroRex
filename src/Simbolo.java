public class Simbolo {

  final int SHIFT = 4;
  final int SIZE = 499;
  private String id;
  private String tipo;
  private int hash;

  public Simbolo(String id, String tipo) {
    setId(id);
    setTipo(tipo);
    setHash(0);
  }

  @Override
  public int hashCode() {
    int temp = 0;
    int i = 0;
    int end = id.length();
    while (i < end && id.charAt(i) != '\0' ) {
      temp = ((temp << SHIFT) + id.charAt(i) % SIZE);
      i++;
    }
    setHash(temp);
    System.out.println("fez hashCode");
    return temp;
  }

  public int getHash() {
    return this.hash;
  }

  public void setHash(int hash) {
    this.hash = hash;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

}
