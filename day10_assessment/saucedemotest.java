package day10assessment;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;
import genericUtility.baseclass;

import pom2.cartpage;
import pom2.checkout;
import pom2.loginpage;
import pom2.productPage;

public class saucedemotest extends baseclass {


    @Test(priority = 1)
    public void loginTest() throws Exception {

        String username =p.getProperty("username");
        String password =p.getProperty("password");
        loginpage loginPage =new loginpage(driver);
        loginPage.login(username,password);
                


        productPage productsPage =new productPage(driver);
        String actualTitle = productsPage.getProductsTitle();
               


        Assert.assertEquals( actualTitle,"Products", "Products page is not displayed");
               
               

        System.out.println(
                "Products page is displayed");

        System.out.println(
                "Login Test Completed");
    }


    @Test(
            priority = 2,
            dependsOnMethods = "loginTest"
    )
    public void orderPlacementTest() throws Exception {


        System.out.println(
                "Login successful");


        productPage productsPage =
                new productPage(driver);


        
        productsPage.addBackpack();


        

        String cartCount =
                productsPage.getCartCount();


        System.out.println(
                "Cart count = " + cartCount);


        Assert.assertEquals(
                cartCount,
                "1",
                "Cart does not contain 1 item");


        System.out.println(
                "Cart contains 1 item");


       
        productsPage.clickCart();


        
        cartpage cartPage =
                new cartpage(driver);


        String itemName =
                cartPage.getBackpackName();


        System.out.println(
                "Item in cart = " + itemName);


        Assert.assertEquals(
                itemName,
                "Sauce Labs Backpack",
                "Sauce Labs Backpack is not displayed");


        System.out.println(
                "Sauce Labs Backpack is displayed");


        
        cartPage.clickCheckout();


       
        String firstName =
                ExcelUtility.getData(
                        "Sheet1", 1, 0);

        String lastName =
                ExcelUtility.getData(
                        "Sheet1", 1, 1);

        String postalCode =
                ExcelUtility.getData(
                        "Sheet1", 1, 2);


       

        checkout checkoutPage =
                new checkout(driver);


        checkoutPage.enterFirstName(
                firstName);

        checkoutPage.enterLastName(
                lastName);

        checkoutPage.enterPostalCode(
                postalCode);


        checkoutPage.clickContinue();


        

        String actualPageTitle =
                checkoutPage.getPageTitle();


        Assert.assertEquals(
                actualPageTitle,
                "Checkout: Overview",
                "Checkout Overview page is not displayed");


        System.out.println(
                "Checkout: Overview page is displayed");


       
        checkoutPage.clickFinish();


        
        String actualMessage =
                checkoutPage.getThankYouMessage();


        System.out.println(
                "Order Message = " + actualMessage);


        Assert.assertEquals(
                actualMessage,
                "Thank you for your order!",
                "Thank you message is not displayed");


        System.out.println(
                "Thank you for your order!");

        System.out.println(
                "Order Placement Test Completed");
    }
}