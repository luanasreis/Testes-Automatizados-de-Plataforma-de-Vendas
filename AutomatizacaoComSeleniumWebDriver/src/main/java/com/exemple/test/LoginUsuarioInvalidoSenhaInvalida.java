package com.exemple.test;

import java.util.concurrent.TimeUnit;
	import org.junit.*;
	import static org.junit.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class LoginUsuarioInvalidoSenhaInvalida {
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://provaqa.marketpay.com.br:9080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testLoginComUsuarioInvalidoeSenhaInvalida() throws Exception {
	    driver.get(baseUrl + "/desafioqa/login");

	    driver.findElement(By.name("username")).sendKeys("logininvalido");
	    driver.findElement(By.name("password")).sendKeys("senhainvalida");
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    try {
	      assertEquals("Credenciais inválidas", driver.findElement(By.cssSelector("label")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	}
