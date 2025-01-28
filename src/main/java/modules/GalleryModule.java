package modules;

import pages.GalleryPage;

public class GalleryModule {
    private final GalleryPage galleryPage;

    public GalleryModule(GalleryPage galleryPage) {
        this.galleryPage = galleryPage;
    }

    public void clickImageOnGalleryPage(int imageNumber) {
        galleryPage.clickImageOnGalleryPage(imageNumber);
    }

    public void clickPhotoGalleryArrow(String arrowDirection) {
        galleryPage.clickPhotoGalleryArrow(arrowDirection);
    }

    public void closeGalleryFullScreenImage() {
        galleryPage.closeGalleryFullScreenImage();
    }

}
