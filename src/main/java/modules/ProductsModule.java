package modules;

import pages.ProductsPage;

public class ProductsModule {
    private final ProductsPage productsPage;

    public ProductsModule(ProductsPage productsPage) {
        this.productsPage = productsPage;
    }

    public void openSpecificProductFromPLP(String productName) {
        productsPage.openSpecificProductFromPLP(productName);
    }

    public void verifyPDPIsLoaded() {
        productsPage.verifyPDPIsLoaded();
    }

}
