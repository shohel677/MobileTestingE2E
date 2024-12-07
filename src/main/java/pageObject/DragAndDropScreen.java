package pageObject;

import Utils.Label;
import org.openqa.selenium.By;

import static abstractComponents.GenericApp.logger;
import static abstractComponents.WaitUtill.waitUntilElementToVisible;

public class DragAndDropScreen {

    AppNavigation appNavigation = new AppNavigation();

    private static final Label dragAndDropScreen = new Label(By.xpath("//android.widget.TextView[@text='Drag and Drop']"), "Drag and drop screen");


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

        private int position;
        private String name;

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

        private int position;
        private String name;

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

    public boolean isDragAndDropScreen(){
        appNavigation.navigateToDragAndDropScreen();
        try {
            waitUntilElementToVisible(dragAndDropScreen.getWrappedElement(), dragAndDropScreen.getName(), 15);
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            return false;
        }
    }
}
