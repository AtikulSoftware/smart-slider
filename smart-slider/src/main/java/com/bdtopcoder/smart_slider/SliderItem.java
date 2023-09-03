package com.bdtopcoder.smart_slider;

public class SliderItem {

    int Images;
    String ImagesUrl;
    String title;

    public SliderItem() {
    }

    public SliderItem(int images) {
        Images = images;
    }

    public SliderItem(String imagesUrl) {
        ImagesUrl = imagesUrl;
    }

    public SliderItem(int images, String title) {
        Images = images;
        this.title = title;
    }

    public SliderItem(String imagesUrl, String title) {
        ImagesUrl = imagesUrl;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }

    public String getImagesUrl() {
        return ImagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        ImagesUrl = imagesUrl;
    }

} // SliderItem End Here ========
