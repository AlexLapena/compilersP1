package absyn;

public class ReturnExp extends Exp {
  public ExpList exps;
  public Exp test;
  public ReturnExp( int pos, ExpList exps, Exp test ) {
    this.pos = pos;
    this.exps = exps;
    this.test = test;
  }
}
