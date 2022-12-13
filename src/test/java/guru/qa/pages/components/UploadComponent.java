package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadComponent {

    public UploadComponent uploadPicture(String pictureName) {
        $("#uploadPicture").uploadFromClasspath(pictureName);

        return this;
    }
}
