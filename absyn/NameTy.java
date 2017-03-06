package absyn;

//Concrete class --> needs to be examined
public class NameTy extends absyn implements VarDec{
  public static int INT = 0;
  public static int VOID = 1;
  public NameTy( int pos, int typ) {
  	this.pos = pos;
  	this.typ = typ;
  }
}