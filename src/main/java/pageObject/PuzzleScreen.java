package pageObject;

import utils.Assertions;
import utils.Label;
import elements.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static abstractComponents.GenericApp.logger;
import static abstractComponents.WaitUtill.waitUntilElementToVisible;

public class PuzzleScreen {

    private static final Label dragAndDropScreen = new Label(By.xpath("//android.widget.TextView[@text='Drag and Drop']"), "Drag and drop screen");
    private static final Label congratulations = new Label(By.xpath("//android.view.ViewGroup[@content-desc='Drag-drop-screen']/android.view.ViewGroup[1]/android.view.ViewGroup[1]"), "Congratulations");
    private static final Label congratulationsMsg = new Label(By.xpath("//android.widget.TextView[@text='You made it, click retry if you want to try it again.']"), "Congratulations message");
    private static final Label retry = new Label(By.xpath("//android.view.ViewGroup[@content-desc='button-Retry']/android.view.ViewGroup"), "Retry button");


    private Label puzzleSource(String contentDesc){
        return  new Label(By.xpath(String.format("//android.view.ViewGroup[@content-desc='%s']/android.widget.ImageView",contentDesc)), "Target puzzle piece");
    }
    private Label puzzleDestination(String contentDesc){
        return  new Label(By.xpath(String.format("//android.view.ViewGroup[@content-desc='%s']/android.view.ViewGroup",  contentDesc)), "Puzzle destination");
    }
    private enum SourcePuzzleContentDesc {
        FIRST_PIECE(1, "drag-l2"),
        SECOND_PIECE(2, "drag-r3"),
        THIRD_PIECE(3, "drag-r1"),
        FOURTH_PIECE(4, "drag-c1"),
        FIFTH_PIECE(5, "drag-c3"),
        SIXTH_PIECE(6, "drag-r2"),
        SEVENTH_PIECE(7, "drag-c2"),
        EIGHTH_PIECE(8, "drag-l1"),
        NINTH_PIECE(9, "drag-l3");

        private final int position;
        private final String name;

        SourcePuzzleContentDesc(int position, String name) {

            this.position = position;
            this.name = name;
        }
        public static String getSourceContentDesc(int position){
            SourcePuzzleContentDesc[] puzzleContentDesc = SourcePuzzleContentDesc.values();
            for (SourcePuzzleContentDesc contentDesc : puzzleContentDesc) {
                if ( contentDesc.position == position ) {
                    return contentDesc.name;
                }
            }
            return null;
        }
    }
    private enum DestinationPuzzleContentDesc {

        FIRST_PIECE(1, "drop-l2"),
        SECOND_PIECE(2, "drop-r3"),
        THIRD_PIECE(3, "drop-r1"),
        FOURTH_PIECE(4, "drop-c1"),
        FIFTH_PIECE(5, "drop-c3"),
        SIXTH_PIECE(6, "drop-r2"),
        SEVENTH_PIECE(7, "drop-c2"),
        EIGHTH_PIECE(8, "drop-l1"),
        NINTH_PIECE(9, "drop-l3");

        private final int position;
        private final String name;

        DestinationPuzzleContentDesc(int position, String name) {

            this.position = position;
            this.name = name;
        }
        public static String getDestinationContentDesc(int position){
            DestinationPuzzleContentDesc[] puzzleContentDesc = DestinationPuzzleContentDesc.values();
            for (DestinationPuzzleContentDesc contentDesc : puzzleContentDesc) {
                if ( contentDesc.position == position ) {
                    return contentDesc.name;
                }
            }
            return null;
        }
    }

    private boolean isDragAndDropScreenOpened(){
        try {
            waitUntilElementToVisible(dragAndDropScreen.getWrappedElement(), dragAndDropScreen.getName(), 15);
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean isPuzzleScreen(){
        AppNavigation.navigateToDragAndDropScreen();
        return isDragAndDropScreenOpened();
    }
    public void dragAndDropPuzzlePieces() {

        int length = DestinationPuzzleContentDesc.values().length;
        for (int i = 1; i < length + 1; i++) {
            WebElement source = puzzleSource(SourcePuzzleContentDesc.getSourceContentDesc(i)).getWrappedElement();
            WebElement target = puzzleDestination(DestinationPuzzleContentDesc.getDestinationContentDesc(i)).getWrappedElement();
            ElementUtils.dragAndDrop(source, target);
            Assertions.shouldBeTrue(true, "Dragged and dropped puzzle piece number: " + i);

        }
    }

    public boolean isPuzzleCompleteConfirmationDisplayed(){
        return congratulations.isDisplayed(Duration.ofSeconds(10))
                && congratulationsMsg.isDisplayed(Duration.ofSeconds(10))
                && retry.isDisplayed();
    }
    public boolean clickRetryButton(){
        retry.click();
        return isDragAndDropScreenOpened();
    }
}
