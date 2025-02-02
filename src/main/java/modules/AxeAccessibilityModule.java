package modules;

import pages.AxeAccessibilityPage;

public class AxeAccessibilityModule {
    private final AxeAccessibilityPage axeAccessibilityPage;

    public AxeAccessibilityModule(AxeAccessibilityPage axeAccessibilityPage) {
        this.axeAccessibilityPage = axeAccessibilityPage;
    }

    public void scanCurrentPageForViolationsWithAxe() {
        axeAccessibilityPage.scanCurrentPageForViolationsWithAxe();
    }

}
