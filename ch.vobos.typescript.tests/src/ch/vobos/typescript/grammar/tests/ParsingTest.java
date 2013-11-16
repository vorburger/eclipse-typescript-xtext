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
	
	@Test public void testStruct1() throws Exception {
		parseAndValidate("struct1.ts");
	}

	@Test public void testStruct2() throws Exception {
		parseAndValidate("structs2.ts");
	}

	protected void parseAndValidate(String resourceName) throws Exception {
		String ts = getTS(resourceName);
		Typescript typeScript = parseHelper.parse(ts);
		validationHelper.assertNoErrors(typeScript);
	}

	protected String getTS(String resourceName) throws IOException {
		URL url = Resources.getResource(resourceName);
		String ts = Resources.toString(url, Charsets.UTF_8);
		return ts;
	}

}
