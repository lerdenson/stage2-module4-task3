package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder res = new StringBuilder();
        for (AbstractTextComponent component : componentList) {
            res.append(component.operation());
            res.append(component.getComponentType().getDelimiter());
        }
        return res.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        size = componentList
                .stream()
                .map(AbstractTextComponent::getSize)
                .reduce(0, Integer::sum);
        return size;
    }
// Write your code here!
}
