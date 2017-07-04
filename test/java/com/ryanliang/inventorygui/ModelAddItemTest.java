package com.ryanliang.inventorygui;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelAddItemTest {
	private static Modellable model;
	private Media media;
	private static String db_URL = "jdbc:mysql://localhost:3306/media";
	private static String user = "root";
	private static String password = "asasas";
	private static Random random;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		random = new Random();
		model = new InventoryModel();
		model.getDBConnection(db_URL, user, password);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		model.disconnectFromDatabase();
		model = null;
		random = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		media = null;
	}

	@Test
	public void testAddItem() {
		String itemID = model.getID();
		Integer randomNum = random.nextInt();
		String title = "book" + randomNum.toString(); 
		media = new Book(itemID, title, "desc1", "gen1", "author1", "isbn");	
		
		String quantity = "1";
		model.addItem(media, quantity);
		model.searchItem(itemID);
		media = model.getSearchResult()[0];
		
		//Book title shall be the same as when it was added.
		Assert.assertEquals(title, media.getTitle());
	}

}
