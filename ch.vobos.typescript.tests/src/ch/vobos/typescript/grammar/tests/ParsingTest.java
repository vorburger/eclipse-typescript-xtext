package ch.vobos.typescript.grammar.tests;

import java.io.IOException;
import java.net.URL;

import javax.inject.Inject;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.vobos.TypescriptInjectorProvider;
import ch.vobos.typescript.Typescript;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@RunWith(XtextRunner.class)
@InjectWith(TypescriptInjectorProvider.class)
public class ParsingTest {

	@Inject ParseHelper<Typescript> parseHelper;
	@Inject ValidationTestHelper validationHelper;
	
	@Test public void testSimple() throws Exception {
		parseAndValidate("/simple.ts");
	}

	@Test public void testExtends() throws Exception {
		parseAndValidate("/extends.ts");
	}

	@Test public void testArray() throws Exception {
		parseAndValidate("/array.ts");
	}

	@Test public void testTypeLitteral() throws Exception {
		parseAndValidate("/type-litteral.ts");
	}

	@Test public void testClass() throws Exception {
		parseAndValidate("/class.ts");
	}

	@Test public void testModule() throws Exception {
		parseAndValidate("/module.ts");
	}

	@Test public void testIndexSignature() throws Exception {
		parseAndValidate("/index.ts");
	}	
	
	protected void parseAndValidate(String resourceName) throws Exception {
		// see also same code in ch.vobos.typescript.standalone.TypeScriptStandalone.parseAndValidate(String)
		String ts = getTS(resourceName);
		Typescript typeScript = parseHelper.parse(ts);
		validationHelper.assertNoErrors(typeScript);
	}

	protected String getTS(String resourceName) throws IOException {
		// It's important to use getResource(Class<?> contextClass, String resourceName)
		// here and not just getResource(String resourceName), because while in a standalone JSE
		// test this will work, when running as a (Tycho) OSGi test it won't...
		URL url = Resources.getResource(ParsingTest.class, resourceName);
		String ts = Resources.toString(url, Charsets.UTF_8);
		return ts;
	}

}
