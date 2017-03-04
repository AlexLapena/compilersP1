package absyn;

public class WhileExp extends Exp {
  public Exp output;
  public WhileExp( int pos, Exp output ) {
    this.pos = pos;
    this.output = output;
  }
}
