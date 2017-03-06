package absyn;

//Concrete class --> needs to be examined
public class NameTy extends absyn implements VarDec{
  public NameTy( int pos, int typ) {
  	this.pos = pos;
  	this.typ = typ;
  }
}