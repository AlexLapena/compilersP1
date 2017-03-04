package absyn;

// originally readExp
public class ElseExp extends Exp {
  public VarExp input;
  public ElseExp( int pos, VarExp input ) {
    this.pos = pos;
    this.input = input;
  }
}
