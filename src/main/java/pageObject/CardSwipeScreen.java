package pageObject;

import abstractComponents.WaitUtill;
import elements.ElementUtils;
import org.openqa.selenium.By;
import utils.Label;

import static abstractComponents.GenericApp.logger;

public class CardSwipeScreen {

    private static final Label swipeScreenTitle = new Label(By.xpath("//android.widget.TextView[@text='Swipe horizontal']"), "Swipe screen title");
    private static final Label card = new Label(By.xpath("(//android.view.ViewGroup[@content-desc='card'])[1]"), "Horizontal swipe card");
    private static final Label cardTitle = new Label(By.xpath("(//android.widget.TextView)[5]"), "Card title");
    private static final Label cardDesc = new Label(By.xpath("//android.widget.TextView[@text='WebdriverIO has a great community that supports all members.']"), "Card description");

    public boolean isSwipeScreenOpen(){
        AppNavigation.navigateToSwipeScreen();
        return swipeScreenTitle.isDisplayed();
    }
    public boolean isGreatCommunityCardVisible() {
        ElementUtils.scroll();
        final int maxIterations = 3;
        final int swipeWaitMillis = 3000;
        int iteration = 0;
        boolean isdisoalyed = true;

        while (isdisoalyed && iteration < maxIterations) {
            iteration++;
            try {
                String cardText = cardTitle.getWrappedElement().getText().trim();

                if ("GREAT COMMUNITY".equals(cardText)) {
                    if (cardDesc.isDisplayed()) {
                        logger.info("Found the 'GREAT COMMUNITY' card with description visible.");
                        isdisoalyed = false;
                        return true;
                    }
                    logger.warn("'GREAT COMMUNITY' card found, but description is not visible.");

                }
            } catch (Exception e) {
                logger.error("Error while checking/swiping card: {}", e.getMessage());
            }

            logger.info("Swiping left on card: {}", card.getName());
            ElementUtils.swipe(card.getWrappedElement(), "right", 0.4);
            WaitUtill.waitFor(swipeWaitMillis);
        }

        logger.warn("The 'GREAT COMMUNITY' card was not found after {} iterations.", maxIterations);
        return false;
    }


}
