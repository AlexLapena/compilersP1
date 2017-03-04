package absyn;

public class VoidExp extends Exp {
  public Exp output;
  public VoidExp( int pos, Exp output ) {
    this.pos = pos;
    this.output = output;
  }
}
