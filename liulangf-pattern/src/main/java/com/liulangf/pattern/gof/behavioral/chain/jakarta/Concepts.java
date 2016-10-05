package com.liulangf.pattern.gof.behavioral.chain.jakarta;

import org.apache.commons.chain.Chain;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

/**
 * <<Manning.Jakarta.Commons.Online.Bookshelf.Mar.2005>>
 * <p>
 * Three important concepts in the Chain component define its API:
 * <ul>
 *   <li>command</li>
 *   <li>chain</li>
 *   <li>context</li>
 * </ul>
 * 
 * <p>
 * import org.apache.commons.chain.*;
 * 
 * <p>
 * Each command is executed until a command informs the chain it that it has successfully 
 * completed the task, at which point processing stops and no further commands are executed. 
 * If no command is successful in completing the task, the chain returns with the response 
 * of the last command in the chain or an exception.
 *
 * <p>
 * Each command in the chain gets a context, which represents the current state of the chain’s 
 * variables. Not surprisingly, the context is implemented as a map, thus allowing name-value pairing.
 */
public class Concepts {
    
    public static void main(String... args) throws Exception {
        
        Chain chain = new ChainBase();
        chain.addCommand(new Command() {
            public boolean execute(Context context) {
                System.out.println("Hello World");
                context.put("name", "good");
                return false;
            }
        });
        
        chain.addCommand(new Command() {
            public boolean execute(Context context) {
                String name = (String) context.get("name");
                context.put("name", name + " Boy.");
                return false;
            }
        });
        
        Context context = new ContextBase();
        chain.execute(context);
        System.out.println(context.get("name"));
    }

}
