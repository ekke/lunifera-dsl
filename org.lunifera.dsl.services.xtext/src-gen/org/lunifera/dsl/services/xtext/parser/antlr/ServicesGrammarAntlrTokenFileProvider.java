/*
* generated by Xtext
*/
package org.lunifera.dsl.services.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ServicesGrammarAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/lunifera/dsl/services/xtext/parser/antlr/internal/InternalServicesGrammar.tokens");
	}
}
