package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.Scope;
import org.yinwang.pysonar.types.Type;


public class UnaryOp extends Node
{

    public Node op;
    public Node operand;


    public UnaryOp(Node op, Node n, int start, int end)
    {
        super(start, end);
        this.op = op;
        this.operand = n;
        addChildren(op, n);
    }


    @NotNull
    @Override
    public Type resolve(Scope s)
    {
        return resolveExpr(operand, s);
    }


    @NotNull
    @Override
    public String toString()
    {
        return "<UOp:" + op + ":" + operand + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v)
    {
        if (v.visit(this))
        {
            visitNode(op, v);
            visitNode(operand, v);
        }
    }
}
