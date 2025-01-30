package modules;

import pages.NavigationPage;

public class NavigationModule {
    private final NavigationPage navigationPage;

    public NavigationModule(NavigationPage navigationPage) {
        this.navigationPage = navigationPage;
    }

    public void navigateToMenuCategory(String categoryTitle) {
        navigationPage.navigateToMenuCategory(categoryTitle);
    }

    public void navigateToSubCategoryFromPLP(String subCategory) {
        navigationPage.navigateToSubCategoryFromPLP(subCategory);
    }

    public void verifySpecificPageIsLoaded(String pageName) {
        navigationPage.verifySpecificPageIsLoaded(pageName);
    }

    public void openSearchBar() {
        navigationPage.openSearchBar();
    }

    public void searchTermAndSubmit(String searchTerm) {
        navigationPage.typeInSearchTermInSearchBar(searchTerm);
        navigationPage.submitSearch();
    }

}
