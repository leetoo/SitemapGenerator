import com.uawebchallenge.common.WebPage;
import com.uawebchallenge.exceptions.InvalidPriorityException;
import org.junit.Test;

public class testWebPage {

    @Test(expected = InvalidPriorityException.class)
    public void testLowPriority(){
        new WebPage.Builder()
                .priority(-1.0)
                .builder();
    }

    @Test(expected = InvalidPriorityException.class)
    public void testHighPriority(){
        new WebPage.Builder()
                .priority(10.0)
                .builder();
    }
}
