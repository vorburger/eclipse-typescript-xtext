package ch.vobos.typescript.standalone;

import javax.inject.Inject;

import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;

import ch.vobos.TypescriptStandaloneSetup;
import ch.vobos.typescript.Typescript;

import com.google.inject.Injector;

/**
 * NEVER CALL THIS CLASS FROM WITHIN AN ECLIPSE PLUG-IN.
 * Use this only for "standalone" scenarios (i.e. a Maven plug-in, or a test).
 * 
 * @author Michael Vorburger
 */
public class TypeScriptStandalone {
	
	private static TypeScriptStandalone INSTANCE;

	public static TypeScriptStandalone getInstance() {
		if (INSTANCE == null) {
			Injector injector = new TypescriptStandaloneSetup().createInjectorAndDoEMFRegistration();
			INSTANCE = injector.getInstance(TypeScriptStandalone.class);
		}
		return INSTANCE;
	}

	private TypeScriptStandalone() {
	}

	private @Inject ParseHelper<Typescript> parseHelper;
	private @Inject ValidationTestHelper validationHelper;

	public Typescript parseAndValidate(String typeScript) throws AssertionError, Exception {
		// see also same code in ch.vobos.typescript.grammar.tests.ParsingTest.parseAndValidate(String)
		Typescript typeScriptAST = parseHelper.parse(typeScript);
		validationHelper.assertNoErrors(typeScriptAST);
		return typeScriptAST;
	}
	
}
