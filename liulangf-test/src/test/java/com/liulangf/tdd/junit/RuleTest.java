package com.liulangf.tdd.junit;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.TestWatchman;
import org.junit.rules.Timeout;
import org.junit.rules.Verifier;

import com.liulangf.tdd.DigitalAssetManager;


/**
 * &#064;Rule Annotates fields that contain rules. 
 * Such a field must be public, not static, and a subtype of MethodRule.
 * 
 * A MethodRule is an alteration in how a test method is run and reported.
 * Default Rules in Junit4: 
 * <ul>
 *   <li>{@link ErrorCollector}: collect multiple errors in one test method</li>
 *   <li>{@link ExpectedException}: make flexible assertions about thrown exceptions</li>
 *   <li>{@link ExternalResource}: start and stop a server, for example</li>
 *   <li>{@link TemporaryFolder}: create fresh files, and delete after test</li>
 *   <li>{@link TestName}: remember the test name for use during the method</li>
 *   <li>{@link TestWatchman}: add logic at events during method execution</li>
 *   <li>{@link Timeout}: cause test to fail after a set time</li>
 *   <li>{@link Verifier}: fail test if object state ends up incorrect</li>
 * </ul>
 * 
 * @author LiuYuQing
 */
public class RuleTest {
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void countsAssets() throws IOException {
		File icon = tempFolder.newFile("icon.png");
		File assets = tempFolder.newFolder("assets");
		createAssets(assets, 3);

		DigitalAssetManager dam = new DigitalAssetManager(icon, assets);
		Assert.assertEquals(3, dam.getAssetCount());
	}

	private void createAssets(File assets, int numberOfAssets) throws IOException {
		for (int index = 0; index < numberOfAssets; index++) {
			File asset = new File(assets, String.format("asset-%d.mpg", index));
			Assert.assertTrue("Asset couldn't be created.", asset.createNewFile());
		}
	}

	@Test
	public void throwsIllegalArgumentExceptionIfIconIsNull() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Icon is null, not a file, or doesn't exist.");
		new DigitalAssetManager(null, null);
	}

}
