package com.mjc.stage2.entity;

public class SymbolLeaf extends AbstractTextComponent {

    private char value;

    public SymbolLeaf(TextComponentType componentType) {
        super(componentType);
    }

    public SymbolLeaf(char symbol, TextComponentType componentType) {
        super(componentType);
        this.value = symbol;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String operation() {
        return Character.toString(value);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return 1;
    }

}
