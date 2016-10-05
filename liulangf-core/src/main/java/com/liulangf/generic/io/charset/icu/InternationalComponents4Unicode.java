package com.liulangf.io.charset.icu;

import com.ibm.icu.text.Collator;
import com.ibm.icu.util.ULocale;

/**
 * @author YuQing Liu
 *
 */
public class InternationalComponents4Unicode {
	
	public static void main(String...args) {
		ULocale locale = new ULocale("en");
		Collator collator = Collator.getInstance(locale);
	}

}
