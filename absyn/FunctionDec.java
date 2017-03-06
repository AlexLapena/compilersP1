package absyn;

public class FunctionDec extends Dec {
  public String func;
  public NameTy result;
  public ExpList exps;
  public FunctionDec( int pos, NameTy result, String func, ExpList exps ) {
    this.pos = pos;
    this.result = result;
    this.func = func;
    this.exps = exps;
  }
}
