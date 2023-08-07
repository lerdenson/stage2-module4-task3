package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        if (abstractTextComponent.getComponentType() == TextComponentType.SENTENCE) {
            String[] lexemes = string.split(LEXEME_REGEX);
            AbstractTextComponent component;
            for (String lexeme : lexemes) {
                if (lexeme.matches(WORD_REGEX)) {
                    component = new TextComponent(TextComponentType.WORD);
                    if (nextParser != null) {
                        nextParser.parse(component, lexeme);
                        abstractTextComponent.add(component);
                    }
                } else {
                    for (char symbol: lexeme.toCharArray()) {
                        abstractTextComponent.add(new SymbolLeaf(symbol, TextComponentType.SYMBOL));
                    }
                }


            }
        } else if (nextParser != null) {
            nextParser.parse(abstractTextComponent, string);
        }
    }

}
