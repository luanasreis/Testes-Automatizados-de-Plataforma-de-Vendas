package com.exemple.test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastrarClienteComCPFjaCadastrado {
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
  public void testCadastrarClienteComCPFjaCadastrado() throws Exception {
    driver.get(baseUrl + "/desafioqa/login");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector("a[title=\"QA\"] > span.menu-item-parent")).click();
    Thread.sleep(500);
    driver.findElement(By.linkText("Clientes")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector("a[title=\"Incluir\"] > span.menu-item-parent")).click();
    Thread.sleep(500);
    driver.findElement(By.id("nome")).sendKeys("Usuario Test");
    driver.findElement(By.id("cpf")).sendKeys("12345654321");
    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Ativo");
    driver.findElement(By.id("saldoCliente")).sendKeys("15000");
    driver.findElement(By.id("botaoSalvar")).click();
    try {
      assertEquals("Cliente salvo com sucesso", driver.findElement(By.cssSelector("strong")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("a[title=\"QA\"] > span.menu-item-parent")).click();
    Thread.sleep(500);
    driver.findElement(By.linkText("Clientes")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector("a[title=\"Incluir\"] > span.menu-item-parent")).click();
    Thread.sleep(500);
    driver.findElement(By.id("nome")).sendKeys("Usuario Teste");
    driver.findElement(By.id("cpf")).sendKeys("12345654321");
    new Select(driver.findElement(By.id("status"))).selectByVisibleText("Ativo");
    driver.findElement(By.id("saldoCliente")).sendKeys("15000");
    driver.findElement(By.id("botaoSalvar")).click();
    try {
      assertEquals("CPF j� cadastrado.", driver.findElement(By.cssSelector("div.col-sm-12.col-md-2 > small.help-block")).getText());
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
