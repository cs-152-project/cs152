package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

/**
 * FWJS expressions.
 */
public interface Expression {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env);
}

// NOTE: Using package access so that all implementations of Expression
// can be included in the same file.

/**
 * FWJS constants.
 */
class ValueExpr implements Expression {
    private Value val;
    public ValueExpr(Value v) {
        this.val = v;
    }
    public Value evaluate(Environment env) {
        return this.val;
    }
}

/**
 * Expressions that are a FWJS variable.
 */
class VarExpr implements Expression {
    private String varName;
    public VarExpr(String varName) {
        this.varName = varName;
    }
    public Value evaluate(Environment env) {
        return env.resolveVar(varName);
    }
}

/**
 * A print expression.
 */
class PrintExpr implements Expression {
    private Expression exp;
    public PrintExpr(Expression exp) {
        this.exp = exp;
    }
    public Value evaluate(Environment env) {
        Value v = exp.evaluate(env);
        System.out.println(v.toString());
        return v;
    }
}
/**
 * Binary operators (+, -, *, etc).
 * Currently only numbers are supported.
 */
class BinOpExpr implements Expression {
    private Op op;
    private Expression e1;
    private Expression e2;
    public BinOpExpr(Op op, Expression e1, Expression e2) {
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    @SuppressWarnings("incomplete-switch")
    public Value evaluate(Environment env) {
        Value a = this.e1.evaluate(env);
        Value b = this.e2.evaluate(env);
        IntVal num1 = (IntVal) a;
        IntVal num2 = (IntVal) b;
        int result;
        IntVal res;
        Value res_final = new NullVal();
        boolean check = false;
        BoolVal boo;

        switch(this.op)
        {
            case ADD :
                    
                    result = num1.toInt() + num2.toInt();
                    res = new IntVal(result);
                    res_final =  (Value) res;
            break;

            case SUBTRACT :
                    result = num1.toInt() - num2.toInt();
                    res = new IntVal(result);
                    res_final =  (Value) res;
            break;

            case MULTIPLY :
                    result = num1.toInt() * num2.toInt();
                    res = new IntVal(result);
                    res_final =  (Value) res;
            break;

            case DIVIDE :
                    result = num1.toInt() / num2.toInt();
                    res = new IntVal(result);
                    res_final =  (Value) res;
            break;

            case MOD :
                    result = num1.toInt() % num2.toInt();
                    res = new IntVal(result);
                    res_final =  (Value) res;
            break;

            case GT :
                    if(num1.toInt() > num2.toInt())
                        check = true;
                    boo =  new BoolVal(check);
                    res_final =  (Value) boo;
            break;

            case GE :
                    if(num1.toInt() >= num2.toInt())
                        check = true;
                    boo =  new BoolVal(check);
                    res_final =  (Value) boo;
            break;

            case LT :
                    if(num1.toInt() < num2.toInt())
                        check = true;
                    boo =  new BoolVal(check);
                    res_final =  (Value) boo;
            break;

            case LE :
                    if(num1.toInt() <= num2.toInt())
                        check = true;
                    boo =  new BoolVal(check);
                    res_final =  (Value) boo;
            break;

            case EQ :
                    if(num1.toInt() == num2.toInt())
                        check = true;
                    boo =  new BoolVal(check);
                    res_final =  (Value) boo;
            break;

            default:
                return new NullVal();
        }
        return res_final;
    }
}

/**
 * If-then-else expressions.
 * Unlike JS, if expressions return a value.
 */
class IfExpr implements Expression {
    private Expression cond;
    private Expression thn;
    private Expression els;
    public IfExpr(Expression cond, Expression thn, Expression els) {
        this.cond = cond;
        this.thn = thn;
        this.els = els;
    }
    public Value evaluate(Environment env) {
        Value c = this.cond.evaluate(env);
        Value t = this.thn.evaluate(env);
        Value e = this.els.evaluate(env);
        BoolVal condition = (BoolVal) c;
        if(condition.toBoolean() == true)
            return t;
        else
            return e;
    }
}

/**
 * While statements (treated as expressions in FWJS, unlike JS).
 */
class WhileExpr implements Expression {
    private Expression cond;
    private Expression body;
    public WhileExpr(Expression cond, Expression body) {
        this.cond = cond;
        this.body = body;
    }
    public Value evaluate(Environment env) {
        BoolVal con = (BoolVal) this.cond.evaluate(env);
        //Value bod = this.body.evaluate(env);
        //BoolVal condition = (BoolVal) con;
        while(con.toBoolean())
        {
            return this.body.evaluate(env);
        }
        return null;
    }
}

/**
 * Sequence expressions (i.e. 2 back-to-back expressions).
 */
class SeqExpr implements Expression {
    private Expression e1;
    private Expression e2;
    public SeqExpr(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    public Value evaluate(Environment env) {
        Value a = this.e1.evaluate(env);
        Value b = this.e2.evaluate(env);
        return b;
    }
}

/**
 * Declaring a variable in the local scope.
 */
class VarDeclExpr implements Expression {
    private String varName;
    private Expression exp;
    public VarDeclExpr(String varName, Expression exp) {
        this.varName = varName;
        this.exp = exp;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
        // create the variable in the current environment
        // and return it(?)
        env.createVar(varName, exp.evaluate(env));
        return env.resolveVar(varName);
    }
}

/**
 * Updating an existing variable.
 * If the variable is not set already, it is added
 * to the global scope.
 */
class AssignExpr implements Expression {
    private String varName;
    private Expression e;
    public AssignExpr(String varName, Expression e) {
        this.varName = varName;
        this.e = e;
    }
    public Value evaluate(Environment env) {
        Value vari = e.evaluate(env);
        env.updateVar(varName, vari);
        return env.resolveVar(varName);
    }
}

/**
 * A function declaration, which evaluates to a closure.
 */
class FunctionDeclExpr implements Expression {
    private List<String> params;
    private Expression body;
    public FunctionDeclExpr(List<String> params, Expression body) {
        this.params = params;
        this.body = body;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
        // create the closure and returning it
        ClosureVal closure = new ClosureVal(params, body, env);
        return closure;
    }
}

/**
 * Function application.
 */
class FunctionAppExpr implements Expression {
    private Expression f;
    private List<Expression> args;
    public FunctionAppExpr(Expression f, List<Expression> args) {
        this.f = f;
        this.args = args;
    }
    public Value evaluate(Environment env) {
        // YOUR CODE HERE
        // Make a List of Values by evaluating the List of Expressions
        List<Value> values = new ArrayList<>();
        for(Expression arg : args)
                values.add(arg.evaluate(env));
        // using the environment
        f.evaluate(env);
        return null;
    }
}

