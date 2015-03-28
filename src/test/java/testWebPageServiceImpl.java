import com.uawebchallenge.service.WebPageService;
import com.uawebchallenge.service.WebPageServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class testWebPageServiceImpl {

    private WebPageService wps;

    @Before
    public void setUp(){
        wps = new WebPageServiceImpl();
    }

    @Test
    public void testValidateURL(){
        String url = "http://dou.ua";
        Boolean expected = wps.validateURL(url);
        assertTrue(expected);
    }

    @Test
    public void testValidateURLNegative(){
        String url = "http://dou";
        Boolean expected = wps.validateURL(url);
        assertFalse(expected);
    }

    @Test
    public void testCreateWebPages(){
        WebPageServiceImpl wpsi = mock(WebPageServiceImpl.class);
        wpsi.createWebPages("http://dou.ua");
        InOrder inOrder = inOrder(wpsi);
        inOrder.verify(wpsi).createWebPages("http://dou.ua");
    }

    @Test
    public void testCreateSiteMap(){
        WebPageServiceImpl wpsi = mock(WebPageServiceImpl.class);
        wpsi.createSiteMap("http://dou.ua");
        InOrder inOrder = inOrder(wpsi);
        inOrder.verify(wpsi).createSiteMap("http://dou.ua");
    }
}
