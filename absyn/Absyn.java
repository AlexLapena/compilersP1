package absyn;

abstract public class Absyn {
  public int pos;

  final static int SPACES = 4;

  static private void indent( int spaces ) {
    for( int i = 0; i < spaces; i++ ) System.out.print( " " );
  }

  /* ----------------------------Misc List Classes-------------------- */
  static public void showTree( ExpList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  static public void showVarDecTree( VarDecList tree, int spaces ) {
    while( tree != null ) {
      showVarDecTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  static public void showDecTree( DecList tree, int spaces ) {
    while( tree != null ) {
      showDecTree( tree.head, spaces );
      tree = tree.tail;
    } 
  }

  /* ----------------------------Exp Section-------------------- */
  static private void showTree( Exp tree, int spaces ) {
    if( tree instanceof NilExp )
      showTree( (NilExp)tree, spaces );
    else if( tree instanceof VarExp )
      showTree( (VarExp)tree, spaces );
    else if( tree instanceof IntExp )
      showTree( (IntExp)tree, spaces );
    else if( tree instanceof CallExp )
      showTree( (CallExp)tree, spaces );
    else if( tree instanceof OpExp )
      showTree( (OpExp)tree, spaces );
    else if( tree instanceof AssignExp )
      showTree( (AssignExp)tree, spaces );
    else if( tree instanceof VarExp )
      showTree( (VarExp)tree, spaces );
    else if( tree instanceof IfExp ) 
      showTree( (IfExp)tree, spaces );
    else if( tree instanceof WhileExp )
      showTree( (WhileExp)tree, spaces );
    else if( tree instanceof ReturnExp )
      showTree( (ReturnExp)tree, spaces );
    else if( tree instanceof CompoundExp ) 
      showTree( (CompoundExp)tree, spaces );
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  static private void showTree( NilExp tree, int spaces) {
    indent( spaces );
    System.out.println( "NilExp:" );
  }

  static private void showTree( VarExp tree, int spaces) {
    indent( spaces );
    System.out.println( "VarExp:" + tree.variable);
    spaces += SPACES;
  }

  static private void showTree( IntExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "IntExp: " + tree.value ); 
  }

  static private void showTree( CallExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "CallExp: ");
    spaces += SPACES;
    showTree( tree.func, spaces );
    showTree( tree.args, spaces ); 
  }

  static private void showTree( OpExp tree, int spaces ) {
    indent( spaces );
    System.out.print( "OpExp:" ); 
    switch( tree.op ) {
      case OpExp.PLUS:
        System.out.println( " + " );
        break;
      case OpExp.MINUS:
        System.out.println( " - " );
        break;
      case OpExp.MUL:
        System.out.println( " * " );
        break;
      case OpExp.DIV:
        System.out.println( " / " );
        break;
      case OpExp.EQ:
        System.out.println( " = " );
        break;
      case OpExp.LT:
        System.out.println( " < " );
        break;
      case OpExp.LTE:
        System.out.println( " <= " );
        break;
      case OpExp.GT:
        System.out.println( " > " );
        break;
      case OpExp.GTE:
        System.out.println( " >= " );
        break;
      case OpExp.EQEQ:
        System.out.println( " == " );
        break;
      case OpExp.NE:
        System.out.println( " != " );
        break;
      case OpExp.EQUALS:
        System.out.println( " < " );
        break;
      default:
        System.out.println( "Unrecognized operator at line " + tree.pos);
    }
    spaces += SPACES;
    showTree( tree.left, spaces );
    showTree( tree.right, spaces ); 
  }

  static private void showTree( AssignExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "AssignExp:" );
    spaces += SPACES;
    showTree( tree.lhs, spaces );
    showTree( tree.rhs, spaces );
  }

  static private void showTree( IfExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "IfExp:" );
    spaces += SPACES;
    showTree( tree.test, spaces );
    showTree( tree.thenpart, spaces );
    showTree( tree.elsepart, spaces );
  }

  static private void showTree( WhileExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "WhileExp:" );
    showTree( tree.test, spaces );
    showTree( tree.body, spaces );
  }

  static private void showTree( ReturnExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "ReturnExp:" );
    showTree( tree.exp, spaces + SPACES ); 
  }

  static private void showTree( CompoundExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "CompoundExp:" );
    spaces += SPACES;
    showTree( tree.decs, spaces );
    showTree( tree.exps, spaces );
  }

  /* ----------------------------Dec Section-------------------- */
  static private void showDecTree( Exp tree, int spaces ) {
    if( tree instanceof FunctionDec )
      showTree( (FunctionDec)tree, spaces );
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  static private void showDecTree( FunctionDec tree, int spaces ) {
    indent( spaces );
    System.out.println( "FunctionDec:" );
    spaces += SPACES;
    showDecTree( tree.result, spaces );
    showDecTree( tree.exps, spaces );
    showDecTree( tree.func, spaces );
  }

  /* ----------------------------VarDec Section-------------------- */
  static private void showVarDecTree( Exp tree, int spaces ) {
    if( tree instanceof SimpleDec )
      showTree( (SimpleDec)tree, spaces );
    else if( tree instanceof ArrayDec )
      showTree( (ArrayDec)tree, spaces );
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  static private void showVarDecTree( SimpleDec tree, int spaces ) {
    indent( spaces );
    System.out.println( "SimpleDec:" );
    spaces += SPACES;
    showVarDecTree( tree.typ, spaces );
    showVarDecTree( tree.name, spaces );
  }

  static private void showVarDecTree( ArrayDec tree, int spaces ) {
    indent( spaces );
    System.out.println( "ArrayDec:" );
    spaces += SPACES;
    showVarDecTree( tree.typ, spaces );
    showVarDecTree( tree.name, spaces );
    showVarDecTree( tree.size, spaces );
  }

}
