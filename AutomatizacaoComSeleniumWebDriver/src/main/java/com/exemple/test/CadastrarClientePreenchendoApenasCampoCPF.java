package com.exemple.test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastrarClientePreenchendoApenasCampoCPF {
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
  public void testCadastrarClientePreenchendoApenasCampoCPF() throws Exception {
    driver.get(baseUrl + "/desafioqa/login");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector("a[title=\"QA\"] > span.menu-item-parent")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector("a[title=\"Clientes\"] > span.menu-item-parent")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector("a[title=\"Incluir\"] > span.menu-item-parent")).click();
    driver.findElement(By.id("cpf")).sendKeys("12345678901");
    driver.findElement(By.id("botaoSalvar")).click();
    
    try {
      assertEquals("Campo Obrigatório", driver.findElement(By.cssSelector("small.help-block")).getText());
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
