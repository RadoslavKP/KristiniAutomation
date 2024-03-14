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

}
