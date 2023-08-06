package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;

public class WordParser extends AbstractTextParser {


    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        if (abstractTextComponent.getComponentType() == TextComponentType.WORD) {
            for (char symbol : string.toCharArray()) {
                abstractTextComponent.add(new SymbolLeaf(symbol, TextComponentType.SYMBOL));
            }
        } else if (nextParser != null) {
            nextParser.parse(abstractTextComponent, string);
        }

    }
}
