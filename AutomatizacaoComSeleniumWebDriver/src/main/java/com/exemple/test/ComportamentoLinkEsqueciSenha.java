package com.exemple.test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComportamentoLinkEsqueciSenha {
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
  public void testComportamentoLinkEsqueciSenha() throws Exception {
    driver.get(baseUrl + "/desafioqa/login");
    driver.findElement(By.linkText("Forgot password?")).click();
    driver.get("http://provaqa.marketpay.com.br:9080/desafioqa/esqueciasenha");
    driver.findElement(By.id("redefinirSenha")).sendKeys("meu@email.com");
    driver.findElement(By.id("botaoEnviar")).click();
    try {
      assertEquals("Redefinição de Senha enviada!", driver.findElement(By.cssSelector("strong")).getText());
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
