package stepDefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.GalleryModule;

public class GallerySteps {

    private final GalleryModule galleryModule;

    public GallerySteps(GalleryModule galleryModule) {
        this.galleryModule = galleryModule;
    }

    @When("The user clicks on the {int} image on Gallery page")
    public void clickImageOnGalleryPage(int imageNumber) {
        galleryModule.clickImageOnGalleryPage(imageNumber);
    }

    @Then("The user closes the Gallery full screen image")
    public void closeGalleryFullScreenImage() {
        galleryModule.closeGalleryFullScreenImage();
    }

    @When("The user clicks on {string} arrow of the photo slider")
    public void theUserClickOnArrow(String arrowDirection) {
        galleryModule.clickPhotoGalleryArrow(arrowDirection);
    }

}
