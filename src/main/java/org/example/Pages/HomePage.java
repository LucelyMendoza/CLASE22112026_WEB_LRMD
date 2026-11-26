package org.example.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {
    // Vista principal de productos
    public static final Target LNK_PRODUCTO = Target.the("Producto {0} del catalogo")
            .locatedBy("//a[@class='hrefch' and text()='{0}']");
    public static final Target BTN_AGREGAR_CARRITO = Target.the("Boton para agregar al carrito")
            .located(By.xpath("//a[text()='Add to cart']"));
    public static final Target LNK_CARRITO = Target.the("Enlace para ir al carrito")
            .located(By.id("cartur"));

    // Carrito
    public static final Target LST_PRODUCTOS_CARRITO = Target.the("Nombres de productos en el carrito")
            .located(By.xpath("//tbody[@id='tbodyid']/tr/td[2]"));
    public static final Target BTN_PLACE_ORDER = Target.the("Boton Place Order")
            .located(By.xpath("//button[text()='Place Order']"));

    // LLenado de formulario
    public static final Target INP_NOMBRE = Target.the("Input para ingresar nombre")
            .located(By.id("name"));
    public static final Target INP_PAIS = Target.the("Input para ingresar pais")
            .located(By.id("country"));
    public static final Target INP_CIUDAD = Target.the("Input para ingresar ciudad")
            .located(By.id("city"));
    public static final Target INP_TARJETA = Target.the("Input para ingresar tarjeta")
            .located(By.id("card"));
    public static final Target INP_MES = Target.the("Input para ingresar mes")
            .located(By.id("month"));
    public static final Target INP_ANIO = Target.the("Input para ingresar anio")
            .located(By.id("year"));
    public static final Target BTN_PURCHASE = Target.the("Boton Purchase")
            .located(By.xpath("//button[text()='Purchase']"));

    //Confirmación de compra
    public static final Target LBL_MENSAJE_COMPRA = Target.the("Mensaje de confirmacion de compra")
            .located(By.cssSelector(".sweet-alert h2"));
    public static final Target BTN_OK_COMPRA = Target.the("Boton OK de la confirmacion")
            .located(By.cssSelector(".sweet-alert .confirm"));
}
