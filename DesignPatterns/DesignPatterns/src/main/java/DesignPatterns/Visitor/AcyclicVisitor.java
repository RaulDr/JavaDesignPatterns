package DesignPatterns.Visitor;

interface AVisitor{} //marker interface

interface AExpressionVisitor extends AVisitor{
    void visit(AExpression obj);
}

interface ADoubleExpressionVisitor extends AVisitor{
    void visit(ADoubleExpression obj);
}

interface AAdditionExpressionVisitor extends AVisitor{
    void visit(AAdditionExpression obj);
}

abstract class AExpression{
    public void accept(AVisitor visitor){
        if(visitor instanceof AExpressionVisitor){
            ((AExpressionVisitor) visitor).visit(this);
        }
    };
}

class ADoubleExpression extends AExpression{
    public double value;

    public ADoubleExpression(double value){
        this.value = value;
    }

    @Override
    public void accept(AVisitor visitor) {
        if(visitor instanceof ADoubleExpressionVisitor) {
            ((ADoubleExpressionVisitor)visitor).visit(this);
        }
    }
}

class AAdditionExpression extends AExpression{

    public AExpression left, right;

    public AAdditionExpression(AExpression left, AExpression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(AVisitor visitor) {
        if(visitor instanceof AAdditionExpressionVisitor) {
            ((AAdditionExpressionVisitor)visitor).visit(this);
        }
    }
}

class AExpressionPrinter implements ADoubleExpressionVisitor, AAdditionExpressionVisitor{

    private StringBuilder sb = new StringBuilder();

    @Override
    public void visit(ADoubleExpression e) {
        sb.append(e.value);
    }

    @Override
    public void visit(AAdditionExpression e) {
        sb.append("(");
        e.left.accept(this);
        sb.append("+");
        e.right.accept(this);
        sb.append(")");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

public class AcyclicVisitor {
    // 1+(2+3)
    public static void main(String[] args) {
        AAdditionExpression e = new AAdditionExpression(new ADoubleExpression(1),
                new AAdditionExpression(
                        new ADoubleExpression(2),
                        new ADoubleExpression(3)
                ));
        AExpressionPrinter ep = new AExpressionPrinter();
        ep.visit(e);
        System.out.println(ep);

    }
}
