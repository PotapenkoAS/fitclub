package ru.vlsu.fitclub.model.viewObject;

public class AchievementImageAndTitle {
    private String image;
    private String title;

    public AchievementImageAndTitle(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
