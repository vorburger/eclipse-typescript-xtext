/*
* generated by Xtext
*/
package ch.vobos;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TypescriptStandaloneSetup extends TypescriptStandaloneSetupGenerated{

	public static void doSetup() {
		new TypescriptStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

