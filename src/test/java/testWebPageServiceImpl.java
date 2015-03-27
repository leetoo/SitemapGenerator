import com.uawebchallenge.service.WebPageService;
import com.uawebchallenge.service.WebPageServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    }

    @Test
    public void testCreateSiteMap(){

    }
}
