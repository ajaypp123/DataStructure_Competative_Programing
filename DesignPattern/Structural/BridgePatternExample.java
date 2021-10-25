

// Implementor
interface Resource {
  public String image();
  public String info();
}

class AuthorResource implements Resource{
  @Override
  public String image() {
    return "Author Image";
  }

  @Override
  public String info() {
    return "Author Info";
  }
}

class BookResource  implements Resource {
  @Override
  public String image() {
    return "Book Image";
  }

  @Override
  public String info() {
    return "Book Info";
  }
}

// abstraction
interface View {
  //public (Resource r)
  public void show();
}


class ShortView implements View{

  Resource r;

  public ShortView(Resource r) {
    this.r = r;
  }

  @Override
  public void show() {
    System.out.println(r.image());
  }

}

class LongView implements View{

  Resource r;

  public LongView(Resource r) {
    this.r = r;
  }

  @Override
  public void show() {
    System.out.println(r.image());
    System.out.println(r.info());
  }

}


public class BridgePatternExample {
  public static void main(String[] args) {
    Resource ar = new AuthorResource();
    Resource br = new BookResource();

    View vsar = new ShortView(ar);
    View vsbr = new ShortView(br);

    View vlar = new LongView(ar);
    View vlbr = new ShortView(br);

    vsar.show();
    vsbr.show();
    vlar.show();
    vlbr.show();
  }
}
