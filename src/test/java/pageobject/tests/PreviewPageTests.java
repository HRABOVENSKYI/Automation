package pageobject.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PreviewPageTests extends BaseTest {

    @Test
    public void checkIfAllLinksToPreviewImagesAreDifferent() {

        List<String> linksToImages = new ArrayList<>();
        for (WebElement element : getHomePage().getPreviewElements()) {
            linksToImages.add(element.getAttribute("data-src"));
        }

        // Hardcode first element because it is opened by default and we read another instead
        linksToImages.set(0, "https://avic.ua/assets/cache/sliders/1/dnipro-25-1031-299.png");

        Assert.assertTrue(areDistinct((ArrayList) getHomePage().getPreviewElements()));
    }

    public boolean areDistinct(List<String> linksList) {
        Set<String> linksSet = new HashSet<>(linksList);
        return (linksSet.size() == linksList.size());
    }
}
