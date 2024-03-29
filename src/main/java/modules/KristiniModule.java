package modules;

import pages.KristiniPage;

public class KristiniModule {
    private KristiniPage kristiniPage;

    public KristiniModule(KristiniPage kristiniPage) {
        this.kristiniPage = kristiniPage;
    }


    public void navigateToStringFromNavigationMenu(String categoryTitle) {
        kristiniPage.navigateToStringFromNavigationMenu(categoryTitle);
    }

    public void verifySpecificPageIsLoaded(String pageName) {
        kristiniPage.verifySpecificPageIsLoaded(pageName);
    }

    public void navigateToSubCategoryFromPLP(String subCategory) {
        kristiniPage.navigateToSubCategoryFromPLP(subCategory);
    }

    public void openSpecificProductFromPLP(String productName) {
        kristiniPage.openSpecificProductFromPLP(productName);
    }

    public void verifyPDPIsLoaded() {
        kristiniPage.verifyPDPIsLoaded();
    }

    public void clickImageNumberFromSlider(int imageNumber) {
        kristiniPage.clickImageNumberFromSlider(imageNumber);
    }

    public void verifyGalleryPage() {
        kristiniPage.verifyGalleryPage();
    }

}
