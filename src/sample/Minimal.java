/* 
 * (C) Copyright 2007, Andy Clark.  All rights reserved.
 *
 * This file is distributed under an Apache style license. Please
 * refer to the LICENSE file for specific details.
 */

package sample;

import org.cyberneko.html.HTMLConfiguration;
import org.cyberneko.html.filters.DefaultFilter;

import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.parser.XMLParserConfiguration;
import org.apache.xerces.xni.parser.XMLInputSource;

/**
 * This class demonstrates that the NekoHTML parser can be used with
 * a minimal set of Xerces2 classes if you program directory the the
 * Xerces Native Interface (XNI).
 *
 * @author Andy Clark
 */
public class Minimal extends DefaultFilter {

	//
	// MAIN
	//
	
	public static void main(String[] argv) throws Exception {
		XMLParserConfiguration parser = new HTMLConfiguration();
		parser.setDocumentHandler(new Minimal());
		for (int i = 0; i < argv.length; i++) {
			XMLInputSource source = new XMLInputSource(null, argv[i], null);
			parser.parse(source);
		}
	} // main(String[])
	
	//
	// XMLDocumentHandler methods
	//
	
	public void startElement(QName element, XMLAttributes attrs, Augmentations augs) {
		System.out.println("("+element.rawname);
	}
	public void endElement(QName element, Augmentations augs) {
		System.out.println(")"+element.rawname);
	}

} // class Minimal