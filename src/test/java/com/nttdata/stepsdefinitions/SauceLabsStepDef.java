package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SauceLabsLoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SauceLabsStepDef {

    @Steps
    SauceLabsLoginSteps login;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        // Verificamos si el título está visible
        boolean isTitleVisible = login.isTitleElementVisible();
        Assert.assertTrue("El título de la App Store no se encontró en la vista.", isTitleVisible);
    }

    @And("valido que carguen correctamente los productos en la galería")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGalería() {
        boolean isProductTextVisible = login.isProductTextElementVisible();
        Assert.assertTrue("No se encontraron productos en la galería.", isProductTextVisible);
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(int unidades, String producto) {
        // Llamar a los métodos correspondientes para seleccionar el producto y aumentar la cantidad
        login.selectProduct(producto);

        // Para el tercer producto, comprobamos si el botón para aumentar la cantidad está visible y hacemos clic en él
        if (unidades > 1) {
            boolean isIncreaseButtonVisible = login.isIncreaseQuantityButtonVisible();
            Assert.assertTrue("El botón para aumentar la cantidad no está visible.", isIncreaseButtonVisible);

            // Aumentamos la cantidad hasta el número deseado
            for (int i = 1; i < unidades; i++) {
                login.clickIncreaseQuantity();
            }
        }
    }

    @Then("valido que el carrito de compra se actualice correctamente")
    public void validoQueElCarritoDeCompraSeActualiceCorrectamente() {
        // Hacer clic en el botón del carrito
        login.clickCartButton();

        // Obtener el valor del carrito
        String cartValue = login.getCartValue();

        // Aquí puedes validar el valor del carrito si tienes un valor esperado
        // Ejemplo: Validar que el valor del carrito sea igual al esperado
        Assert.assertTrue("El valor del carrito no coincide con el esperado.", cartValue.equals("2")); // Ajusta el valor esperado según tus pruebas
    }
}
